package 용사키우기;

public class NPC extends 캐릭터{
	private String name;
	private int hp, atk, def, level, exp;
	public NPC(String name, int hp, int atk, int def, int level, int exp) {
		this.setName(name);
		this.hp = hp;
		this.atk = atk;
		this.level = level;
		this.def = def;
		this.exp = exp;
	}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getHp() {return hp;}
	public void setHp(int hp) {this.hp = hp;}
	public int getAtk() {return atk;}
	public void setAtk(int atk) {this.atk = atk;}
	public int getDef() {return def;}
	public void setDef(int def) {this.def = def;}
	public int getLevel() {return level;}
	public void setLevel(int level) {this.level = level;}
	public int getExp() {return exp;}
	public void setExp(int exp) {this.exp = exp;}
	
}
