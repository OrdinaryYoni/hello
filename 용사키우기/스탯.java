package 용사키우기;

public class 스탯{
	private String bag;
	private String name, job, gender, skill, place, title, quest, currentWeapon, completeQuest;
	private int hp,maxHp,mp,maxMp,level,exp,maxExp,atk,def, weaponAtk, plusAtk, money;
	public 스탯(String name, String gender) {
		level = 1;
		maxHp = 200*level;
		place = "부서진 에스토니아의 성";
		title = "일반인보다 약함";
		hp = maxHp;
		maxMp = (int) (400+(400*level*0.1));
		mp = maxMp;
		exp = 0;
		plusAtk = 0;
		maxExp = 100*level;
		atk = 10*level;
		skill = "엄숨";
		quest = "엄숨";
		completeQuest = "";
		currentWeapon = "낡은 단검";
		bag = "";
		money = 0;
		weaponAtk = 0;
		def = 0;
		this.name = name;
		this.gender = gender;
		if (gender.equals("여")) this.job = "멸문가 에스토니아의 제 3공녀";
		else this.job = "멸문가 에스토니아의 제 3소공자";
	}
	
	public void 레벨업(){
		while(exp>=maxExp) {
			this.exp -= maxExp;
			if(level == 100) {
				level = 100;
			}else {
				level+=1;
			}
			if(maxExp < 1000) maxExp = 100*level;
			else maxExp = 2000+200*(level-10);
			maxHp = 200*level;
			maxMp = (int) (400+(400*level*0.1));
			mp = maxMp;
			atk = 10*level+plusAtk;
			hp = maxHp;
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
	public int getMaxHp() {return maxHp;}
	public void setMaxHp(int maxHp) {this.maxHp = maxHp;}
	public int getMaxExp() {return maxExp;}
	public void setMaxExp(int maxExp) {this.maxExp = maxExp;}
	public int getMaxMp() {return maxMp;}
	public void setMaxMp(int maxMp) {this.maxMp = maxMp;}
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	public String getQuest() {return quest;}
	public void setQuest(String quest) {this.quest = quest;}
	public String getCurrentWeapon() {return currentWeapon;}
	public void setCurrentWeapon(String currentWeapon) {this.currentWeapon = currentWeapon;}
	public int getWeaponAtk() {return weaponAtk;}
	public void setWeaponAtk(int weaponAtk) {this.weaponAtk = weaponAtk;}
	public String getCompleteQuest() {return completeQuest;}
	public void setCompleteQuest(String completeQuest) {this.completeQuest = completeQuest;}
	public int getPlusAtk() {return plusAtk;}
	public void setPlusAtk(int plusAtk) {this.plusAtk = plusAtk;}
	public String getBag() {return bag;}
	public void setBag(String bag) {this.bag = bag;}
	public int getMoney() {return money;}
	public void setMoney(int bag) {this.money = money;}
}
