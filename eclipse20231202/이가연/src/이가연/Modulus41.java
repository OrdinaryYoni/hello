package 이가연;

import java.util.Random;

public class Modulus41 {
	public static void main(String[] args) {
		int x,y;
		
		Random r = new Random();
		x = r.nextInt(1000);
		y = x % 101;
		System.out.println(x + " => " + y);
		
		x = r.nextInt(1000);
		y = (x%100)+1;
		System.out.println(x + " => " + y);
	}
}