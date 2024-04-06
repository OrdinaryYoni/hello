package chapter11;

import java.util.Calendar;
import java.util.Date;

class Clock262{
	public String getLocation() {return "한국";}
	int getHours() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		
		return hour;
	}
	int getMinutes() {
		long time = System.currentTimeMillis();
		Date date = new Date(time);
		int min = date.getMinutes();
		
		return min;
	}
	int getSeconds() {
		Date date = Calendar.getInstance().getTime();
		int sec = date.getSeconds();
		
		return sec;
	}
}

class ForeignClock extends Clock262{
	String location;
	int timeDiff;
	public String getLocation() {return location;}
	public ForeignClock(String loc, int diff) {location = loc; timeDiff = diff;}
	int getHours() {
		int local = super.getHours();
		int tmp = local + timeDiff;
		tmp = (tmp<0) ? (24+tmp):tmp;
		return tmp;
	}
}

public class ClockTest262 {
	public static void main(String[] args) {
		Clock262[] clocks = new Clock262[3];
		clocks[0] = new Clock262();
		clocks[1] = new ForeignClock("Rome", 9);
		clocks[2] = new ForeignClock("Tokyo", -7);
		
		for (Clock262 c:clocks) System.out.println(c.getLocation() + " : " + c.getHours() + "시 " + c.getMinutes() + "분 " + c.getSeconds() + "초");
	}
}