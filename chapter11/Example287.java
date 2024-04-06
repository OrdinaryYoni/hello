package chapter11;

public class Example287 {

	public static void main(String[] args) {
		IA p = new A287();
		
		p.print();
	}

}

interface IA{
	public void print();
}

class A287 implements IA{
	public int x = 17;
	public String y = "abc";
	
	public void print() {
		System.out.println("print method : " + x);
		System.out.println("print method : " + y);
	}
}