package 이가연;

import java.util.Scanner;

public class DiceGame2 {
	
	private int DiceNum(int n) {
		int num = (int) (Math.random() * n) + 1;
		return num;
	}
	
	private int intInput(String prompt) {
		int r;
		System.out.print(prompt);
		Scanner ip = new Scanner(System.in);
		r = ip.nextInt();
	
		return r;
	}
	
	private String stringInput(String prompt) {
		String r;
		System.out.print(prompt);
		Scanner ip = new Scanner(System.in);
		r = ip.next();
	
		return r;
	}
	
	private void check(int c, int u) {
		System.out.println("사용자 : "+u);
		System.out.println("컴퓨터 : "+c);
		if(c < u) System.out.println("win");
		else if (c == u) System.out.println("draw");
		else System.out.println("lose");
	}
	
	private int challenge() {
		String yn = stringInput("도전하시겠습니까?(y/n) ");
		if(yn == "y") {
			detail(); 
			return 1;
		}else {
			System.out.println("엄... 네... 알겠습니다...");
			return 0;
		} 
	}
	
	private void detail() {
		System.out.println("********************************게임 설명********************************");
		System.out.println("사용자가 주사위 눈을 키보드로 입력한다.");
		System.out.println("사용자가 입력한 주사위의 눈 중 랜덤한 수 2개를 각각 사용자, 컴퓨터에게 대입 그리고 비교하여 ");
		System.out.println("사용자의 주사위 눈이 더 높으면 win, 낮으면 lose, 같으면 draw를 출력한다.");
		System.out.println("**********************************************************************");
	}
	
	public void start() {
		System.out.println("***오로지 운으로만 승부하는 주사위 게임***");
		int checking = challenge();
		while(checking == 1) {
			int num = intInput("주사위의 눈 입력: ");
			int user = DiceNum(num);
			int computer = DiceNum(num);
			check(computer, user);
		}
	}
	
	public static void main(String[] args) {
		DiceGame2 game = new DiceGame2();
		game.start();
	}
}
