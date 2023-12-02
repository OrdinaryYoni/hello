package 이가연;

public class Overflow47 {
	public static void main(String[] args) {
		int x = Integer.MAX_VALUE;
		int y = Integer.MIN_VALUE;
		
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		
		int w = x + 1;
		int z = y - 1;
		
		System.out.println("w = " + w);
		System.out.println("z = " + z);
	}
}
