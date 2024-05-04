package 용사키우기;

public class 용사키우기 {
	public static void main(String[] args) {
		start();
	}

	static void start()
	{
		System.out.println(설정.purple+"###############\n###용사 키우기!###\n###############\n\n\n"+설정.exit);
		//설정.sleep(3000);
		용사 user = new 용사();
		//intro(user.gender);
		loop(user);
	}
	
	static void loop(용사 user) {
		//설정.sleep(3000);
		//튜토리얼(user.name,user.stat.level,user.stat.hp);
		화면.메인("", user.name, user.stat.level, user.stat.hp);
	}
	
	private static void 튜토리얼(String name, int lv, int hp) {
		String tutorial[] = {"우선 수련할 장소로 이동하자.('1'을 입력해주세요.)",
				"앞에 있는 몬스터를 잡자!('3'을 입력해주세요.)",
				"('1'을 입력해주세요.)",
				"몬스터를 해치웠다! 50 exp와 낡은 단검을 획득했다!",
				"잘했어! 한번 얻은 아이템을 장착해볼까?('2'를 입력해주세요.)",
				"낡은 단검이네~! 장착해보자!(장착할 아이템명을 입력해주세요.)",
				"왠지 더 강해진 느낌인걸~~ 앞으로 더 수련해서 마왕을 잡자!"};
	}

	private static void intro(String gender) {
		System.out.println("나는 지금 마왕을 잡기 위해 수련을 하는 중이다.");
		설정.sleep(2500);
		System.out.println("사실, 난 처음부터 마왕을 잡고 싶어하진 않았다.");
		설정.sleep(2500);
		System.out.println("그러나 '그 사건'이 일어난 후 내 인생은 뒤바뀌었다.\n");
		설정.sleep(2500);
		if (gender.equals("여")) {
			System.out.println(설정.blue+"나는 제국의 검이라고 불리는 에스토니아 가문의 대공을 아버지로 둔 제 3공녀였다."+설정.exit);
			설정.sleep(2500);
			System.out.println(설정.blue+"제 1소공자이자 나의 오빠 다인, 제 2공녀이자 나의 언니 엘리벳,"+설정.exit);
			설정.sleep(2500);
			System.out.println(설정.blue+"우리 셋은 어릴 때 부터 친했기 때문에 서로 사이가 돈독했다. "+설정.exit);
			설정.sleep(2500);
			System.out.println(설정.blue+"그래서 우리는 늘 함께였고 평화로운 나날을 보냈었다.\n"+설정.exit);
			설정.sleep(2500);
			System.out.println(설정.red+"어느날 갑자기 하늘에 검은 구멍이 생기더니 거기서 다수의 마족들이 쏟아졌다."+설정.exit);
			설정.sleep(2500);
			System.out.println(설정.red+"그들은 알 수 없는 말을 내뱉으며 우리들을 공격했고,"+설정.exit);
			설정.sleep(2500);
			System.out.println(설정.red+"나의 아버지, 어머니, 유모 그리고 나의 언니 엘리벳을 내 눈 앞에서 죽였다. 나와 다인만 남기고..\n"+설정.exit);
			설정.sleep(2500);
			System.out.println(설정.blue+"그 참혹한 시간이 지난 후 그들의 왕처럼 보이는 녀석이"+설정.exit);
			설정.sleep(2500);
			System.out.println(설정.blue+"오빠를 가리키더니, 오빠를 데리고 그 구멍 속으로 들어갔다."+설정.exit);
			설정.sleep(2500);
			System.out.println(설정.blue+"난 그 후 마왕을 잡기 위해 그리고 나의 유일한 가족, 오빠를 구하기 위해 수련을 떠나게 되었다."+설정.exit);
		}else {
			System.out.println(설정.blue+"나는 제국의 검이라고 불리는 에스토니아 가문의 대공을 아버지로 둔 제 3소공자이었다."+설정.exit);
			설정.sleep(2500);
			System.out.println(설정.blue+"제 1소공자이자 나의 형 다인, 제 2공녀이자 나의 누나 엘리벳,"+설정.exit);
			설정.sleep(2500);
			System.out.println(설정.blue+"우리 셋은 어릴 때 부터 친했기 때문에 서로 사이가 돈독했다. "+설정.exit);
			설정.sleep(2500);
			System.out.println(설정.blue+"그래서 우리는 늘 함께였고 평화로운 나날을 보냈었다.\n"+설정.exit);
			설정.sleep(2500);
			System.out.println(설정.red+"어느날 갑자기 하늘에 검은 구멍이 생기더니 거기서 다수의 마족들이 쏟아졌다."+설정.exit);
			설정.sleep(2500);
			System.out.println(설정.red+"그들은 알 수 없는 말을 내뱉으며 우리들을 공격했고,"+설정.exit);
			설정.sleep(2500);
			System.out.println(설정.red+"나의 아버지, 어머니, 유모 그리고 나의 누나 엘리벳을 내 눈 앞에서 죽였다. 나와 다인만 남기고..\n"+설정.exit);
			설정.sleep(2500);
			System.out.println(설정.blue+"그 참혹한 시간이 지난 후 그들의 왕처럼 보이는 녀석이"+설정.exit);
			설정.sleep(2500);
			System.out.println(설정.blue+"형을 가리키더니, 형을 데리고 그 구멍 속으로 들어갔다."+설정.exit);
			설정.sleep(2500);
			System.out.println(설정.blue+"난 그 후 마왕을 잡기 위해 그리고 나의 유일한 가족, 형을 구하기 위해 수련을 떠나게 되었다."+설정.exit);
		}
			
	}
}
