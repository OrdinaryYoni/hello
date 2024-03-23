package yoni;

public class t2_dd {

	public static void main(String[] args) {
		t2_shape s = new t2_Rectangle(1,2);
		t2_shape c = new circle(2);
		s.calcArea();
		c.calcArea();
		s.calcRound();
		System.out.println(s.area + "..");
		System.out.println(c.area + "**");
		System.out.println(s.Round+ "--");
	}
}

class circle extends t2_shape{
	int r;
	public circle(int r) {
		this.r = r;
	}
	void calcArea() {
		area = r*r*3;
	}
}

class square extends t2_Rectangle{
	public square(int w) {
		super(w, w);
		area = w*w;
	}
}