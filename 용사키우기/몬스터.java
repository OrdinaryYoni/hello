package 용사키우기;

public class 몬스터 extends 캐릭터 {
	private String name, hab;
	private int hp, atk, def, level;
	public 몬스터(String name, String hab, int hp, int atk, int def, int level) {
		this.name = name;
		this.hab = hab;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.level = level;
	}
	
	public void 공격() {
		용사 user = new 용사();
		int damage = user.stat.atk;
		String DoSkillUse = InputClass.stringInput("스킬을 사용하시겠습니까?(y/n) ");
		if (DoSkillUse == "y") {
			user.스킬사용();
		}
		hp -= damage;
	}
}
