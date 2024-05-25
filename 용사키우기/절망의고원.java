package 용사키우기;

public class 절망의고원 {
	몬스터[] mops = new 몬스터[6];
	화면 화면 = new 화면();
	public 절망의고원() {
		mops[0] = new 몬스터("어린 고스트", 50, 5, 23, 20, 5);//이름, 체력, 공격력, (최대)레벨, 최대경험치, 최소경험치
		mops[1] = new 몬스터("성인 고스트", 80, 8, 26, 20, 8);
		mops[2] = new 몬스터("기사 고스트", 400, 30, 5, 70, 20);
		mops[3] = new 몬스터("좀비", 1100, 50, 33, 100, 70);
		mops[4] = new 몬스터("사이론", 1100, 50, 39, 100, 70);
		mops[5] = new 몬스터("세라", 1100, 50, 40, 100, 70);
	}
	
	public void 행동(용사 user) {
		int num = 0;
		if(user.stat.level <= 3) {
			num = (int) (Math.random() * 2);
		}else if (user.stat.level <= 9) {
			num = (int) (Math.random() * 3);
		}else {
			num = (int) (Math.random() * 4);
		}
		String mop_name = mops[num].getName();
		int mop_atk = mops[num].getAtk();
		int mop_hp = mops[num].getHp();
		int mop_lv = mops[num].getLevel();
		int max = mops[num].getMaxexp();
		int min = mops[num].getMinexp();
		int exp = (int) (Math.random() * (max-min+1) + min);
		int i;
		while(true) {
			i = IsMobAlive(exp, mop_hp, mop_name, user);
			if (i == 1) {
				break;
			}else {
				화면.공격창(mop_name,mop_hp,mop_lv,user);
				String w = InputClass.print();
				if(w.equals("1")) {//1.공격 2.회복 3.행동
					mop_hp -= user.stat.atk;
				}else if(w.equals("2")) {
					user.stat.hp+=100;
				}else if(w.equals("3")) {
					
				}else System.out.println("잘못된 선택을 해버렸다..");
				
				user.stat.hp -= mop_atk;
			}
		}
	}
	
	public int IsMobAlive(int mop_exp, int mop_hp, String mop_name, 용사 user) {
		if (mop_hp <= 0) {
			화면.처치창(mop_name, mop_exp, user);
			user.stat.exp += mop_exp;
			return 1;
		}else if (user.stat.hp <= 0) {
			화면.게임오버창();
			return 1;
		}else return 0; 
	}
}
