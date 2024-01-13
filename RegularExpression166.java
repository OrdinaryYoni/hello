package yoni;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression166 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input;
		Pattern pattern;
		Matcher m;
		
		System.out.println("이름 : ");
		input = sc.next();
		pattern = Pattern.compile(input);
		m = pattern.matcher(input);
		if(!m.matches()) {
			System.out.println("이름 형식에 맞지 않습니다.");
			return;
		}
		
		input = sc.nextLine();
		System.out.println("주소 : ");
		input = sc.nextLine();
		pattern = Pattern.compile("^[가-힣]{2,4}도\\s+[가-힣]{2,4}시\\s+[가-힣]{2,6}로\\s+\\d{2,4}$");
		m = pattern.matcher(input);
		if(!m.matches()) {
			System.out.println("주소 형식에 맞지 않습니다.");
			return;
		}
		
		System.out.println("우편번호 : ");
		input = sc.next();
		pattern = Pattern.compile("^\\d{5}$");
		m = pattern.matcher(input);
		if(!m.matches()) {
			System.out.println("우편 번호 형식에 맞지 않습니다.");
			return;
		}
		
		System.out.println("핸드폰 번호 : ");
		input = sc.next();
		pattern = Pattern.compile("^01[01]-\\d{4}-\\d{4}$");
		m = pattern.matcher(input);
		if(!m.matches()) {
			System.out.println("핸드폰 번호 형식에 맞지 않습니다.");
			return;
		}
		
		System.out.println("모든 자료 형식에 맞게 입력하셨습니다.");
	}

}
