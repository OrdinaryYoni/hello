package chapter11;

interface Greeting{
	String message();
}

public class AnonymousTest281 {
	
	public void display(Greeting g) {
		System.out.println(g.message());
	}
	
	public static void main(String[] args) {
		AnonymousTest281 ob = new AnonymousTest281();
		ob.display(new Greeting() {
			public String message() {
				return "안녕하세요";
			}
		});
	}

}
