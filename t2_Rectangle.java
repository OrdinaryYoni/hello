package yoni;

public class t2_Rectangle extends t2_shape{
	int w, h;
	public t2_Rectangle(int w, int h) {
		this.w = w;
		this.h = h;
		name = "직사각형";
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