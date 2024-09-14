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
		if(cnt[0]==0) {
			if(w.equals("1")) {
				System.out.println("먹어본 것 같은 맛이다...?");
				설정.sleep(1000);//256200
				System.out.println("10000 경험치를 얻었다.");
				설정.sleep(1000);
				user.getStat().setExp(user.getStat().getExp()+10000);
				user.getStat().레벨업();
				cnt[0]+=1;
			}else if(w.equals("2")) {
				System.out.println(설정.BLACK_BACKGROUND_BRIGHT+"젊은이여 앞으로 나아가도 좋다."+설정.exit);
				설정.sleep(1000);
				System.out.println("왠지 편안해졌다.");
				설정.sleep(1000);
				System.out.println("20000 경험치를 얻었다.");
				설정.sleep(1000);
				user.getStat().setExp(user.getStat().getExp()+20000);
				user.getStat().레벨업();
				cnt[0]+=1;
			}else {
				System.out.println(설정.BLACK_BACKGROUND_BRIGHT+"어리석구나"+설정.exit);
				설정.sleep(500);
				싸움(user,0);
			}
		}else System.out.println("어? 자세히보니 그냥 옛날 그림이다."); 설정.sleep(1000);
	}
	
	public void 증오(용사 user) {
		String w = InputClass.print();
		if(cnt[1]==0) {
			if(w.equals("1")) {
				if(user.getStat().getCompleteQuest().indexOf("증오가 날 감싸네") != -1) {
					System.out.println(설정.back_black+설정.purple+"뭐든지... 죽이고 싶어..."+설정.exit);
					설정.sleep(1000);
					user.getStat().setSkill("에스토니아의 비명");
					System.out.println("30000 경험치를 얻었다.");
					user.getStat().setExp(user.getStat().getExp()+30000);
				}else {
					System.out.println("맛없다...");
					설정.sleep(1000);
					System.out.println("20000 경험치를 얻었다.");
					user.getStat().setExp(user.getStat().getExp()+20000);
				}//256200
				설정.sleep(1000);
				cnt[1]+=1;
				user.getStat().레벨업();
			}else if(w.equals("2")) {
				System.out.println(설정.BLACK_BACKGROUND_BRIGHT+"하하하 착한 멍청아 가라!"+설정.exit);
				설정.sleep(1000);
				System.out.println("뭐지...? 몸이 가볍다!");
				user.getStat().setPlusAtk(2000);
				설정.sleep(1000);
				System.out.println("20000 경험치를 얻었다.");
				설정.sleep(1000);
				user.getStat().setExp(user.getStat().getExp()+20000);
				user.getStat().레벨업();
				cnt[1]+=1;
			}else {
				System.out.println(설정.back_black+설정.purple+"이런... 그냥 멍청이였나?"+설정.exit);
				설정.sleep(500);
				싸움(user,1);
			}
		}else System.out.println("어? 자세히보니 그냥 옛날 그림이다."); 설정.sleep(1000);
	}
	
	public void 복수(용사 user) {
		String w = InputClass.print();
		if(cnt[2]==0) {
			if(w.equals("1")) {
				System.out.println("우욱... 독이 들었나...?");
				설정.sleep(1000);//256200
				System.out.println("점점 의식이 흐려져...");
				user.getStat().setHp(0);
				설정.sleep(1000);
				cnt[2]+=1;
			}else if(w.equals("2")) {
				System.out.println(설정.BLACK_BACKGROUND_BRIGHT+"흥, 시시하군.."+설정.exit);
				설정.sleep(1000);
				System.out.println("정신이 맑아졌다...?");
				user.getStat().setDef(user.getStat().getDef()+1000);
				설정.sleep(1000);
				System.out.println("100000 경험치를 얻었다.");
				설정.sleep(1000);
				user.getStat().setExp(user.getStat().getExp()+100000);
				user.getStat().레벨업();
				cnt[2]+=1;
			}else {
				System.out.println(설정.back_black+설정.red+"어리석구나"+설정.exit);
				설정.sleep(500);
				싸움(user,2);
			}
		}else System.out.println("어? 자세히보니 그냥 옛날 그림이다."); 설정.sleep(1000);
	}
	
	public void 단서(용사 user) {
		String w = InputClass.print();
		if(cnt[3]==0) {
			if(w.equals("1")) {
				System.out.println("달콤하니 꽤나 맛있다!");
				설정.sleep(1000);//256200
				System.out.println("5000 경험치를 얻었다.");
				설정.sleep(1000);
				user.getStat().setExp(user.getStat().getExp()+5000);
				user.getStat().레벨업();
				cnt[3]+=1;
			}else if(w.equals("2")) {
				System.out.println(설정.BLACK_BACKGROUND_BRIGHT+"앞으로 나올 몬스터들의 속마음을 잘 보시길..."+설정.exit);
				설정.sleep(1000);
				System.out.println("달콤한 냄새가 난다!");
				설정.sleep(1000);
				System.out.println("30000 경험치를 얻었다.");
				설정.sleep(1000);
				user.getStat().setExp(user.getStat().getExp()+30000);
				user.getStat().레벨업();
				cnt[3]+=1;
			}else {
				System.out.println(설정.YELLOW_BACKGROUND_BRIGHT+설정.RED_BRIGHT+"어리석구나"+설정.exit);
				설정.sleep(500);
				싸움(user,3);
			}
		}else System.out.println("어? 자세히보니 그냥 옛날 그림이다."); 설정.sleep(1000);
	}
	
	public void 열쇠(용사 user) {
		String w = InputClass.print();
		if(cnt[4]==0) {
			if(w.equals("1")) {
				System.out.println("마무맛돔 만남담.");
				설정.sleep(1000);//256200
				System.out.println("혐미 마미됨 검 감담.");
				설정.sleep(1000);
				System.out.println("10 경험치를 얻었다.");
				설정.sleep(1000);
				user.getStat().setExp(user.getStat().getExp()+10);
				user.getStat().레벨업();
				cnt[4]+=1;
			}else if(w.equals("2")) {
				System.out.println(설정.BLACK_BACKGROUND_BRIGHT+"다인을 조심해."+설정.exit);
				설정.sleep(1000);
				System.out.println("80000 경험치를 얻었다.");
				설정.sleep(1000);
				user.getStat().setExp(user.getStat().getExp()+30000);
				user.getStat().레벨업();
				cnt[4]+=1;
			}else {
				System.out.println(설정.YELLOW_BACKGROUND_BRIGHT+설정.RED_BRIGHT+"어리석구나"+설정.exit);
				설정.sleep(500);
				싸움(user,3);
			}
		}else System.out.println("어? 자세히보니 그냥 옛날 그림이다."); 설정.sleep(1000);
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
					}else System.out.println("잘못된 선택을 해버렸다.."); 설정.sleep(500);
					
					if(user.getStat().getDef() >= npc_atk) {
						System.out.println("방어력이 높아서 공격이 통하지 않았다!");
						설정.sleep(1000);
					}else user.getStat().setHp(user.getStat().getHp()-(npc_atk-user.getStat().getDef()));
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
