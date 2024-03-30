package yoni;

public class t2_dd {

	public static void main(String[] args) {
		t2_Rectangle r = new t2_Rectangle(1,2);
		t2_shape c = new circle(3);
		t2_Rectangle s = new t2_Rectangle(2);
		r.calcArea();
		System.out.println(r.area + "..");
		c.calcArea();
		System.out.println(c.area + "π <= 원넓이");
		s.calcArea();
		System.out.println(s.area+ " <=  정사각형 넓이");
		r.calcRound();
		System.out.println(r.round+ " <=  사각형 둘레");
		c.calcRound();
		System.out.println(c.round+ " <=  원 둘레");
		
		
		
		
	}
}

class circle extends t2_shape{
	int r;
	public circle(int r) {
		this.r = r;
	}
	@Override
	void calcArea() {
		area = r*r;
	}
	@Override
	void calcRound() {
		round = r*2;
	}
}

class square extends t2_Rectangle{
	int w;
	public square(int sw) {
		super(sw);
		this.w = sw;
	}
	@Override
	public void calcArea() {
		area = w*w;
	}
}