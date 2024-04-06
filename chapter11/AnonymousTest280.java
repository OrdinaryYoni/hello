package chapter11;

interface MyInterface280{
	public void test();
}

public class AnonymousTest280 {

	public static void main(String[] args) {
		MyInterface280 inner = new MyInterface280() {
			public void test() {
				System.out.println("테스트입니다.");
			}
		};
		inner.test();
	}

}
