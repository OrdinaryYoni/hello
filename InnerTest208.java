package yoni;

public class InnerTest208 {

	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.display_Inner();
	}

}

class Outer{
	int num = 10;
	
	class Inner{
		public void print() {
			System.out.println("This is an inner class : " + num);
		}
	}
	
	void display_Inner() {
		Inner inner = new Inner();
		inner.print();
	}
}