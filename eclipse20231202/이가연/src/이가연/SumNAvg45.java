package 이가연;

import java.util.Scanner;

public class SumNAvg45 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("첫 번째 성적 >> ");
		int s1 = sc.nextInt();
		System.out.print("두 번째 성적 >> ");
		int s2 = sc.nextInt();
		System.out.print("세 번째 성적 >> ");
		int s3 = sc.nextInt();
		sc.close();
		
		int sum = s1 + s2 + s3;
		double avg = sum / 3.0;
		
		System.out.println("합 : " + sum);
		System.out.println("평균 : " + avg);
	}
}