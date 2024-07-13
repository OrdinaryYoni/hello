package 용사키우기;

public class 용사 extends 캐릭터 implements 스킬, 호칭 {
	private 스탯 stat;
	private 서쪽숲 숲 = new 서쪽숲();
	private 라니아나던전 던전 = new 라니아나던전();
	private 절망의고원 고원 = new 절망의고원();
	private 마이하스산 산 = new 마이하스산();
	private 에테토스마을 마을 = new 에테토스마을();
	private int end = 0;
	public 용사() {
		String name = InputClass.stringInput("용사의 이름을 지어주세요! ");
		String gender = InputClass.stringInput(name+"님의 성별은 무엇인가요?(남/여) ");
		stat = new 스탯(name,gender);
	}
	
	public void 이동() {
		화면.이동창(stat.getLevel());
		int w = InputClass.intInput("어디를 갈까? ");
		if (stat.getLevel() >= 100) stat.setPlace("마왕성");
		if(w == 1) {
			stat.setPlace("부서진 에스토니아의 성");
			화면.장소(w);
		}else if(w==2) {
			stat.setPlace("서쪽 숲");
			화면.장소(w);
		}else if(w==3 && stat.getLevel() > 10) {
			stat.setPlace("에테토스 마을");
		}else if(w==4 && stat.getLevel() > 10) {
			stat.setPlace("라니아나 던전");
		}else if(w==5 && stat.getLevel() > 20) {
			stat.setPlace("절망의 고원");
		}else if(w==6 && stat.getLevel() > 40) {
			stat.setPlace("마이하스산");
		}else if(w==7 && stat.getLevel() > 40) {
			stat.setPlace("채석장");
		}else if(w==8 && stat.getLevel() > 60) {
			stat.setPlace("플로라 마을");
		}else if(w==9 && stat.getLevel() > 60) {
			stat.setPlace("진실의 서재");
		}else if(w==10 && stat.getLevel() > 80) {
			stat.setPlace("이실리아 세계수");
		}else System.out.println("그런 곳은 없어!"); 설정.sleep(600);
	}
	
	public void 가방() {
		화면.가방창();
		
	}
	
	public void 행동() {
		if(stat.getPlace().equals("에테토스 마을")) {
			화면.마을행동창(this);
			String w = InputClass.print();
			if(w.equals("1")) {
				화면.대장간(this,1);
				마을.대장간(this);
			}else if(w.equals("2")) {
				화면.잡화점(this);
				마을.잡화점(this);
			}else if(w.equals("3")) {
				화면.골목길(this,1);
				마을.골목길(this);
			}else if(w.equals("4")) {
				화면.모험가길드(this,1);
				마을.모험가길드(this);
			}else if(w.equals("5")) {
				화면.왕궁(this);
				마을.왕궁(this);
			}
		}else {
			화면.행동창();
			int w = InputClass.intInput("무엇을 할까? ");
			if(w == 1) {
				if(stat.getPlace().equals("서쪽 숲")) {
					숲.사냥(this);
				}else if(stat.getPlace().equals("라니아나 던전")) {
					던전.사냥(this);
				}else if(stat.getPlace().equals("절망의 고원")) {
					고원.사냥(this);
				}else if(stat.getPlace().equals("마이하스산")) {
					산.사냥(this);
				}
				else {
					System.out.println("잡을 몹들이 없다.");
				}
			}else if(w == 2) {
				if(stat.getPlace().equals("서쪽 숲")) {
					숲.채집(this);
				}else if(stat.getPlace().equals("라니아나 던전")) {
					던전.채집(this);
				}else if(stat.getPlace().equals("절망의 고원")) {
					고원.채집(this);
				}else if(stat.getPlace().equals("마이하스산")) {
					산.채집(this);
				}
				else {
					System.out.println("여긴 어디지? 다시 돌아가야겠다.");
				}
			}else if (w == 3) {
				System.out.println("웅애");
				설정.sleep(1000);
			}else System.out.println("빙글빙글..."); 설정.sleep(1000);
			
			
		}
		
	}

	public void 회복() {
		
	}
	
	public int 스킬사용() {
		int dmg = 0;
		int w;
		if(stat.getLevel() < 10) {
			dmg = 기본();
		}else {
			if(stat.getJob().equals("검사")) {
				if(stat.getSkill().equals("에스토니아의 비명")) {
					w = InputClass.intInput("1.제국의 검  2.에스토니아의 비명");
					if(w==1) dmg = 제국의검();
					else dmg = 에스토니아의비명();
				}else dmg = 제국의검();
			}else if(stat.getJob().equals("궁수")) {
				if(stat.getSkill().equals("에비나투르")) {
					w = InputClass.intInput("1.활의 노래  2.에비나투르");
					if(w==1) dmg = 활의노래();
					else dmg = 에비나투르();
				}else dmg = 활의노래();
			}else if(stat.getJob().equals("마법사")) {
				if(stat.getSkill().equals("정령들")) {
					w = InputClass.intInput("1.화염의 정령  2.물의 정령  3.자연의 정령");
					if(w==1) dmg = 화염의정령();
					else if(w==2) dmg = 물의정령();
					else dmg = 자연의정령();
				}else {
					w = InputClass.intInput("1.화염의 폭동  2.물의 평화  3.자연의 질서");
					if(w==1) dmg = 화염의폭동();
					else if(w==2) {물의평화(); dmg = 0;}
					else dmg = 자연의질서();
				}
			}else dmg = 기본();
		}
		
		return dmg;
	}
	
	
	
	@Override
	public int 기본() {
		System.out.println(stat.getName()+"의 휘두르기!");
		설정.sleep(500);
		return 15*stat.getLevel();
	}

	@Override
	public int 제국의검() {
		if(stat.getMp() >= 450) {
			System.out.println(설정.purple+"[\"이것이 제국의 힘이다..!\"]"+설정.exit);
			stat.setMp(stat.getMp()-450);
			설정.sleep(1000);
			return 200*(stat.getLevel()-10);
		}else {
			System.out.println("mp가 부족하다..");
			설정.sleep(500);
			return 0;
		}	
	}

	@Override
	public int 에스토니아의비명() {
		System.out.println(설정.back_black+설정.purple+"ಎಲ್ಲವೂ ನಾಶವಾಗಬೇಕು."+설정.exit);
		stat.setHp(999999);
		설정.sleep(500);
		return 99999999;
	}

	@Override
	public int 활의노래() {
		if(stat.getMp() >= 400) {
			System.out.println(설정.green+"[\"당신의 활이 노래합니다.\"]"+설정.exit);
			stat.setMp(stat.getMp()-400);
			설정.sleep(500);
			return 160*(stat.getLevel()-10);
		}else {
			System.out.println("mp가 부족하다..");
			설정.sleep(500);
			return 0;
		}	
	}

	@Override
	public int 에비나투르() {
		if(stat.getMp() >= 600) {
			System.out.println(설정.green+"[\"한없이 떨어지는 꽃잎같구나\"]"+설정.exit);
			stat.setMp(stat.getMp()-600);
			설정.sleep(500);
			return 7500*(stat.getLevel()-20);
		}else {
			System.out.println("mp가 부족하다..");
			설정.sleep(500);
			return 0;
		}	
	}

	@Override
	public int 화염의폭동() {
		if(stat.getMp() >= 300) {
			System.out.println(설정.red+"[\"모두 다 태워버려라!\"]+설정.exit");
			stat.setMp(stat.getMp()-300);
			설정.sleep(500);
			return 120*(stat.getLevel()-10);
		}else {
			System.out.println("mp가 부족하다..");
			설정.sleep(500);
			return 0;
		}
	}

	@Override
	public void 물의평화() {
		if(stat.getMp() >= 400) {
			System.out.println(설정.cyan+"[\"물의 잔잔함이 나를 채운다...\"]"+설정.exit);
			stat.setHp(stat.getHp()+1000*(stat.getLevel()-10));
			stat.setMp(stat.getMp()-400);
			설정.sleep(500);
		}else {
			System.out.println("mp가 부족하다..");
			설정.sleep(500);
		}
	}

	@Override
	public int 자연의질서() {
		if(stat.getMp() >= 400) {
			System.out.println(설정.green+"[\"자연의 무서움을 깨닫게 해주마!\"]"+설정.exit);
			stat.setHp(stat.getHp()/2);
			stat.setMp(stat.getMp()-400);
			설정.sleep(500);
			return 200*(stat.getLevel()-10);
		}else {
			System.out.println("mp가 부족하다..");
			설정.sleep(500);
			return 0;
		}
	}

	@Override
	public int 화염의정령() {
		if(stat.getMp() >= 600) {
			System.out.println(설정.back_black+설정.red+"[\"없애버려라.. 화염의 정령이여...!\"]"+설정.exit);
			stat.setMp(stat.getMp()-600);
			설정.sleep(500);
			return 2000*(stat.getLevel()-20);
		}else {
			System.out.println("mp가 부족하다..");
			설정.sleep(500);
			return 0;
		}
	}

	@Override
	public int 물의정령() {
		if(stat.getMp() >= 600) {
			System.out.println(설정.back_blue+설정.white+"[\"바다의 힘을 보여줘라 물의 정령!\"]"+설정.exit);
			stat.setMp(stat.getMp()-600);
			설정.sleep(500);
			return 3000*(stat.getLevel()-20);
		}else {
			System.out.println("mp가 부족하다..");
			설정.sleep(500);
			return 0;
		}
	}

	@Override
	public int 자연의정령() {
		System.out.println(설정.back_black+설정.green+"[\"이것이 자연의 신이다.. 가라 자연의 정령!\"]"+설정.exit);
		stat.setHp(stat.getHp()-(int)(stat.getHp()*0.1));
		설정.sleep(500);
		return 6000*(stat.getLevel()-20);
	}

	@Override
	public void 초보() {
		int choiceJob = InputClass.intInput(stat.getName() + "님, 어떤 직업을 고르실 건가요?(1.검사  2.궁수  3.마법사) ");
		if(choiceJob == 1) {
			stat.setJob("검사"); 
			stat.setSkill("제국의 검");
		}else if(choiceJob == 2) {
			stat.setJob("궁수");
			stat.setSkill("활의 노래");
		}else {
			stat.setJob("마법사");
			stat.setSkill("초급 마법");
		}
	}

	@Override
	public void 중급자() {
		
	}

	@Override
	public void 숙련자() {
		
	}

	@Override
	public void 마스터() {
		
	}

	@Override
	public void 전설() {
		
	}

	public 스탯 getStat() {return stat;}
	public void setStat(스탯 stat) {	this.stat = stat;}
	public int getEnd() {	return end;}
	public void setEnd(int end) {this.end = end;}
}

