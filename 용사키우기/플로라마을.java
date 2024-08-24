package 용사키우기;

public class 플로라마을 {
	NPC[] npcs = new NPC[5];
	int [] cnt = {0,0,0,0,0};
	public 플로라마을() {
		npcs[0] = new NPC("데스피아", 404, 404, 404, 404, 404);
		npcs[1] = new NPC("엔머티", 666, 666, 666, 666, 666);
		npcs[2] = new NPC("뤼벤", 1004, 1004, 1004, 1004, 1004);
		npcs[3] = new NPC("프로비소", 8282, 8282, 8282, 8282, 8282);
		npcs[4] = new NPC("노아", 1, 1, 1, 1, 1);
	}

	public void 절망(용사 user) {
		String w = InputClass.print();
	}
	
	public void 증오(용사 user) {
		String w = InputClass.print();
	}
	
	public void 복수(용사 user) {
		String w = InputClass.print();
	}
	
	public void 단서(용사 user) {
		String w = InputClass.print();
	}
	
	public void 열쇠(용사 user) {
		String w = InputClass.print();
	}
	
	public void 싸움(용사 user,int num) {
		while(true) {
			String npc_name = npcs[num].getName();
			int npc_atk = npcs[num].getAtk();
			int npc_hp = npcs[num].getHp();
			int npc_lv = (int) (Math.random() * npcs[num].getLevel()+1);
			int npc_def = npcs[num].getDef();
			int exp = npcs[num].getExp();
			int i, up=0;
			while(true) {
				i = IsMobAlive(num, exp, npc_hp, npc_name, user, cnt);
				if (i == 1) {
					cnt[num]++;
					System.out.println(cnt[num]);
					break;
				}else {
					화면.NPC공격창(npc_name,npc_hp,npc_lv,user,num);
					String w = InputClass.print();
					if(w.equals("1")) {//1.공격 2.회복 3.행동
						if(npc_def>=user.getStat().getAtk()) {
							System.out.println("방어력이 너무 높아서 공격이 통하지 않는다...");
							설정.sleep(1000);
						}else npc_hp -= user.getStat().getAtk();
						up=10;
					}else if(w.equals("2")) {
						user.getStat().setHp(user.getStat().getHp()+100);
						if (user.getStat().getHp() > user.getStat().getMaxHp()) {
							user.getStat().setHp(user.getStat().getMaxHp());
						}
						up=5;
					}else if(w.equals("3")) {
						 int dmg = user.스킬사용();
						 if(npc_def>=dmg) {
							System.out.println("방어력이 너무 높아서 공격이 통하지 않는다...");
							설정.sleep(1000);
						 }else npc_hp -= dmg;
						 up=10;
					}else System.out.println("잘못된 선택을 해버렸다..");
					
					user.getStat().setHp(user.getStat().getHp()-npc_atk);
					user.getStat().setMp(user.getStat().getMp()+up);
				}
			}
			break;
		}
	}
	
	public int IsMobAlive(int n,int exp, int npc_hp, String npc_name, 용사 user,int[] cnt) {
		if (npc_hp <= 0) {
			if (cnt[n] >= 1) {
				user.getStat().setExp(user.getStat().getExp()+0);
			}
			else {
				user.getStat().setExp(user.getStat().getExp()+exp);
			}
			화면.처치창(npc_name, exp, user);
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
