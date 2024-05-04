package 용사키우기;

public class 용사 extends 캐릭터 implements 스킬, 호칭 {
	스탯 stat;
	public 용사() {
		//name = InputClass.stringInput("용사의 이름을 지어주세요! ");
		//gender = InputClass.stringInput(name+"님의 성별은 무엇인가요?(남/여) ");
		stat = new 스탯(name, gender);
	}
	
	public void 이동() {
		
	}
	
	public void 가방() {
		
	}
	
	public void 행동() {
		
	}
	
	public void 회복() {
		
	}
	
	public void 스킬사용() {
		if (stat.level == 10) {
			초보();
		}
	}
	
	
	
	@Override
	public void 기본() {
		System.out.println(name+"의 휘두르기!");
		
	}

	@Override
	public void 제국의검() {
		
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

