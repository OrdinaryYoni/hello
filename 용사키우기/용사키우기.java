package 용사키우기;

public class 용사키우기 {
	public static void main(String[] args) {
		start();
	}

	static void start()
	{
		System.out.println(설정.purple+"###############\n###용사 키우기!###\n###############\n\n\n"+설정.exit);
		//설정.sleep(3000);
		용사 user = new 용사();
		//화면.인트로(user.gender);
		while(true) {
			loop(user);
			if(user.stat.hp == 0) {
				if (user.end > 0) {
					엔딩(user.end);
					String check = InputClass.stringInput("처음부터 다시하시겠습니까?(y/n) ");
					if(check.equals("y")) {
						user = new 용사();
					}else {
						System.out.println("안녕히 가십시요.");
						break;
					}
				}else {
					String check = InputClass.stringInput("다시하시겠습니까?(y/n) ");
					if(check.equals("y")) {
						System.out.println("체크포인트로 돌아갑니다.");
						설정.sleep(1000);
					}else {
						엔딩(89);
						break;
					}
				}
			}
		}
		
	}
	
	static void loop(용사 user) {
		//설정.sleep(3000);
		//튜토리얼(user.name,user.stat.level,user.stat.hp);
		화면.메인("", user.name, user.stat.level, user.stat.hp);
		String s = InputClass.print();
		if (s.equals("1")) user.이동();
		else if (s.equals("2")) user.가방();
		else if (s.equals("3")) user.행동();
		else System.out.println("하하핳 너 참 재미있구나!");
		설정.sleep(1000);
	}
	
	private static void 튜토리얼(String name, int lv, int hp) {
		String tutorial[] = {"우선 수련할 장소로 이동하자.('1'을 입력해주세요.)",
				"앞에 있는 몬스터를 잡자!('3'을 입력해주세요.)",
				"('1'을 입력해주세요.)",
				"몬스터를 해치웠다! 50 exp와 낡은 단검을 획득했다!",
				"잘했어! 한번 얻은 아이템을 장착해볼까?('2'를 입력해주세요.)",
				"낡은 단검이네~! 장착해보자!(장착할 아이템명을 입력해주세요.)",
				"왠지 더 강해진 느낌인걸~~ 앞으로 더 수련해서 마왕을 잡자!"};
	}
	
	private static void 엔딩(int end) {
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
