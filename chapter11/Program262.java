package chapter11;

public class Program262 {

	public static void main(String[] args) {
		ChildClass obj;
		obj = new ChildClass();
		obj.print();
	}
}

class ParentClass{
	public void print() {
		System.out.println("부모 클래스의 print() 멤버 함수");
	}
}

class ChildClass extends ParentClass{
	/*private int data;*/
	@Override
	public void print() {
		super.print();
		System.out.println("자식 클래스의 print() 멤버 함수");
	}
}