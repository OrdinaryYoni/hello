package yoni;

public class t2_Rectangle extends t2_shape{
	int w, h;
	public t2_Rectangle(int w, int h) {
		this.w = w;
		this.h = h;
	}
	void calcArea() {
		area = w*h;
	}
	@Override
	void calcRound() {
		Round = w*2+h*2;
		System.out.println("Rec Override");
	}
}
