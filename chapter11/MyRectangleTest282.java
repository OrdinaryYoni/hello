package chapter11;

public class MyRectangleTest282 {

	public static void main(String[] args) {
		MyRectangle r1 = new MyRectangle();
		r1.setX(10);
		r1.setY(10);
		r1.setWidth(5);
		r1.setHeight(4);
		System.out.println("면적은 " + r1.getArea() + "입니다.");
	}

}

interface MyPoint{
	public int getX();
	public void setX(int newX);
	public int getY();
	public void setY(int newY);
}

class MyRectangle{
	private MyPoint corner;
	private int width, height;
	
	public MyRectangle() {
		corner = new MyPoint() {
			private int x,y;
			public int getX() {return x;}
			public void setX(int newX) {x = newX;}
			public int getY() {return y;}
			public void setY(int newY) {y = newY;}
		};
	}
	//메서드 정의
	public int getX() {return corner.getX();}
	public void setX(int newX) {corner.setX(newX);}
	public int getY() {return corner.getY();}
	public void setY(int newY) {corner.setX(newY);}
	public int getWidth() {return width;}
	public void setWidth(int newW) {width = newW;}
	public int getHeight() {return height;}
	public void setHeight(int newH) {height = newH;}
	public void resize(int newW, int newH) {
		width = newW;
		height = newH;
	}
	public int getArea() {return width * height;}
}