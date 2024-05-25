package 용사키우기;

public class 스탯{
	private String name, job, gender, skill, place;
	private int hp,mp,level,exp,maxExp,atk,def;
	public 스탯(String name, String gender) {
		this.place = "부서진 에스토니아의 성";
		this.hp = 100;
		this.mp = 50;
		this.level = 1;
		this.exp = 0;
		this.maxExp = 100;
		this.atk = 10;
		this.def = 10;
		this.name = name;
		this.gender = gender;
		if (gender.equals("여")) this.job = "멸문가 에스토니아의 제 3공녀";
		else this.job = "멸문가 에스토니아의 제 3소공자";
	}
	
	public void 레벨업(){
		if(this.exp >= maxExp) {
			this.exp -= maxExp;
			level++;
			if(maxExp < 1000) maxExp *= level;
			else maxExp *= 2*level;
			hp  *= level;
			mp  *= level;
			atk *= level;
			def *= level;
		}
		else if(this.level == 11) {
			화면.안내창(1);
		}else if(this.level == 21) {
			System.out.println(설정.yellow+"새로운 장소 해금!!{}"+설정.exit);
			System.out.println(설정.yellow+"새로운 퀘스트 해금"+설정.exit);
		}
	}
	
	
	
	
	
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getJob() {return job;}
	public void setJob(String job) {this.job = job;}
	public String getGender() {return gender;}
	public void setGender(String gender) {this.gender = gender;}
	public String getSkill() {return skill;}
	public void setSkill(String skill) {this.skill = skill;}
	public String getPlace() {return place;}
	public void setPlace(String place) {this.place = place;}
	public int getHp() {return hp;}
	public void setHp(int hp) {this.hp = hp;}
	public int getMp() {return mp;}
	public void setMp(int mp) {this.mp = mp;}
	public int getLevel() {return level;}
	public void setLevel(int level) {this.level = level;}
	public int getExp() {return exp;}
	public void setExp(int exp) {this.exp = exp;}
	public int getAtk() {return atk;}
	public void setAtk(int atk) {this.atk = atk;}
	public int getDef() {return def;}
	public void setDef(int def) {this.def = def;}
}
