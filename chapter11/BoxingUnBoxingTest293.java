package chapter11;

public class BoxingUnBoxingTest293 {

	public static void main(String[] args) {
		int val = 30;
		Integer iOb = Integer.valueOf(val);
		Integer jOb = val;
		
		System.out.println(val + " " + iOb + " " + jOb);
		
		Integer ob = new Integer(5);
		int i = ob.intValue();
		int j = ob;
		
		System.out.println(ob + " " + i + " " + j);
	}
}