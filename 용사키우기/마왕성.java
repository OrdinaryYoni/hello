package 용사키우기;

public class 마왕성 {
	몬스터 devil = new 몬스터("마왕 에테토스",1000000,5000,100,66666666,66666666);//이름, 체력, 공격력, (최대)레벨, 최대경험치, 최소경험치
	
	public void 사냥(용사 user) {
		while(true) {
			String mop_name = devil.getName();
			int mop_atk = devil.getAtk();
			int mop_hp = devil.getHp();
			int mop_lv = devil.getLevel();
			int exp = devil.getMaxexp();
			int i, up=0;
			int mop_mp = 0;
			while(true) {
				i = IsMobAlive(exp, mop_hp, mop_name, user);
				if (i == 1) {
					break;
				}else {
					화면.공격창(mop_name,mop_hp,mop_lv,user);
					String w = InputClass.print();
					if(w.equals("1")) {//1.공격 2.회복 3.행동
						mop_hp -= user.getStat().getAtk();
						up=50;
					}else if(w.equals("2")) {
						user.getStat().setHp(user.getStat().getHp()+6000);//여기 잠깐 개발자모드ㅋㅋ
						if (user.getStat().getHp() > user.getStat().getMaxHp()) {
							user.getStat().setHp(user.getStat().getMaxHp());
						}
						up=5;
					}else if(w.equals("3")) {
						 int dmg = user.스킬사용();
						 mop_hp -= dmg;	
						 up=50;
					}else System.out.println("잘못된 선택을 해버렸다..");
					
					if(mop_mp >= 400) {
						System.out.println(설정.back_black+설정.red+"[\"모든 생물을 멸하리!\"]"+설정.exit);
						설정.sleep(500);
						user.getStat().setHp(user.getStat().getHp()-(10000-user.getStat().getDef()));
						mop_mp = 0;
					}else {
						user.getStat().setHp(user.getStat().getHp()-(mop_atk-user.getStat().getDef()));
						mop_mp+=40;
					}
					user.getStat().setMp(user.getStat().getMp()+up);
				}
			}break;
		}
	}
	
	public int IsMobAlive(int mop_exp, int mop_hp, String mop_name, 용사 user) {
		if (mop_hp <= 0) {
			화면.처치창(mop_name, mop_exp, user);
			if (user.getStat().getCompleteQuest().indexOf("증오가 날 감싸네") != -1) user.setEnd(2);
			else if (user.getStat().getCompleteQuest().indexOf("마왕의 모략") != -1) user.setEnd(4);
			else user.setEnd(3);
			user.getStat().setExp(user.getStat().getExp()+mop_exp);
			user.getStat().레벨업();
			return 1;
		}else if (user.getStat().getHp() <= 0) {
			user.setEnd(1);
			return 1;
		}else return 0; 
	}
}
