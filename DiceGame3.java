package yoni;

import java.util.Scanner;

public class DiceGame3 {
	몬스터[] monsters = new 몬스터[5];
	플레이어 user;
	
	public DiceGame3()
	{
		monsters[0] = new 몬스터("슬라임", 50, 5);
		monsters[1] = new 몬스터("스켈레톤", 100, 10);
		monsters[2] = new 몬스터("좀비", 100, 10);
		monsters[3] = new 몬스터("늑대", 150, 15);
		monsters[4] = new 몬스터("드래곤", 200, 30);
		user = new 플레이어(100, rollDice6(), rollDice6(), rollDice6());
	}
	
	public void init() {
		monsters[0].setHp(50);
		monsters[1].setHp(100);
		monsters[2].setHp(100);
		monsters[3].setHp(150);
		monsters[4].setHp(200);
		user.setHp(100);
		user.setAtk(rollDice6());
		user.setDef(rollDice6());
		user.setHealItem(rollDice6());
	}
	
	//설명
	private void gameRule() {
		System.out.println("\n\n********************************게임 설명********************************");
		System.out.println("주사위를 3번 던진다.(주사위의 눈은 6)");
		System.out.println("첫번째 수는 공격력, 두번째 수는 방어력, 세번째 수는 회복 포션 개수이다.\n");
		System.out.println("당신의 체력은 100이다.");
		System.out.println("적의 체력/공격력은");
		System.out.println("1. 슬라임 : 50/5");
		System.out.println("2. 스켈레톤, 좀비 : 100/10");
		System.out.println("3. 늑대 : 150/15");
		System.out.println("4. 드래곤 : 200/30이다.\n");
		System.out.println("당신은 세가지 선택지가 있다.");
		System.out.println("1. 공격 2. 회복 3. 대화");
		System.out.println("공격: 당신의 공격력만큼 적을 공격한다.(15% 확률로 크리티컬이 일어난다.)");
		System.out.println("회복: 당신이 가지고 있는 회복 포션을 사용해 체력을 회복한다.(+100)");
		System.out.println("대화: 적과 대화한다...(대화하다보면 친해질지도 모르지...(4% 확률))");
		System.out.println("**********************************************************************");
	}
	
	private int rollDice6() {
		int num = (int) (Math.random() * 6) + 1;
		return num;
	}
	
	public int intInput(String prompt) {
		int r;
		System.out.print(prompt);
		Scanner ip = new Scanner(System.in);
		r = ip.nextInt();

		return r;
	}

	
	
	
	private void challenge(String ask) {
		while(true) {
			String yn = InputClass.stringInput(ask);
			String bye[] = {"엄...네...알겠습니당...","Bye:)","잘가용!","아쉽지만 또봐용!","안녕히가세요."};
			if(yn.equals("y")) {
				if (ask == "도전하시겠습니까?(y/n) ") gameRule();
				mainGame();
				ask = "다시하시겠습니까?(y/n) ";
				init();
			}else {
				System.out.println(bye[(int)((Math.random() * 5))]);
				break;
			} 
		}
	}
	
	
	
	//본겜
	public void mainGame() {
		System.out.println("주사위 3번 던지기~!");
		System.out.println("당신의 공격력은... " + user.getAtk() + "!");
		System.out.println("당신의 방어력은... " + user.getDef() + "!");
		System.out.println("당신의 회복 포션 개수는... " + user.getHealItem() + "개!");
		int m = intInput("싸울 적을 입력하세요.(1.슬라임 2.스켈레톤 3.좀비 4.늑대 5.드래곤) ");
		System.out.println(monsters[m-1].getName() + "(이)가 나타났다!");
		monsters[m-1].fightStart(user);
	}

	//시작화면
	public void start() {
		System.out.println("*********************");
		System.out.println("***주사위로 몬스터 잡기!***");
		System.out.println("*********************");
		challenge("도전하시겠습니까?(y/n) ");
	}

	public static void main(String[] args) {
		DiceGame3 game = new DiceGame3();
		game.start();
	}
}

class InputClass{
	public static int intInput(String prompt) {
		int r;
		System.out.print(prompt);
		Scanner ip = new Scanner(System.in);
		r = ip.nextInt();

		return r;
	}
	
	public static String stringInput(String prompt) {
		String r;
		System.out.print(prompt);
		Scanner ip = new Scanner(System.in);
		r = ip.nextLine();

		return r;
	}
}


class 몬스터{
	private String name;
	private int hp;
	private int atk;
	public 몬스터(String name, int hp, int atk) {
		this.setName(name);
		this.hp = hp;
		this.atk = atk;
	}
	//공격
	public void attack(플레이어 user) {
		int damage = user.getAtk();
		
		if (user.getLuck() >= 85) { //15% 확률
			damage += 20;
			System.out.println("\n크리티컬!!!");
			System.out.println(getName() + "에게 " + damage + "만큼 피해를 줬다!");
		}else {
			System.out.println("\n" + getName() + "에게 " + user.getAtk() + "만큼 피해를 줬다!");
		}
		hp -= damage;
	}
	
	//대화
	public void dialogue(플레이어 user) {
		int n = (int) (Math.random() * 5);
		int luck = user.getLuck();
		String comments [] = {"음... 안녕?", "넌 정말 멋지구나!", "우리 싸우지 말자~~", "평화롭게 갑시다!", "싸워봤자 이득되는건 없어!!", "우리 친하게 지내자"};
		System.out.println("\n**************대화**************");
		System.out.println(comments[n]);
		System.out.println("*******************************");
		if (luck == 89 || luck == 79 || luck == 78 || luck == 73) { //4% 확률
			System.out.println("\n\n\n난 지금까지 살면서 너같이 싸우지 않고 나와 대화하고싶어하는 애는 처음봐..");
			System.out.println("대부분은 나를 공격하는데... 넌 정말 마음씨가 곱구나!");
			System.out.println("공격해서 미안!");
			hp = 0;
		}else { 
			System.out.println("뭔소리를 하는거야? 난 널 못믿어!");
		}
	}
	//몹 체력 확인
	public boolean isMobAlive() {//isMobAlive()
		if (hp <= 0) {
			System.out.println("\n\n          <Clear!>          ");
			System.out.println("축하드립니다! 당신은 몬스터를 해치웠습니다!\n\n");
			return false;
		}
		
		return true;
	}
	
	//싸우기
	public void fightStart(플레이어 user) {
		while(true) {
			System.out.println(this.printMobData());
			System.out.println("당신의 체력: "+ user.getHp());
			System.out.println("당신은 무엇을 할까?");
			int select = InputClass.intInput("1.공격  2.회복  3.대화 ");
			if (select == 1) this.attack(user); //공격
			else if (select == 2) user.heal(); //회복
			else if (select == 3) this.dialogue(user); //대화
			else System.out.println("\n앗 잘못된 선택을 해버렸다..."); //그외
				
			user.userDamage(this.getAtk());
			user.setLuck();
			if (user.isUserAlive() == false || this.isMobAlive() == false) break;
		}
	}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getHp() {return hp;}
	public void setHp(int hp) {this.hp = hp;}
	public int getAtk() {return atk;}
	public void setAtk(int atk) {this.atk = atk;}
	public String printMobData()
	{
		return "\n" + getName() + " 체력:" + getHp();
	}
}

class 플레이어{
	private int hp;
	private int atk;
	private int def;
	private int healItem;
	private int luck;
	
	public 플레이어(int hp, int atk, int def, int heal) {
		this.hp = hp;
		this.setAtk(atk);
		this.def = def;
		this.healItem = heal;
		setLuck();
		
	}
	
	//회복
		public void heal() {
			if (healItem > 0) {
				System.out.println("\n100만큼 회복!");
				hp += 100;
				healItem -= 1;
			}else System.out.println("앗... 회복 포션이 다 떨어졌다...");
		}
	
	//체력깎기
	public void userDamage(int mop_atk) {
		int damage = 0;
		if (def < mop_atk) damage = mop_atk - def;
		if (damage == 0) {
			System.out.println("\n앗...!");
			System.out.println("방어력이 너무 높아 적의 공격이 통하지 않는다...");
		}
		hp -= damage;
	}
	
	//플레이어 체력 확인
	public boolean isUserAlive() {
		if (hp <= 0) {
			System.out.println("\n\n    <GAME OVER>    ");
			System.out.println("당신은 몬스터에게 졌습니다...\n\n ");
			return false;
		}
		return true;
	}
	
	public int getHp() {return hp;}
	public void setHp(int hp) {this.hp = hp;}
	public int getDef() {return def;}
	public void setDef(int def) {this.def = def;}
	public int getHealItem() {return healItem;}
	public void setHealItem(int healItem) {this.healItem = healItem;}
	public int getLuck() {return luck;}
	public void setLuck() {luck = (int) (Math.random() * 100) + 1;}
	public int getAtk() {return atk;}
	public void setAtk(int atk) {this.atk = atk;}
}
