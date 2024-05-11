package 용사키우기;

public class 용사 extends 캐릭터 implements 스킬, 호칭 {
	스탯 stat;
	int end = 0;
	public 용사() {
		//name = InputClass.stringInput("용사의 이름을 지어주세요! ");
		//gender = InputClass.stringInput(name+"님의 성별은 무엇인가요?(남/여) ");
		hp=100;level=1;exp=0;atk=10;def=10;
		stat = new 스탯(name,gender,level,hp,exp,atk,def);
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
	}
	
	public void 회복() {
		
	}
	
	public void 스킬사용() {
		
	}
	
	
	
	@Override
	public void 기본() {
		System.out.println(name+"의 휘두르기!");
		
	}

	@Override
	public void 제국의검() {
		System.out.println("");
	}

	@Override
	public void 에스토니아의비명() {
		
	}

	@Override
	public void 활의노래() {
		
	}

	@Override
	public void 에비나투르() {
		
	}

	@Override
	public void 화염의폭동() {
		
	}

	@Override
	public void 물의평화() {
		
	}

	@Override
	public void 자연의질서() {
		
	}

	@Override
	public void 화염의정령() {
		
	}

	@Override
	public void 물의정령() {
		
	}

	@Override
	public void 자연의정령() {
		
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

