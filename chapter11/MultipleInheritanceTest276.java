package chapter11;

interface Car{
	public void showInfo();
}

class PassengerCar implements Car{
	private int seats;
	public PassengerCar() {seats=2;}//3
	public PassengerCar(int n) {seats = n;}//8
	public int getSeats() {return seats;}//16
	public void setSeats(int n) {seats = n;}
	public void showInfo() {System.out.println("좌석 수 : "+seats);}//11
}

interface ITruck extends Car{
	public int getPayload();
	public void setPayload(int w);
}

class Truck implements ITruck{
	private int payload;
	public Truck() {payload = 100;}
	public Truck(int w) {payload = w;}//5 //10
	public int getPayload() {return payload;}//18
	public void setPayload(int w) {payload = w;}
	public void showInfo() {System.out.println("적재 하중 : " + payload);}//13
}

class Pickup extends PassengerCar implements ITruck{
	private int tow_capacity;
	Truck truck;
	
	public Pickup() {super(4); truck = new Truck(1000); tow_capacity = 10000;}
	public Pickup(int s, int w, int c) {
		super(s); //7
		truck = new Truck(w); //9
		tow_capacity = c;//11
	}
	public void setTow_capacity(int c) {tow_capacity = c;}
	public int getTow_capacity() {return tow_capacity;}
	public void showInfo() {System.out.println("좌석 수 : "+getSeats()+", 적재 하중 : "
	+getPayload()+", 견인 능력 : "+tow_capacity);}//15
	@Override
	public int getPayload() {
		return truck.getPayload();//17
	}
	@Override
	public void setPayload(int w) {
		truck.setPayload(w);
	}
}


public class MultipleInheritanceTest276 {
	public static void main(String[] args) {
		Car [] cars = new Car[3];//1
		
		cars[0] = new PassengerCar();//2
		cars[1] = new Truck(500);//4
		cars[2] = new Pickup(4, 2000, 10000);//6
		
		for (int i=0; i<3; i++) {//12 //12 //14
			cars[i].showInfo();
		}
	}
}