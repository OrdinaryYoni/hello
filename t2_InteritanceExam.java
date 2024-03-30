package yoni;

class Flower{
	public String Flowername;
	public int cost;
	
	public Flower() {
		Flowername = "꽃";
		this.cost = 10000;
	}
	
	protected void printAttributes() {
		System.out.println("Flowername="+Flowername+"\tcost="+cost);
	}
}

class Rose extends Flower{
	public Rose() {
		Flowername = "장미";
		cost = 20000;
	}
}

class Tulip extends Flower{
	public Tulip() {
		Flowername = "튤립";
		cost = 30000;
	}
}

public class t2_InteritanceExam {

	public static void main(String[] args) {
		Flower Flower = new Flower();
		Rose Rose = new Rose();
		Tulip Tulip = new Tulip();
		
		System.out.println("[2-2]");
		Flower.printAttributes();
		Rose.printAttributes();
		Tulip.printAttributes();
	}

}
