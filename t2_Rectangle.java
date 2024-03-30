package yoni;

public class t2_Rectangle extends t2_shape{
	int w, h, sw;
	public t2_Rectangle(int w, int h) {
		this.w = w;
		this.h = h;
	}
	
	public t2_Rectangle(int sw) {
		this.sw = sw;
	}
	
	@Override
	void calcArea() {
		area = w*h;
	}
	
	@Override
	void calcRound() {
		round = w*2+h*2;
	}
}