package 용사키우기;

public class 몬스터 extends 캐릭터 {
	private String name;
	private int hp, atk, level, maxexp, minexp;
	public 몬스터(String name, int hp, int atk, int level, int maxexp, int minexp) {
		this.setName(name);
		this.hp = hp;
		this.atk = atk;
		this.level = level;
		this.maxexp = maxexp;
		this.minexp = minexp;
	}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getHp() {return hp;}
	public void setHp(int hp) {this.hp = hp;}
	public int getAtk() {return atk;}
	public void setAtk(int atk) {this.atk = atk;}
	public int getLevel() {return level;}
	public void setLevel(int level) {this.level = level;}
	public int getMaxexp() {return maxexp;}
	public void setMaxexp(int maxexp) {this.maxexp = maxexp;}
	public int getMinexp() {return minexp;}
	public void setMinexp(int minexp) {this.minexp = minexp;}
	
}
