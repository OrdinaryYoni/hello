package 용사키우기;

public class 에테토스마을 {
	NPC[] npcs = new NPC[5];
	public 에테토스마을() {
		npcs[0] = new NPC("대장장이", 1600, 700, 999999, 16);//이름 체력 공격력 방어력 레벨
		npcs[1] = new NPC("포션 상인", 1500, 500, 999999, 15);
		npcs[2] = new NPC("릴리아", 1, 1, 999999, 15); // 모험가 등록, 퀘스트 받기
		npcs[3] = new NPC("길드장", 3000, 1500, 999999, 30);
		npcs[4] = new NPC("스레타하", 1, 1, 1, 1); //검사의 숨겨진 스킬 해금 조건중 하나
	}
	
	public void 대장간(용사 user) {
		String w = InputClass.print();
		if (w.equals("1")) {
			화면.대장간(user, 2);
			String a = InputClass.stringInput("무엇을 살거냐? ");
		}else if(w.equals("2")) {
			화면.대장간(user, 3);
		}else if(w.equals("3")) {
			화면.대장간(user, 4);
		}else {
			화면.대장간(user,5);
			싸움(user,0);
		}
	}
	
	public void 잡화점(용사 user) {
		
	}
	
	public void 골목길(용사 user) {
		
	}
	
	public void 모험가길드(용사 user) {
		String w = InputClass.print();
		if (w.equals("1")) {
			화면.모험가길드(user, 2);
		}else if(w.equals("2")) {
			화면.모험가길드(user, 3);
		}else if(w.equals("3")) {
			화면.모험가길드(user, 4);
		}else {
			화면.모험가길드(user,5);
			싸움(user,0);
		}
	}
	
	public void 왕궁(용사 user) {
		
	}
	
	public void 싸움(용사 user,int num) {
		while(true) {
			String npc_name = npcs[num].getName();
			int npc_atk = npcs[num].getAtk();
			int npc_hp = npcs[num].getHp();
			int npc_lv = (int) (Math.random() * npcs[num].getLevel()+1);
			int npc_def = npcs[num].getDef();
			int exp = 50000;
			int i;
			while(true) {
				i = IsMobAlive(exp, npc_hp, npc_name, user);
				if (i == 1) {
					break;
				}else {
					화면.NPC공격창(npc_name,npc_hp,npc_lv,user,num);
					String w = InputClass.print();
					if(w.equals("1")) {//1.공격 2.회복 3.행동
						if(npc_def>=user.getStat().getAtk()) {
							System.out.println("방어력이 너무 높아서 공격이 통하지 않는다...");
							설정.sleep(1000);
						}else npc_hp -= user.getStat().getAtk();
					}else if(w.equals("2")) {
						user.getStat().setHp(user.getStat().getHp()+100);
						if (user.getStat().getHp() > user.getStat().getMaxHp()) {
							user.getStat().setHp(user.getStat().getMaxHp());
						}
					}else if(w.equals("3")) {
						 int dmg = user.스킬사용();
						 if(npc_def>=dmg) {
							System.out.println("방어력이 너무 높아서 공격이 통하지 않는다...");
							설정.sleep(1000);
						 }else npc_hp -= dmg;
					}else System.out.println("잘못된 선택을 해버렸다..");
					
					user.getStat().setHp(user.getStat().getHp()-npc_atk);
				}
			}
			if (user.getStat().getHp() > 0) {
				String yn = InputClass.stringInput("계속 사냥할까?(y/n) ");
				if (yn.equals("n")) break;
			}else break;
		}
	}
	
	public int IsMobAlive(int exp, int npc_hp, String npc_name, 용사 user) {
		if (npc_hp <= 0) {
			화면.처치창(npc_name, exp, user);
			user.getStat().setExp(user.getStat().getExp()+exp);
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
