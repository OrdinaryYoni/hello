package yoni;

import java.util.Scanner;

public class DiceGame3 {
	
	//설명
	private void detail() {
		System.out.println("********************************게임 설명********************************");
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
		System.out.println("공격: 당신의 공격력만큼 적을 공격한다.");
		System.out.println("회복: 당신이 가지고 있는 회복 포션을 사용해 체력을 회복한다.(+100)");
		System.out.println("대화: 적과 대화한다...(대화하다보면 친해질지도 모르지...)");
		System.out.println("**********************************************************************");
	}
	
	private int DiceNum() {
		int num = (int) (Math.random() * 6) + 1;
		return num;
	}
	
	private int intInput(String prompt) {
		int r;
		System.out.print(prompt);
		Scanner ip = new Scanner(System.in);
		r = ip.nextInt();

		return r;
	}

	private String stringInput(String prompt) {
		String r;
		System.out.print(prompt);
		Scanner ip = new Scanner(System.in);
		r = ip.next();

		return r;
	}
	
	
	private void challenge(String ask) {
		String yn = stringInput(ask);
		String bye[] = {"엄...네...알겠습니당...","Bye:)","잘가용!","아쉽지만 또봐용!","안녕히가세요."};
		if(yn.equals("y")) {
			if(ask == "도전하시겠습니까?(y/n) ") detail();
			mainGame();
			challenge("다시하시겠습니까?(y/n) ");
		}else {
			System.out.println(bye[(int)((Math.random() * 5))]);
		} 
	}
	
	//체력 확인
	private void check(몬스터 mop, 플레이어 user) {
		user.hp -= mop.atk > user.def ? (mop.atk-user.def) : 0;
		if (mop.hp <= 0) System.out.println("\n\n축하드립니다! 당신은 몬스터를 해치웠습니다!");
		else if (user.hp <= 0) System.out.println("\n\n당신은 몬스터에게 졌습니다...");
		else fightStart(mop, user);
	}
	
	//싸우기
	private void fightStart(몬스터 mop, 플레이어 user) {
		System.out.println("\n" + mop.name + " 체력:" + mop.hp);
		System.out.println("당신의 체력: "+ user.hp);
		System.out.println("당신은 무엇을 할까?");
		int select = intInput("1.공격  2.회복  3.대화 ");
		
		if (select == 1) mop.hp = mop.attack(user.atk, user.luck); //공격
		else if (select == 2) {user.hp = mop.heal(user.hp, user.heal); user.heal -= 1;} //회복
		else if (select == 3) mop.hp = mop.dialogue(user.luck, mop.hp); //대화
		else System.out.println("\n앗 잘못된 선택을 해버렸다..."); //그외
		
		check(mop, user);
	}
	
	몬스터[] monsters = new 몬스터[5];
	
	//본겜
	public void mainGame() {
		monsters[0] = new 몬스터("슬라임", 50, 5);
		monsters[1] = new 몬스터("스켈레톤", 100, 10);
		monsters[2] = new 몬스터("좀비", 100, 10);
		monsters[3] = new 몬스터("늑대", 150, 15);
		monsters[4] = new 몬스터("드래곤", 200, 30);
		int luck = (int) (Math.random() * 99) + 1;
		플레이어 user = new 플레이어(100, DiceNum(), DiceNum(), DiceNum());
		
		System.out.println("주사위 3번 던지기~!");
		System.out.println("당신의 공격력은... " + user.atk + "!");
		System.out.println("당신의 방어력은... " + user.def + "!");
		System.out.println("당신의 회복 포션 개수는... " + user.heal + "개!");
		int m = intInput("싸울 적을 입력하세요.(1.슬라임 2.스켈레톤 3.좀비 4.늑대 5.드래곤) ");
		
		System.out.println(monsters[m-1].name + "(이)가 나타났다!");
		fightStart(monsters[m-1], user);
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


class 몬스터{
	String name;
	int hp;
	int atk;
	public 몬스터(String name, int hp, int atk) {
		this.name = name;
		this.hp = hp;
		this.atk = atk;
	}
	
	//공격
	public int attack(int user_atk, int luck) {
		if (luck >= 89) {
			System.out.println("\n크리티컬!!!");
			System.out.println(name + "에게 " + (user_atk+20) + "만큼 피해를 줬다!");
			hp -= 20;
		}else System.out.println("\n" + name + "에게 " + user_atk + "만큼 피해를 줬다!");
		
		hp -= user_atk;
		return hp;
	}
	
	//회복
	public int heal(int user_hp, int user_heal) {
		if (user_heal > 0) {
			System.out.println("\n100만큼 회복!");
			user_hp += 100;
		}else System.out.println("앗... 회복 포션이 다 떨어졌다...");
			
		return user_hp;
	}
	
	//대화
		public int dialogue(int luck, int mop_hp) {
			int n = (int) (Math.random() * 5);
			String comments [] = {"음... 안녕?", "넌 정말 멋지구나!", "우리 싸우지 말자~~", "평화롭게 갑시다!", "싸워봤자 이득되는건 없어!!", "우리 친하게 지내자"};
			System.out.println("\n**************대화**************");
			System.out.println(comments[n]);
			System.out.println("*******************************");
			if (luck == 89) {
				System.out.println("난 지금까지 살면서 너같은 애는 처음봐..");
				System.out.println("덕분에 기분이 좋아졌으니 풀어줄게~~");
				mop_hp = 0;
			}else { 
				System.out.println("뭔소리를 하는거야? 난 널 못믿어!");
			}
			return mop_hp;
		}
}

class 플레이어{
	int hp;
	int atk;
	int def;
	int heal;
	int luck = (int) (Math.random() * 99) + 1;
	public 플레이어(int hp, int atk, int def, int heal) {
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.heal = heal;
		this.luck = luck;
	}
}

/*		System.out.println("주사위를 3번 던진다.(주사위의 눈은 사용자가 입력)");
		System.out.println("첫번째 수는 공격력, 두번째 수는 방어력, 세번째 수는 회복 포션 개수이다.\n");
		System.out.println("당신의 체력은 100이다.");
		System.out.println("적의 체력과 공격력은");
		System.out.println("1. 슬라임 : 50/5");
		System.out.println("2. 스켈레톤, 좀비 : 100/10");
		System.out.println("3. 늑대 : 150/15");
		System.out.println("4. 드래곤 : 200/30이다.\n");
		System.out.println("당신은 세가지 선택지가 있다.");
		System.out.println("1. 공격 2. 회복 3. 대화");
		System.out.println("공격: 당신의 공격력만큼 적을 공격한다.");
		System.out.println("회복: 당신이 가지고 있는 회복 포션을 사용해 체력을 회복한다.(+50)");
		System.out.println("대화: 적과 대화한다...(대화하다보면 친해질지도 모르지...)");*/