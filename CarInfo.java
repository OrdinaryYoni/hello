package yoni;

interface Car{
	public final static String CARSIZE1 = "small type";
	String CARSIZE2 = "middle type";
	
	public abstract void size();
	public abstract void price();
	void option();
}

interface CarMaker{
	public final static String KIA = "기아자동차";
	public final static String HYUNDAI = "현대자동차";
	
	public abstract void maker();
}

class CarTransfer{
	int p,o,d,t;
	public void prideCost() {
		System.out.println("프라이드 운송비 = " + t + "만원");
	}
	public void sonataCost() {
		System.out.println("소나타 운송비 = " + t + "만원");
	}
}

class Pride extends CarTransfer implements Car, CarMaker{
	public Pride(int p, int o, int d, int t) {
		this.p = p;
		this.o = o;
		this.d = d;
		this.t = t;
	}
	@Override
	public void size() {
		System.out.println("자동차 크기 : " + CARSIZE1);
	}
	@Override
	public void price() {
		System.out.println("최고 가격 : " + p + "만원");
	}
	public void option() {
		System.out.println("풀옵션 가격 = "+ o + "만원");
	}
	public void discount() {
		System.out.println("구형 교체 = " + d + "만원 할인\n");
	}
	public void maker() {
		System.out.println("메이커 : " + KIA);
	}
}

class Sonata extends CarTransfer implements Car, CarMaker{
	public Sonata(int p, int o, int d, int t) {
		this.p = p;
		this.o = o;
		this.d = d;
		this.t = t;
	}
	public void size() {
		System.out.println("자동차 크기 : " + CARSIZE2);
	}
	public void price() {
		System.out.println("최고 가격 : " + p +"만원");
	}
	public void option() {
		System.out.println("풀옵션 가격 = " + o +"만원");
	}
	public void discount() {
		System.out.println("구형 교체 = " + d + "만원 할인");
	}
	public void maker() {
		System.out.println("메이커 : " + HYUNDAI);
	}
}

public class CarInfo {

	public static void main(String[] args) {
		System.out.println("[3-1]");
		Pride pr = new Pride(1600,200,50,5);
		pr.maker();
		pr.size();
		pr.price();
		pr.option();
		pr.prideCost();
		pr.discount();
		
		
		Sonata so = new Sonata(3000,350,100,10);
		so.maker();
		so.size();
		so.price();
		so.option();
		so.sonataCost();
		so.discount();
	}

}
