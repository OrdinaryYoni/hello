package 이가연;

public class VarialblesTest31 {
	public static void main(String[] args) {
		int a = 10, b = 5;
		a = a + 1;
		System.out.println(a);
		a = b = 4;
		System.out.println(a);
		a = (b = 4) + 1;
		System.out.println(a);
	}
}
