package 용사키우기;

public class 용사 extends 캐릭터 implements 스킬, 호칭 {
	스탯 stat;
	화면 화면 = new 화면();
	int end = 0;
	public 용사() {
		//name = InputClass.stringInput("용사의 이름을 지어주세요! ");
		//gender = InputClass.stringInput(name+"님의 성별은 무엇인가요?(남/여) ");
		stat = new 스탯(name,gender);
	}
	
	public void 이동() {
		화면.이동창(level);
		int w = InputClass.intInput("어디를 갈까? ");
		if(w == 1) {
			stat.place = "부서진 에스토니아의 성";
			화면.장소(w);
		}else if(w==2) {
			stat.place = "서쪽 숲";
			화면.장소(w);
		}else if(w==3 & level >= 10) {
			stat.place = "에테토스 마을";
		}else if(w==4 & level >= 10) {
			stat.place = "라니아나 동굴";
		}else System.out.println("그런 곳은 없어!");
		설정.sleep(1);
	}
	
	public void 가방() {
		화면.가방창();
		
	}
	
	public void 행동() {
		화면.행동창();
		int w = InputClass.intInput("무엇을 할까? ");
		if(w == 1) {
		}
	}

	public void 회복() {
		
	}
	
	public void 스킬사용() {
		int dmg = 0;
		
		if(level < 10) {
			dmg = 기본();
		}
	}
	
	
	
	@Override
	public int 기본() {
		System.out.println(name+"의 휘두르기!");
		return 15;
	}

	@Override
	public int 제국의검() {
		if(stat.mp >= 450) {
			System.out.println(설정.purple+"[\"이것이 제국의 힘이다..!\"]"+설정.exit);
			stat.mp -= 450;
			return 200;
		}else {
			System.out.println("mp가 부족하다..");
			return 0;
		}	
	}

	@Override
	public int 에스토니아의비명() {
		System.out.println(설정.back_black+설정.purple+"ಎಲ್ಲವೂ ನಾಶವಾಗಬೇಕು."+설정.exit);
		hp = 999999;
		return 99999999;
	}

	@Override
	public int 활의노래() {
		if(stat.mp >= 400) {
			System.out.println(설정.green+"[\"당신의 활이 노래합니다.\"]"+설정.exit);
			return 160;
		}else {
			System.out.println("mp가 부족하다..");
			return 0;
		}	
	}

	@Override
	public int 에비나투르() {
		if(stat.mp >= 600) {
			System.out.println(설정.green+"[\"한없이 떨어지는 꽃잎같구나\"]"+설정.exit);
			return 7500;
		}else {
			System.out.println("mp가 부족하다..");
			return 0;
		}	
	}

	@Override
	public int 화염의폭동() {
		if(stat.mp >= 300) {
			System.out.println(설정.red+"[\"모두 다 태워버려라!\"]+설정.exit");
			return 120;
		}else {
			System.out.println("mp가 부족하다..");
			return 0;
		}
	}

	@Override
	public void 물의평화() {
		if(stat.mp >= 400) {
			System.out.println(설정.cyan+"[\"물의 잔잔함이 나를 채운다...\"]"+설정.exit);
			hp += 50;
		}else {
			System.out.println("mp가 부족하다..");
		}
	}

	@Override
	public int 자연의질서() {
		if(stat.mp >= 400) {
			System.out.println(설정.green+"[\"자연의 무서움을 깨닫게 해주마!\"]"+설정.exit);
			hp /= 2;
			return 200;
		}else {
			System.out.println("mp가 부족하다..");
			return 0;
		}
	}

	@Override
	public int 화염의정령() {
		if(stat.mp >= 600) {
			System.out.println(설정.back_black+설정.red+"[\"없애버려라.. 화염의 정령이여...!\"]"+설정.exit);
			return 2000;
		}else {
			System.out.println("mp가 부족하다..");
			return 0;
		}
	}

	@Override
	public int 물의정령() {
		if(stat.mp >= 600) {
			System.out.println(설정.back_blue+설정.white+"[\"바다의 힘을 보여줘라 물의 정령!\"]"+설정.exit);
			return 3000;
		}else {
			System.out.println("mp가 부족하다..");
			return 0;
		}
	}

	@Override
	public int 자연의정령() {
		System.out.println(설정.back_black+설정.green+"[\"이것이 자연의 신이다.. 가라 자연의 정령!\"]"+설정.exit);
		hp-=(hp*0.1);
		return 6000;
	}

	@Override
	public void 초보() {
		int choiceJob = InputClass.intInput(name + "님, 어떤 직업을 고르실 건가요?(1.검사  2.궁수  3.마법사) ");
		if(choiceJob == 1) stat.job = "검사";
		else if(choiceJob == 2) stat.job = "궁수";
		else stat.job = "마법사";
		
	}

	@Override
	public void 중급자() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void 숙련자() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void 마스터() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void 전설() {
		// TODO Auto-generated method stub
		
	}
}

