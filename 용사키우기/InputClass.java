package 용사키우기;

import java.util.Scanner;

public class InputClass{
	public static int intInput(String prompt) {
		int r;
		System.out.print(prompt);
		Scanner ip = new Scanner(System.in);
		r = ip.nextInt();

		return r;
	}
	
	public static String stringInput(String prompt) {
		String r;
		System.out.print(prompt);
		Scanner ip = new Scanner(System.in);
		r = ip.nextLine();

		return r;
	}
	
	public static String print() {
		String r;
		Scanner ip = new Scanner(System.in);
		r = ip.nextLine();
		
		return r;
	}
}
