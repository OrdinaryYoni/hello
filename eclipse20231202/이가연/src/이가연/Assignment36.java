package 이가연;

public class Assignment36 {
	public static void main(String[] args) {
		char c = '한';
		
		System.out.println("문자 : " + c);
		
		int code = c;
		System.out.println("유니코드 : " + Integer.toHexString(code));
		
		int i = 0xd55d;
		char c2 = (char)i;
		System.out.println("문자 : " + c2);
	}
}