package chapter11;

class A284{
	public int x = 53;
	
	public void print() {
		System.out.println("Parent method :" + x);
	}
}

class B284 extends A284{
	public int x = 17;
	public String y = "abc";
	
	public void print() {
		System.out.println("Child method :" + x);
		System.out.println("Child method :" + y);
	}
}

public class Example284 {

	public static void main(String[] args) {
		A284 p = new B284();
		
		p.print();
		System.out.println("Parent value : " + p.x);
	}

}
