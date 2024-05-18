package 용사키우기;

public class 몬스터 extends 캐릭터 {
	private String name;
	private int hp, atk, level, maxexp, minexp;
	public 몬스터(String name, int hp, int atk, int level, int maxexp, int minexp) {
		this.name = name;
		this.hp = hp;
		this.atk = atk;
		this.level = level;
		this.maxexp = maxexp;
		this.minexp = minexp;
	}
		
}
