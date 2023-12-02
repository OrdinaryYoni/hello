package 이가연;

public class ShiftOperation50 {
	public static void main(String[] args) {
		int x = 128, y = -128;
		
		System.out.println("x >> 2 :" + Integer.toBinaryString(x) + " -> " + Integer.toBinaryString(x >> 2));
		System.out.println("y >> 2 :" + Integer.toBinaryString(y) + " -> " + Integer.toBinaryString(y >> 2));
		
		System.out.println("x >>> 2 :" + Integer.toBinaryString(x) + " -> " + Integer.toBinaryString(x >>> 2));
		System.out.println("y >>> 2 :" + Integer.toBinaryString(y) + " -> " + Integer.toBinaryString(y >>> 2));
		
		System.out.println("x << 2 :" + Integer.toBinaryString(x) + " -> " + Integer.toBinaryString(x << 2));
		
	}
}
