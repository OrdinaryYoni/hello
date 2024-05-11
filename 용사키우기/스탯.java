package 용사키우기;

public class 스탯{
	String name, job, gender, skill, place;
	String bag[] = {"","","","","","","","","","","","","","","","","","","",""};
	int hp,mp=50,level,exp,maxExp=100,atk,def;
	public 스탯(String name, String gender, int level, int hp, int exp, int atk, int def) {
		this.name = name;
		this.gender = gender;
		this.hp = hp;
		this.level = level;
		this.exp = exp;
		this.atk = atk;
		this.def = def;
	}
	
	public void 레벨업(int exp){
		this.exp = exp;
		if(this.exp == maxExp) {
			this.exp = 0;
			level++;
			if(maxExp < 1000) maxExp *= level;
			else maxExp *= 2*level;
			hp  *= level;
			mp  *= level;
			atk *= level;
			def *= level;
		}
		else if(this.exp == 10) {
			System.out.println(설정.yellow+"새로운 장소 해금!!{에테토스 마을}"+설정.exit);
			System.out.println(설정.yellow+"직업 해금"+설정.exit);
			System.out.println(설정.yellow+"퀘스트 해금"+설정.exit);
			System.out.println(설정.yellow+"상점 해금"+설정.exit);
		}else if(this.exp == 20) {
			System.out.println(설정.yellow+"새로운 장소 해금!!{}"+설정.exit);
			System.out.println(설정.yellow+"새로운 퀘스트 해금"+설정.exit);
		}
	}
	
}
