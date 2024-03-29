package yoni;

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
		System.out.println("\n**********결과**********");
		System.out.println("사용자 : "+u);
		System.out.println("컴퓨터 : "+c);
		System.out.println("***********************");
		if(c < u) System.out.println("win");
		else if (c == u) System.out.println("draw");
		else System.out.println("lose");
	}

	private void challenge(String ask) {
		String yn = stringInput(ask);
		String bye[] = {"엄...네...알겠습니당...","헉 좀 더 하고 가시지...","잘가용!","아쉽지만 또봐용!","안녕히가세요."};
		if(yn.equals("y")) {
			if(ask == "도전하시겠습니까?(y/n) ") detail();
			mainGame();
			challenge("다시하시겠습니까?(y/n) ");
		}else {
			System.out.println(bye[(int)((Math.random() * 5))]);
		} 
	}

	private void detail() {
		System.out.println("********************************게임 설명********************************");
		System.out.println("사용자가 주사위 눈을 키보드로 입력한다!");
		System.out.println("사용자가 입력한 주사위의 눈 중 랜덤한 수 2개를 각각 사용자, 컴퓨터에게 주어지고 비교했을 때");
		System.out.println("사용자의 주사위 눈이 더 높으면 win, 낮으면 lose, 같으면 draw!");
		System.out.println("**********************************************************************");
	}
	
	private void mainGame() {
		int num = intInput("주사위의 눈 입력: ");
		int user = DiceNum(num);
		int computer = DiceNum(num);			
		check(computer, user);
	}

	public void start() {
		System.out.println("******************************");
		System.out.println("***오로지 운으로만 승부하는 주사위 게임***");
		System.out.println("******************************");
		challenge("도전하시겠습니까?(y/n) ");
	}

	public static void main(String[] args) {
		DiceGame2 game = new DiceGame2();
		game.start();
	}
}