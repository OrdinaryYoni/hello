package 이가연;

import java.util.Scanner;

public class SayHello33 {
	public static void main(String[] args) {
		System.out.print("이름 입력 >> ");
		Scanner sc = new Scanner (System.in);
		String name = sc.next();
		sc.close();
		
		String helloMessage = "안녕하세요. " + name + "님, 자바세계에 오신 것을 축하드립니다.";
		
		System.out.println(helloMessage);
	}
}