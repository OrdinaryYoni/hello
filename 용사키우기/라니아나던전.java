package 용사키우기;

public class 라니아나던전 {
	몬스터[] mops = new 몬스터[4]; //오크, 미네린, 하데론, 오크 왕
	화면 화면 = new 화면();
	public 라니아나던전() {
		mops[0] = new 몬스터("오크", 1500, 70, 12, 200, 150);//이름, 체력, 공격력, (최대)레벨, 최대경험치, 최소경험치
		mops[1] = new 몬스터("미네린", 2000, 100, 15, 250, 200);
		mops[2] = new 몬스터("하데론", 2300, 200, 18, 300, 250);
		mops[3] = new 몬스터("오크 왕", 3000, 300, 20, 300, 300);
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