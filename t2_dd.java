package yoni;

public class t2_dd {

	public static void main(String[] args) {
		t2_shape arr[] = {
			new t2_Rectangle(1,2), new circle(2), new square(2)
		};
		
		for(t2_shape a:arr) {
			a.calcArea();
			System.out.println("[2-1] " + a.name + " 넓이: " + a.area + ".." );
			a.calcRound();
			System.out.println("[2-1] " + a.name + " 둘레: " + a.round + "--");
		}
	}
}

class circle extends t2_shape{
	int r;
	public circle(int r) {
		this.r = r;
		name = "원";
	}
	@Override
	void calcArea() {
		area = r*r*3;
	}
	@Override
	void calcRound() {
		round = r*2*3;
	}
}

class square extends t2_Rectangle{
	public square(int w) {
		super(w,w);
		name = "정사각형";
	}
}