package 용사키우기;

public class 설정 {
	public static final String black 	= "\u001B[30m";
    public static final String red 		= "\u001B[31m";
    public static final String green 	= "\u001B[32m";
    public static final String yellow   = "\u001B[33m";
    public static final String blue     = "\u001B[34m";
    public static final String purple   = "\u001B[35m";
    public static final String cyan     = "\u001B[36m";
    public static final String white    = "\u001B[37m";
    
    public static final String back_black = "\u001B[40m";
    public static final String back_red 		= "\u001B[41m";
    public static final String back_green 	= "\u001B[42m";
    public static final String back_yellow   = "\u001B[43m";
    public static final String back_blue     = "\u001B[44m";
    public static final String back_purple   = "\u001B[45m";
    public static final String back_cyan     = "\u001B[46m";
    public static final String back_white    = "\u001B[47m";
    
    
    
    public static final String exit     = "\u001B[0m" ;
    
	static void sleep(int m)
	{
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
