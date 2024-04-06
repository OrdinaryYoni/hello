package chapter11;

public class ProgramBasic266 {

	public static void main(String[] args) {
		Rectangle r;//1
		r = new Rectangle();//2
	}

}

class Shape{
	private int x, y;
	/*public Shape() {
		this(0,0);
		System.out.println("Shape 생성자");
	}*/
	public Shape(int xloc, int yloc) {
		x = xloc; y = yloc;//5
		System.out.println("Shape 유인 생성자");//6
	}
}

class Rectangle extends Shape{
	private int width, height;
	public Rectangle() {
		this(0,0,0,0);//3
		System.out.println("Rectangle 생성자");//9
	}
	public Rectangle(int x, int y, int w, int h) {
		super(x,y);//4
		width = w; height = h;//7
		System.out.println("Rectangle 유인 생성자");//8
	}
}