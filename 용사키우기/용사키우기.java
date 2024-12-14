package 용사키우기;

public class 용사키우기 {
	
	public static void main(String[] args) {
		용사키우기 system = new 용사키우기();
		system.start();
	}

	void start()
	{
		System.out.println(설정.purple+"###############\n###용⋌˫키우⌝ᥣ!###\n###############\n\n\n"+설정.exit);
		용사 user = new 용사();
		화면.인트로(user.getStat().getGender());
		while(true) {
			if (user.getEnd() > 0) {
				엔딩(user.getEnd());
				String check = InputClass.stringInput("처음부터 다시하시겠습니까?(y/n) ");
				if(check.equals("y")) {
					user = new 용사();
				}else {
					System.out.println("안녕히 가십시요.");
					break;
				}
			}else if(user.getStat().getHp() <= 0){
				String check = InputClass.stringInput("다시하시겠습니까?(y/n) ");
				if(check.equals("y")) {
					System.out.println("체크포인트로 돌아갑니다.");
					user.getStat().setHp(user.getStat().getMaxHp());
					설정.sleep(1500);
				}else if(check.equals("n")) {
					엔딩(89);
					break;
				}else {
					System.out.println("잘못된 선택입니다. 일단 체크포인트로 돌아갑니다.");
					user.getStat().setHp(user.getStat().getMaxHp());
					user.getStat().setMp(user.getStat().getMaxMp());
					설정.sleep(1500);
				}
			}
			loop(user);
		}
		
	}
	void loop(용사 user) {
		화면.메인(user);
		String s = InputClass.print();
		if (s.equals("1")) user.이동();
		else if (s.equals("2")) user.가방();
		else if (s.equals("3")) user.행동();
		else if (s.equals("4")) 화면.설명();
		else {System.out.println("하하핳 너 참 재미있구나!"); 설정.sleep(800);}
	}
	
	private void 엔딩(int end) {
		if (end == 1) {
			화면.엔딩1();
		}else if(end==2) {
			화면.엔딩2();
		}else if (end==3) {
			화면.엔딩3();
		}else if (end==4) {
			화면.엔딩4();
		}else {
			화면.흐접엔딩();
		}
	}
}
