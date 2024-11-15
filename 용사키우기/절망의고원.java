package 용사키우기;

public class 절망의고원 {
	몬스터[] mops = new 몬스터[6];
	public 절망의고원() {
		mops[0] = new 몬스터("어린 고스트", 3500, 300, 23, 1500, 1500);//이름, 체력, 공격력, (최대)레벨, 최대경험치, 최소경험치
		mops[1] = new 몬스터("성인 고스트", 4000, 369, 26, 2000, 1800);
		mops[2] = new 몬스터("기사 고스트", 4500, 400, 30, 3000, 2900);
		mops[3] = new 몬스터("좀비", 6000, 200, 33, 3500, 3400);
		mops[4] = new 몬스터("사이론", 3000, 600, 39, 3600, 3600);
		mops[5] = new 몬스터("세라", 10000, 1000, 40, 5000, 5000);
	}
	
	public void 사냥(용사 user) {
		while(true) {
			int num;
			if(user.getStat().getLevel() <= 23) {
				num = 0;
			}else if (user.getStat().getLevel() <= 26) {
				num = (int) (Math.random() * 2);
			}else if (user.getStat().getLevel() <= 30) {
				num = (int) (Math.random() * 3);
			}else if (user.getStat().getLevel() <= 33) {
				num = (int) (Math.random() * 4);
			}else if (user.getStat().getLevel() <= 39) {
				num = (int) (Math.random() * 5);
			}else {
				num = 5;
			}
			String mop_name = mops[num].getName();
			int mop_atk = mops[num].getAtk();
			int mop_hp = mops[num].getHp();
			int mop_lv = (int) (Math.random() * mops[num].getLevel()+1);
			int max = mops[num].getMaxexp();
			int min = mops[num].getMinexp();
			int exp = (int) (Math.random() * (max-min+1) + min);
			int i, up=0;
			while(true) {
				i = IsMobAlive(exp, mop_hp, mop_name, user);
				if (i == 1) {
					break;
				}else {
					화면.공격창(mop_name,mop_hp,mop_lv,user);
					String w = InputClass.print();
					if(w.equals("1")) {//1.공격 2.회복 3.행동
						mop_hp -= user.getStat().getAtk();
						if (user.getStat().getMp() < user.getStat().getMaxMp()) {up=20;}
					}else if(w.equals("2")) {
						if (user.getStat().getMp() >= 5) {
							if (user.getStat().getHp() < user.getStat().getMaxHp()) {
								up=-5;
								user.getStat().setHp(user.getStat().getHp()+1100);
							}else {
								System.out.println("체력이 너무 많다..."); 
								설정.sleep(500);
							}
						}else {
							System.out.println("Mp가 부족하다..."); 
							up=0; 
							설정.sleep(500);
							}
					}else if(w.equals("3")) {
						int dmg = user.스킬사용();
						mop_hp -= dmg;
						if (user.getStat().getMp() < user.getStat().getMaxMp()) {up=20;}
					}else System.out.println("잘못된 선택을 해버렸다..");
					
					if(user.getStat().getDef() > mop_atk) {
						System.out.println("방어력이 높아서 공격이 통하지 않았다!");
						설정.sleep(1000);
					}else user.getStat().setHp(user.getStat().getHp()-(mop_atk-user.getStat().getDef()));
					user.getStat().setMp(user.getStat().getMp()+up);
				}
			}
			if (user.getStat().getHp() > 0) {
				String yn = InputClass.stringInput("계속 사냥할까?(y/n) ");
				if (yn.equals("n")) {
					user.getStat().setHp(user.getStat().getMaxHp());
					user.getStat().setMp(user.getStat().getMaxMp());
					break;
				}
			}else break;
		}
	}
	
	public int IsMobAlive(int mop_exp, int mop_hp, String mop_name, 용사 user) {
		if (mop_hp <= 0) {
			화면.처치창(mop_name, mop_exp, user);
			user.getStat().setExp(user.getStat().getExp()+mop_exp);
			user.getStat().레벨업();
			return 1;
		}else if (user.getStat().getHp() <= 0) {
			화면.게임오버창();
			return 1;
		}else return 0; 
	}
	
	public void 채집(용사 user) {
		화면.채집창(user);
	}
}
