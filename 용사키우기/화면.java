package 용사키우기;

public class 화면 {

	public static void 메인(String msg, String name, int lv, int hp) {
		용사 user = new 용사();
		String arr[] = {"\n\n\n\n\n\n\n\n\n\n\n\n",
				String.format("%s",msg),
				"           ●        ",
				"         \\/|\\     ",
				"          / \\      ",
				String.format(" %s lv:%d hp:%d",name,lv,hp),
				"┌─────────────────────┐",
				"│당신은 무엇을 할건가?      │",
				"└─────────────────────┘",
				"  1.이동  2.가방  3.행동 "
				};
		for(String i:arr) {
			System.out.println(i);
		}
		String s = InputClass.print();
		if (s.equals("1")) 이동창();
		else if (s.equals("2")) 가방창();
		else if (s.equals("3")) 행동창();
		else System.out.println("하하핳 너 참 재미있구나!");
	}
	
	private static void 이동창() {
		
	}
	
	private static void 가방창() {
		
	}
	
	private static void 행동창() {
		
	}

}
