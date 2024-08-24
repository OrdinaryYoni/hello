package 용사키우기;

public class 진실의서재 {
	몬스터[] mops = new 몬스터[4];
	public 진실의서재() {
		mops[0] = new 몬스터("조심해", 2, 2000, 0, 1000, 900);//이름, 체력, 공격력, (최대)레벨, 최대경험치, 최소경험치
		mops[1] = new 몬스터("목", 3, 3000, 0, 1500, 1400);
		mops[2] = new 몬스터("마왕", 1, 1000, 0, 2000, 1900);
		mops[3] = new 몬스터("아름다운것", 4, 4000, 0, 2500, 2500);
	}
	
	public void 사냥(용사 user) {
		while(true) {
			int num = 0;
			if(user.getStat().getLevel() <= 45) {
				num = 1;
			}else if (user.getStat().getLevel() <= 55) {
				num = (int) (Math.random() * 2);
			}else if (user.getStat().getLevel() <= 58) {
				num = (int) (Math.random() * 3);
			}else {
				num = (int) (Math.random() * 4);
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
						up=30;
					}else if(w.equals("2")) {
						user.getStat().setHp(user.getStat().getHp()+2000); //응 개발자 모드~
						if (user.getStat().getHp() > user.getStat().getMaxHp()) {
							user.getStat().setHp(user.getStat().getMaxHp());
						}
						up=5;
					}else if(w.equals("3")) {
						int dmg = user.스킬사용();
						mop_hp -= dmg;
						up=30;
					}else System.out.println("잘못된 선택을 해버렸다..");
					
					user.getStat().setHp(user.getStat().getHp()-mop_atk);
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
	
	public void 채집(용사 용사) {
		
	}
}
