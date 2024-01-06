package yoni;

import java.util.Scanner;

public class SeatReservation142 {
	public static void main(String[] args) {
		boolean [][] seats = new boolean[10][5];
		char menuChar;
		
		for(int r=0; r < seats.length; r++) {
			for(int c=0; c<seats[r].length; c++) {
				seats[r][c] = false;				
			}
		}
		
		do {
			System.out.println("s : 예약 현황 보기");
			System.out.println("r : 예약하기");
			System.out.println("c : 예약 취소");
			System.out.println("e : 프로그램 종료");
			
			System.out.print("원하는 메뉴 글자 (s, r, c, e)중 하나를 입력하세요.");
			Scanner sc = new Scanner(System.in);
			menuChar = sc.next().charAt(0);
			
			switch(menuChar) {
			case 's' : showReservationStatus(seats); break;
			case 'r' : reserveSeat(seats); break;
			case 'c' : cancelReservation(seats); break;
			case 'e' : System.out.println("시스템 종료되었습니다.");
			return;
			}
		} while(true);
	}
	
	public static void showReservationStatus(boolean[][] seats) {
		System.out.println("o가 예약 가능한 자리입니다.");
		for (int r=0;r<seats.length;r++) {
			for(int c=0;c<seats[r].length;c++) {
				if(seats[r][c] == true) System.out.print("x ");
				else System.out.print("o ");
			}
			System.out.println();
		}
	}
	
	public static void reserveSeat(boolean[][] seats) {
		System.out.println("원하는 좌석의 행(1 ~ 10)과 열(1 ~ 5) 번호를 입력하세요. (예 : 5 3) : ");
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt() - 1;
		int col = sc.nextInt() - 1;
		
		if (row >= 0 && row <= 10 && col >= 0 && col <= 5) {
			if(seats[row][col] != true) seats[row][col] = true;
			else System.out.println("이미 예약되어 있는 자리입니다.");
		}
		else System.out.println("좌석 행 또는 열 번호가 잘못되었습니다.");
	}
	
	public static void cancelReservation(boolean[][] seats) {
		System.out.print("취소하고자 하는 좌석의 행(1 ~ 10)과 열(1 ~ 5)번호를 입력하세요. (예 : 5 3) : ");
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt() - 1;
		int col = sc.nextInt() - 1;
		if(row>=0&&row<=10&&col>=0&&col<=5) {
			if(seats[row][col] == true) seats[row][col] = false;
			else System.out.println("예약되지 않은 자리입니다.");
		}
		else System.out.println("좌석 행 또는 열 번호가 잘못되었습니다.");
	}
}
