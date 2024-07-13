package 용사키우기;

public class 에테토스마을 {
	NPC[] npcs = new NPC[5];
	int [] cnt = {0,0,0,0,0};
	public 에테토스마을() {
		npcs[0] = new NPC("대장장이", 1600, 700, 999999, 16, 3900);//이름 체력 공격력 방어력 레벨 exp
		npcs[1] = new NPC("포션 상인", 1500, 500, 999999, 15, 100);
		npcs[2] = new NPC("릴리아", 1, 1, 999999, 15, 10000); // 모험가 등록, 퀘스트 받기
		npcs[3] = new NPC("길드장", 3000, 1500, 999999, 30, 1004);
		npcs[4] = new NPC("스레타하", 1, 1, 1, 1, 50000); //검사의 숨겨진 스킬 해금 조건중 하나 
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
		String w = InputClass.print();
		if (w.equals("1")) {
			화면.골목길(user, 2);
			String a = InputClass.print();
		}else if(w.equals("2")) {
			화면.골목길(user, 3);
		}else if(w.equals("3")) {
			화면.골목길(user, 4);
			싸움(user,4);
		}
	}
	
	public void 모험가길드(용사 user) {
		String w = InputClass.print();
		if (w.equals("1")) {
			화면.모험가길드(user, 2);
			if(user.getStat().getJob()=="멸문가 에스토니아의 제 3소공자" || user.getStat().getJob()=="멸문가 에스토니아의 제 3공녀") {
				System.out.println("엥? 모험가님께서는 아직 직업이 없으시네요...");
				설정.sleep(1000);
				System.out.println("어서 직업등록절차를 진행해봅시다><");
				설정.sleep(1000);
				화면.모험가길드(user, 89);
				user.초보();
			}
			
		}else if(w.equals("2")) {
			화면.모험가길드(user, 3);
		}else if(w.equals("3")) {
			화면.모험가길드(user, 4);
		}else if(w.equals("4")) {
			화면.모험가길드(user,5);
			싸움(user,2);
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
			int exp = npcs[num].getExp();
			int i;
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
			break;
		}
	}
	
	public int IsMobAlive(int n,int exp, int npc_hp, String npc_name, 용사 user,int[] cnt) {
		if (npc_hp <= 0) {
			화면.처치창(npc_name, exp, user);
			if (cnt[n] >= 1) {
				user.getStat().setExp(user.getStat().getExp()+0);
			}
			else {
				user.getStat().setExp(user.getStat().getExp()+exp);
			}
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
