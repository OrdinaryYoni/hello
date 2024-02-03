package yoni;

import java.util.Scanner;

public class DiceGame {
	int diceFace;
	int userGuess;
	
	public void RollDice() {
		diceFace = (int)(Math.random() * 6) + 1;
	}
	private int getUserInput(String prompt) {
		int r;
		
		System.out.print(prompt);
		Scanner inp = new Scanner(System.in);
		r = inp.nextInt();
		
		return r;
	}
	private void checkUserGuess() {
		if(diceFace == userGuess) System.out.print("맞았습니다");
		else System.out.print("틀렸습니다");
	}
	
	public void startPlaying() {
		userGuess = getUserInput("예상 값을 입력하시오: ");
		RollDice();
		checkUserGuess();
	}
}
