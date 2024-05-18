package 용사키우기;

public class 용사키우기 {
	몬스터[] forest_mops = new 몬스터[4];//슬라임, 우딩, 고블린, 골렘
	몬스터[] dangeon_mops = new 몬스터[4]; //오크, 미네린, 하데론, 오크 왕
	
	public 용사키우기() {
		forest_mops[0] = new 몬스터("슬라임", 50, 5, 2, 20, 5);//이름, 체력, 공격력, (최대)레벨, 최대경험치, 최소경험치
		forest_mops[1] = new 몬스터("우딩", 80, 8, 3, 20, 8);
		forest_mops[2] = new 몬스터("고블린", 400, 20, 5, 70, 20);
		forest_mops[3] = new 몬스터("골렘", 1100, 50, 10, 100, 70);
		
		dangeon_mops[0] = new 몬스터("오크", 1500, 70, 12, 120, 150);//이름, 체력, 공격력, (최대)레벨, 최대경험치, 최소경험치
		dangeon_mops[1] = new 몬스터("미네린", 2000, 100, 15, 200, 160);
		dangeon_mops[2] = new 몬스터("하데론", 2300, 200, 18, 200, 230);
		dangeon_mops[3] = new 몬스터("오크 왕", 3000, 300, 20, 300, 300);
	}
	
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
						user.hp = 100 * user.level;
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
		화면 화면 = new 화면();
		//설정.sleep(3000);
		//튜토리얼(user.name,user.stat.level,user.stat.hp);
		화면.메인("");
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
		화면 화면 = new 화면();
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
