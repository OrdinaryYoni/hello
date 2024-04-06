package 용사키우기;

public class 용사키우기 {

	public static void main(String[] args) {

	}

	
	void start()
	{
		System.out.println("...");
		sleep(1500);
		System.err.println("..");
		sleep(1500);
		System.out.println(".");
	}
	
	void sleep(int m)
	{
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
