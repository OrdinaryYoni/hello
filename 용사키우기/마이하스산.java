package 용사키우기;

public class 마이하스산 {
	몬스터[] mops = new 몬스터[4];
	public 마이하스산() {
		mops[0] = new 몬스터("하급 마족", 9000, 900, 45, 4500, 4500);//이름, 체력, 공격력, (최대)레벨, 최대경험치, 최소경험치
		mops[1] = new 몬스터("중급 마족", 11000, 950, 55, 5000, 4500);
		mops[2] = new 몬스터("마이하스 베어", 15000, 1100, 58, 6000, 6000);
		mops[3] = new 몬스터("단테", 20000, 2000, 60, 7000, 7000);
	}
	
	public void 사냥(용사 user) {
		while(true) {
			int num;
			if(user.getStat().getLevel() <= 45) {
				num = 0;
			}else if (user.getStat().getLevel() <= 55) {
				num = (int) (Math.random() * 2);
			}else if (user.getStat().getLevel() <= 58) {
				num = (int) (Math.random() * 3);
			}else {
				num = 3;
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
						if (user.getStat().getMp() < user.getStat().getMaxMp()) {up=30;}
					}else if(w.equals("2")) {
						if (user.getStat().getMp() >= 5) {
							if (user.getStat().getHp() < user.getStat().getMaxHp()) {
								up=-5;
								user.getStat().setHp(user.getStat().getHp()+2000);
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
						if (user.getStat().getMp() < user.getStat().getMaxMp()) {up=30;}
					}else System.out.println("잘못된 선택을 해버렸다..");
					
					if(user.getStat().getDef() >= mop_atk) {
						System.out.println("방어력이 높아서 공격이 통하지 않았다!");
						설정.sleep(1000);}
					else user.getStat().setHp(user.getStat().getHp()-(mop_atk - user.getStat().getDef()));
					
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
		if(user.getStat().getQuest().equals("대장장이의 부탁")) user.getStat().setBag(user.getStat().getBag() + "엘리벳의눈물 ");
		
	}
}
