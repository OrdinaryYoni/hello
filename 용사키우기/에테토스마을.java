package 용사키우기;

public class 에테토스마을 {
	NPC[] npcs = new NPC[5];
	int [] cnt = {0,0,0,0,0};
	String[] mugi = {"도끼","식칼","검","쌍검","비검","간지"};
	public 에테토스마을() {
		npcs[0] = new NPC("대장장이", 1600, 700, 999999, 16, 3900);//이름 체력 공격력 방어력 레벨 exp
		npcs[1] = new NPC("잡화상인", 1, 1, 1, 1, 50000);
		npcs[2] = new NPC("릴리아", 1, 1, 999999, 15, 10000); // 모험가 등록, 퀘스트 받기
		npcs[3] = new NPC("자이로스 국왕", 1, 1, 1, 999999, 1);
		npcs[4] = new NPC("스레타하", 1, 1, 1, 1, 50000); //검사의 숨겨진 스킬 해금 조건중 하나 
	}
	
	public void 대장간(용사 user) {
		if(cnt[0]==0) {
			스탯 u = user.getStat();
			String w = InputClass.print();
			if (w.equals("1")) {
				화면.대장간(user, 2);
				int a = InputClass.intInput("무엇을 살거냐? ");
				String msg = "아무키나 누른후 enter해서 종료";
				int money = 0;
				if(a==1) {
					System.out.println("아 그것은 나무꾼의 도끼란다~ 내가 금도끼 은도끼를 보고 따라 만들었어~");
					msg = "공격력은 +100이고 가격은 1000원이야! 살꺼야?(y/n) ";
					money = 1000;
				}else if(a==2) {
					System.out.println("아 그것은 식칼이야! 요리할 때 잘 썰려서 좋을꺼야!");
					msg = "공격력은 +200이고 가격은 2000원이야! 살꺼야?(y/n) ";
					money = 2000;
				}else if(a==3) {
					System.out.println("아 그것은 전설의 용사의 검....!의 모조품이야.");
					msg = "공격력은 +500이고 가격은 5000원이야! 살꺼야?(y/n) ";
					money = 5000;
				}else if(a==4) {
					System.out.println("아 그것은 쌍쌍바가 먹고 싶어서 만든 쌍쌍검이야.");
					msg = "공격력은 +600이고 가격은 6000원이야! 살꺼야?(y/n) ";
					money = 6000;
				}else if(a==5) {
					System.out.println("아 그것은 먼 나라에서 가져온 비검이야.");
					msg = "공격력은 +1000이고 가격은 10000원이야! 살꺼야?(y/n) ";
					money = 10000;
				}else if(a==6) {
					System.out.println("그건 그냥 멋있는 검... 간zㅣ나잖냐~");
					msg = "공격력은 +100이고 가격은 15000원이야! 살꺼야?(y/n) ";
					money = 15000;
				}else System.out.println("? 그런 검도 있던가..?");
				String b = InputClass.stringInput(msg);
				if(b.equals("y") && user.getStat().getMoney() >= money) {
					user.getStat().setBag(user.getStat().getBag() + mugi[a-1]);
					user.getStat().setMoney(user.getStat().getMoney()-money);
					System.out.println("하하하! 고맙구나!");
				}else System.out.println("? 안 살꺼면 나가!");
				설정.sleep(1500);
			}else if(w.equals("2")) {
				화면.대장간(user, 3);
			}else if(w.equals("3")) {
				if(u.getLevel() > 40 && u.getCompleteQuest().indexOf("대장장이의 부탁") == -1) {
					if (u.getBag().indexOf("엘리벳의눈물") != -1) {
						화면.대장간(user, 6);
						u.setBag(u.getBag().replace("엘리벳의눈물 ", ""));
						u.setMoney(u.getMoney()+2000);
						u.setQuest("마왕의 모략");
						u.setCompleteQuest("대장장이의 부탁 ");
					}else if (u.getQuest().equals("엄숨")) {
						화면.대장간(user, 5);
						u.setQuest("대장장이의 부탁");
					}else {
						System.out.println("이미 하고 있는 퀘스트가 있다...");
						설정.sleep(1300);
					}
				}else {
					화면.대장간(user, 4);
				}
			}else {
				화면.대장간(user,7);
				싸움(user,0);
			}
		}else {
			System.out.println(설정.back_black+설정.purple+"이미 죽였다.."+설정.exit);
			설정.sleep(1500);
		}
		
	}
	
	public void 잡화점(용사 user) {
		if(user.getStat().getLevel()>=50) {
			if(cnt[1]==0) {
				화면.잡화점(user,1);
				String w = InputClass.print();
				if (w.equals("1")) {
					화면.잡화점(user, 2);
					String a = InputClass.print();
					System.out.println("자 여기 있는 것들 다 공짜양~~~");
					설정.sleep(1300);
					System.out.println("(자세히 보니 다 털뭉치이다...)");
					설정.sleep(1300);
					System.out.println("(밖으로 가지고 나왔더니 다 풀려버렸다...)");
					설정.sleep(1300);
				}else if(w.equals("2")) {
					화면.잡화점(user, 3);
					String a = InputClass.print();
					if(a.equals("1")) {
						화면.잡화상대화(user,1);
						if (user.getStat().getQuest().equals("타락의 길")) {
							user.getStat().setCompleteQuest(user.getStat().getCompleteQuest()+"타락의 길 ");
							user.getStat().setQuest("엄숨");
						}
					}else if (a.equals("2")) {
						화면.잡화상대화(user,2);
					}else {
						화면.잡화상대화(user,3);
					}
				}else if(w.equals("3")) {
					화면.잡화점(user, 4);
					싸움(user,1);
				}else {
					화면.잡화점(user,5);
					싸움(user,1);
				}
			}else {
				System.out.println(설정.back_black+설정.purple+"이미 죽였다.."+설정.exit);
				설정.sleep(1500);
			}
		}else {
			System.out.println("앗.. 문이 닫혀있다..");
			설정.sleep(1000);
		}
	}
	
	public void 골목길(용사 user) {
		if(cnt[4]==0) {
			if(user.getStat().getCompleteQuest().indexOf("절망의 길") != -1) {
				System.out.println(설정.back_black+설정.purple+"기다리고 있었습니다. 증오의 신이시여... 가시지요.."+설정.exit);
				설정.sleep(1000);
				user.getStat().setPlace("데스필교");
			}else {
				String w = InputClass.print();
				if (w.equals("1")) {
					화면.골목길(user, 2);
					String a = InputClass.print();
					if(a.equals("1")) {
						화면.스레타하(user, 1);
					}else if(a.equals("2")) {
						화면.스레타하(user, 2);
					}else if(a.equals("3")) {
						if(user.getStat().getJob().equals("검사")) {
							화면.스레타하(user, 3);
							user.getStat().setPlace("데스필교");
						}else {
							System.out.println(설정.back_black+설정.purple+"자격도 없는 놈이군."+설정.exit);
							설정.sleep(1000);
						}
					}else 화면.스레타하(user, 89);
				}else if(w.equals("2")) {
					화면.골목길(user, 3);
				}else if(w.equals("3")) {
					화면.골목길(user, 4);
					싸움(user,4);
				}
			}
			
		}else {
			System.out.println("아까 해치웠다.");
			설정.sleep(1000);
		}
	}
	
	public void 모험가길드(용사 user) {
		if(cnt[2]==0) {
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
		}else {
			System.out.println(설정.back_black+설정.purple+"이미 죽였다.."+설정.exit);
			설정.sleep(1500);
		}
	}
	
	public void 왕궁(용사 user) {
		if(cnt[3]==0) {
			if(user.getStat().getCompleteQuest().indexOf("증오가 날 감싸네") != -1) {
				화면.왕궁(user, 3);
				cnt[3]++;
			}else if(user.getStat().getLevel() >= 51) {
				화면.왕궁(user, 2);
			}else {
				화면.왕궁(user, 1);
			}
		}else {
			System.out.println(설정.back_black+설정.purple+"맛있었다."+설정.exit);
			설정.sleep(1500);
		}
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
						if (user.getStat().getMp() < user.getStat().getMaxMp()) {up=10;}
					}else if(w.equals("2")) {
						if (user.getStat().getMp() >= 5) {
							if (user.getStat().getHp() < user.getStat().getMaxHp()) {
								up=-5;
								user.getStat().setHp(user.getStat().getHp()+100);
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
						 if(npc_def>=dmg) {
							System.out.println("방어력이 너무 높아서 공격이 통하지 않는다...");
							설정.sleep(1000);
						 }else npc_hp -= dmg;
						 if (user.getStat().getMp() < user.getStat().getMaxMp()) {up=10;}
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
			user.getStat().setExp(user.getStat().getExp()+exp);
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
