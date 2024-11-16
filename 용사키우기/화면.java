package 용사키우기;

public class 화면 {
	public static void 메인(용사 user) {
		String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n\n", String.format("%s", user.getStat().getPlace()),
				"           ●        ",
				"         \\/|\\     ",
				"          / \\      ",
				String.format(" %s lv:%d hp:%d exp:%d/%d", user.getStat().getName(), user.getStat().getLevel(),
						user.getStat().getHp(), user.getStat().getExp(), user.getStat().getMaxExp()),
				"┌─────────────────────┐", 
				"│당신은 무엇을 할건가?      │", 
				"└─────────────────────┘", 
				"  1.이동  2.가방  3.행동 " };
		for (String i : arr) {
			System.out.println(i);
		}
	}

	public static void 이동창(int lv) {
		if (lv >= 100) {
			System.out.println(설정.red + "10.마왕성" + 설정.exit);
			return;
		}

		System.out.print("1.부서진 에스토니아의 성 2.서쪽 숲");

		if (lv > 10)
			System.out.println(" 3.에테토스 마을 4.라니아나 던전");
		if (lv > 20)
			System.out.print("5.절망의 고원");
		if (lv > 40)
			System.out.print(" 6.마이하스산");
		if (lv > 60)
			System.out.print(" 7.플로라 마을");
		if (lv > 80)
			System.out.print(" 8.진실의 서재");
		System.out.println();
		if (lv > 90)
			System.out.println("9.이실리아 세계수");

	}

	public static void 가방창(용사 user) {
		System.out.println(user.getStat().getBag());
		설정.sleep(1500);
	}

	public static void 행동창() {
		System.out.println("1.사냥 2.채집 3.스탯");
	}
	
	public static void 스탯창(용사 user) {
		String arr[] = {"\n\n\n\n\n\n\n\n\n\n\n\n\n\n",
				String.format("이름: %s lv: %d 성별: %s", user.getStat().getName(), 
						user.getStat().getLevel(),user.getStat().getGender()),
				"━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━",
				String.format("직업: %s \n호칭: %s \n돈: %d원", user.getStat().getJob(), 
						user.getStat().getTitle(), user.getStat().getMoney()),
				String.format("보유 스킬: %s \n진행중인 퀘스트: %s", user.getStat().getSkill(), 
						user.getStat().getQuest()),
				String.format("공격력: %d+%d \n방어력: %d \nmp: %d/%d", user.getStat().getAtk(),
						user.getStat().getWeaponAtk(), user.getStat().getDef(),
						user.getStat().getMp(),user.getStat().getMaxMp()),
				String.format("현재 체력: %d/%d \n현재 무기: %s", user.getStat().getHp(), 
						user.getStat().getMaxHp(),user.getStat().getCurrentWeapon()),
				"\n스킬과 직업 설명은 마을 도섣관으로..."
				};
		
		for (String i : arr) {
			System.out.println(i);
			설정.sleep(800);
		}
		설정.sleep(5000);
		System.out.println("3초후에 꺼집니다.");
		System.out.println("3...");
		설정.sleep(1000);
		System.out.println("2..");
		설정.sleep(1000);
		System.out.println("1.");
		설정.sleep(1000);
	}

	public static void 장소(int w) {

	}

	public static void 인트로(String gender) {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("나는 지금 마왕을 잡기 위해 수련을 하는 중이다.");
		설정.sleep(2500);
		System.out.println("사실, 난 처음부터 마왕을 잡고 싶어하진 않았다.");
		설정.sleep(2500);
		System.out.println("그러나 '그 사건'이 일어난 후 내 인생은 뒤바뀌었다.\n");
		설정.sleep(2500);
		if (gender.equals("여")) {
			System.out.println(설정.blue + "나는 제국의 검이라고 불리는 에스토니아 가문의 대공을 아버지로 둔 제 3공녀였다." + 설정.exit);
			설정.sleep(2500);
			System.out.println(설정.blue + "제 1소공자이자 나의 오빠 다인, 제 2공녀이자 나의 언니 엘리벳," + 설정.exit);
			설정.sleep(2500);
			System.out.println(설정.blue + "우리 셋은 어릴 때 부터 친했기 때문에 서로 사이가 돈독했다. " + 설정.exit);
			설정.sleep(2500);
			System.out.println(설정.blue + "그래서 우리는 늘 함께였고 평화로운 나날을 보냈었다.\n" + 설정.exit);
			설정.sleep(2500);
			System.out.println(설정.red + "어느날 갑자기 하늘에 검은 구멍이 생기더니 거기서 다수의 마족들이 쏟아졌다." + 설정.exit);
			설정.sleep(2500);
			System.out.println(설정.red + "그들은 알 수 없는 말을 내뱉으며 우리들을 공격했고," + 설정.exit);
			설정.sleep(2500);
			System.out.println(설정.red + "나의 아버지, 어머니, 유모 그리고 나의 언니 엘리벳을 내 눈 앞에서 죽였다. 나와 다인만 남기고..\n" + 설정.exit);
			설정.sleep(2500);
			System.out.println(설정.blue + "그 참혹한 시간이 지난 후 그들의 왕처럼 보이는 녀석이" + 설정.exit);
			설정.sleep(2500);
			System.out.println(설정.blue + "오빠를 가리키더니, 오빠를 데리고 그 구멍 속으로 들어갔다." + 설정.exit);
			설정.sleep(2500);
			System.out.println(설정.blue + "난 그 후 마왕을 잡기 위해 그리고 나의 유일한 가족, 오빠를 구하기 위해 수련을 떠나게 되었다." + 설정.exit);
		} else {
			System.out.println(설정.blue + "나는 제국의 검이라고 불리는 에스토니아 가문의 대공을 아버지로 둔 제 3소공자이었다." + 설정.exit);
			설정.sleep(2500);
			System.out.println(설정.blue + "제 1소공자이자 나의 형 다인, 제 2공녀이자 나의 누나 엘리벳," + 설정.exit);
			설정.sleep(2500);
			System.out.println(설정.blue + "우리 셋은 어릴 때 부터 친했기 때문에 서로 사이가 돈독했다. " + 설정.exit);
			설정.sleep(2500);
			System.out.println(설정.blue + "그래서 우리는 늘 함께였고 평화로운 나날을 보냈었다.\n" + 설정.exit);
			설정.sleep(2500);
			System.out.println(설정.red + "어느날 갑자기 하늘에 검은 구멍이 생기더니 거기서 다수의 마족들이 쏟아졌다." + 설정.exit);
			설정.sleep(2500);
			System.out.println(설정.red + "그들은 알 수 없는 말을 내뱉으며 우리들을 공격했고," + 설정.exit);
			설정.sleep(2500);
			System.out.println(설정.red + "나의 아버지, 어머니, 유모 그리고 나의 누나 엘리벳을 내 눈 앞에서 죽였다. 나와 다인만 남기고..\n" + 설정.exit);
			설정.sleep(2500);
			System.out.println(설정.blue + "그 참혹한 시간이 지난 후 그들의 왕처럼 보이는 녀석이" + 설정.exit);
			설정.sleep(2500);
			System.out.println(설정.blue + "형을 가리키더니, 형을 데리고 그 구멍 속으로 들어갔다." + 설정.exit);
			설정.sleep(2500);
			System.out.println(설정.blue + "난 그 후 마왕을 잡기 위해 그리고 나의 유일한 가족, 형을 구하기 위해 수련을 떠나게 되었다." + 설정.exit);
			설정.sleep(3000);
		}
	}

	public static void 엔딩1() {
		String arr1[] = {"\n\n\n\n\n\n\n\n\n\n\n\n\n\n",
				"당신은 마왕과 열심히 싸웠습니다.",
				"수많은 노력과 시간을 썼기 때문에 당신은 전보다 강해졌죠.",
				"그러나, 마왕을 쓰러뜨리기에는 역부족이였습니다",
				"마왕은 당신에게 말합니다.",
				설정.back_black + 설정.red +"\"ಹಾಂ, ನಾನು ಅಂದುಕೊಂಡಿದ್ದಕ್ಕಿಂತ ಇದು ತುಂಬಾ ದುರ್ಬಲವಾಗಿದೆ.(흠, 생각보다 너무 약하군.)\"",
				"\"ಮೂರ್ಖತನದಿಂದ, ನೀವು ನನ್ನ ವೇದಿಕೆಯಲ್ಲಿ ಚೆನ್ನಾಗಿ ಮಾಡಿದ್ದೀರಿ.(어리석게도 나의 무대에 잘 임해주었구나.)\"",
				"\"შენი წყალობით მე ჩავყარე საფუძველი მსოფლიო ბატონობას!!!(덕분에 세계정복을 할 수 있게 되었다!!!)\"",
				"\"ಉತ್ತಮ ಕೆಲಸ.(수고했다.)\"", "\"ನಾನೀಗ ಹೊರಡುತ್ತಿದ್ದೇನೆ.(난 이제 가겠다.)\"" + 설정.exit,
				"당신은 마왕이 다인을 끌고 어딘가로 가는 것을 보았지만 이내 숨이 끊어졌습니다...","[Ending 1. 완전히 사라진 에스토니아]"
		};
		for(String i:arr1) {
			System.out.println(i);
			설정.sleep(2500);
		}
	}

	public static void 엔딩2() {
		String arr1[] = {"\n\n\n\n\n\n\n\n\n\n\n\n\n\n",
				"마왕은 정말 쉽게 죽었습니다.",
				"당신은 마왕이 죽었는데도 계속해서 공격을 합니다.",
				"옆에 있던 다인이 당신을 말려보지만",
				"이미 증오에 사로잡힌 당신을 막기에는 역부족이었습니다...",
				"결국 당신은 다인까지 공격하였고 다인은 죽어버렸습니다.",
				"그제서야 당신은 멈추었고 더욱 깊은 절망에 빠져버렸습니다.",	
				설정.back_black + 설정.purple + "\"다인..? 으...으아아아아아아아!!!!\"",
				"\"내가 무슨 짓을!!!!\"", "\"하..하핫.. 다 부질없다...\"",
				설정.red +"\"모든 것을 멸하리라!!!!!!\"" + 설정.exit,"제국의 용사는 이제 제국을 위협할 마왕이 되었습니다."
		};
		for(String i:arr1) {
			System.out.println(i);
			설정.sleep(2500);
		}
		String arr2[] = {"\n\n\n\n\n\n\n\n\n\n\n\n\n\n",
				"|"+설정.back_black+설정.red+"                   "+설정.exit+"           ",
				"|   "+설정.back_black+설정.red+"             "+설정.exit+"           ",
				"|     "+설정.back_black+설정.red+"         "+설정.exit+"           ",
				"|       "+설정.back_black+설정.red+"     "+설정.exit+"           ",
				"|       "+설정.back_black+설정.red+"     "+설정.exit+"           ",
				"|       "+설정.back_black+설정.red+"     "+설정.exit+"           ",
				"|‧●      "+설정.back_black+설정.red+" ‧● 🔥"+설정.exit+"           ",
				"|/█_    "+설정.back_black+설정.red+" √█√ "+설정.exit+"          ",
				"        "+설정.back_black+설정.red+" / \\ "+설정.exit+"︻[]▄▅▆▇◤",
		};
		for(String i:arr2) {
			System.out.println(i);
		}
		System.out.println("[Ending 2. 새로운 마왕의 탄생]");
		설정.sleep(2500);
	}
	
	public static void 엔딩3() {
		String arr1[] = {"\n\n\n\n\n\n\n\n\n\n\n\n\n\n",
				"당신은 드디어 마왕을 쓰러뜨렸고 다인과 감격의 재회를 하였습니다.",
				"당신은 기뻐하였고 다인도 기뻐하는 듯했습니다.",
				설정.red + "그러나 다인은 갑자기 허리춤에 있는 단도로 당신의 심장을 꿰뚫었습니다...!!" + 설정.exit,
				설정.blue + "\"어... 어째서.....!\"" + 설정.exit,
				설정.back_black + 설정.red + "\"하하하하하하하하하하하하하하하하하!!!!!\"",
				"\"너무 즐겁구나!! 이 절망에 빠진 눈빛이여!!!\"" + 설정.exit,	
				설정.blue + "\"으윽.... 다인... 정신차려....!!!\"" + 설정.exit,
				설정.back_black + 설정.red + "\"음? 내가 아직도 다인으로 보이는가?\"",
				"\"참 어리석구나!!! 난 네가 쓰러뜨렸다고 생각한 마왕이란말이다!!!!\"" + 설정.exit,
				"당신은 엄청난 충격을 받았습니다. 다인이 마왕이라니...", "그리고 눈을 감았죠. 영원히.",
				"[Ending 3. 마왕이 된 다인]"
				
		};
		for(String i:arr1) {
			System.out.println(i);
			설정.sleep(2500);
		}
	}

	public static void 엔딩4() {
		String arr1[] = {"\n\n\n\n\n\n\n\n\n\n\n\n\n",
				"ヽ  ｀₊‧      ｀₊‧        ",
				"    ₊‧ヽ     ｀      ｀₊‧ ",
				" ‧₊‧ヽ ‧    ヽ ︻[]▄▅▆▇◤   ",
				" ‧   ‧ ｀ヽ、₊‧●〉     ₊‧ヽ   ",
				"   🔥      █╰╮ ｀₊‧    ｀ ",
				" ●/  ｀₊‧  ∠ ＼  ヽ       ",
				"/█▄▄              ｀₊‧ ",
				};
		for(String i:arr1) {
			System.out.println(i);
		}
		설정.sleep(2500);
		System.out.println("이것이 네가 놓친 에스토니아의 의지다!!!!!!");
		설정.sleep(2500);
		System.out.println(설정.back_black + 설정.red +"크흑... 생각보단 강하군.. 하지만 이건 내 계획의 일부였다...크..크킄.킄킄킄킄"+ 설정.exit);
		설정.sleep(2500);
		System.out.println("당신은 마왕을 쓰러뜨렸습니다!");
		설정.sleep(2500);
		System.out.println("당신은 다인의 "+설정.red+"목걸이"+설정.exit+"가 빛나는 것을 눈치채고");
		설정.sleep(2500);
		System.out.println("다인의 "+설정.red+"목걸이"+설정.exit+"를 부수었습니다.");
		설정.sleep(2500);
		String arr2[] = {"\n\n\n\n\n\n\n\n\n\n\n\n\n",
				"⠀⠀    "+설정.yellow+"⢀⠤⢤⡀"+설정.exit,
				"⠀   "+설정.yellow+"⢰⠃ ⢠⠇"+설정.exit,
				"   ⠀"+설정.yellow+"⣇⢀⠞"+설정.exit,
				"⠀⠀⠀⠀"+설정.red+"⚈"+설정.exit,
				};
		for(String i:arr2) {
			System.out.println(i);
		}
		설정.sleep(2000);
		String arr3[] = {"\n\n\n\n\n\n\n\n\n\n\n\n\n",
				"⠀⠀    "+설정.yellow+"⢀ ⠤  ⢤⡀"+설정.exit,
				"⠀ "+설정.yellow+"⢰ ⠃     ⢠ ⠇"+설정.exit,
				"   ⠀"+설정.yellow+"⣇ ⢀ ⠞"+설정.exit,
				"⠀⠀⠀⠀"+설정.red+"✨"+설정.exit,
				};
		for(String i:arr3) {
			System.out.println(i);
		}
		설정.sleep(2500);
		String arr4[] = {설정.back_black + 설정.red +"\"이런, 내 최후의 수를 들켜버렸군... 젠자아아아아아아아아아아아아앙!!!!!\""+ 설정.exit,
				"이후 마왕은 가루가 되어 사라졌습니다.",
				"당신은 곧바로 다인의 품에 안겼습니다.",
				설정.cyan+"\"동생아, 많이 힘들었지?\""+설정.exit,
				"당신은 따뜻한 그 한마디에 모든 긴장을 놓았습니다.",
				설정.cyan+"\"이제 끝났어. 에스토니아의 사람들은 지금쯤이면 안식을 찾았을 거야.\""+설정.exit,
				설정.blue+"\"그래도 나는 모두를 살리고 싶었는 걸..\""+설정.exit,
				"그 순간 마왕성에 있는 마괴수들 몸에서 빛이 나기 시작합니다.",
				"그 후 죽은줄만 알았던 사람들이 나타났습니다..!?",
				설정.blue+"\"아버지, 어머니, 유모.... 그리고 엘리벳......!\""+설정.exit,
				"당신은 예전의 에스토니아를 되찾았고 모두와 행복하게 잘 지냈습니다."
				};
		for(String i:arr4) {
			System.out.println(i);
			설정.sleep(2500);
		}
		String arr5[] = {"\n\n\n\n\n\n\n\n\n\n\n\n\n",
				"              𝓣𝓱𝓮 𝓔𝓷𝓭 ",
				"  🤴 👸   👩‍🦱        ",
				설정.yellow+" /█\\"+설정.exit+"/█\\  /█\\        ",
				설정.yellow+" /|"+설정.exit+" ███👧 |\\     ",
				" ⊹  ⊹  /"+설정.RED_BRIGHT+"█"+설정.exit+"\\          ",
				"⊹  ● ⊹ "+설정.RED_BRIGHT+"███"+설정.exit,
				" ⊹/█╰             ",
				"⊹ / >⊹            ",
				"\n\n[Ending 4. 진정한 평화]",
				};
		for(String i:arr5) {
			System.out.println(i);
		}
	}
	public static void 흐접엔딩() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("당신의 여정은 마왕을 잡기도 전에 끝나버렸습니다.");
		설정.sleep(2500);
		System.out.println("당신은 여정을 다시 이어서 할 수 있었지만,");
		설정.sleep(2500);
		System.out.println("당신은 그러지 않고 포기했습니다.");
		설정.sleep(2500);
		System.out.println("세상은 마왕에 의해 손쉽게 무너졌고,");
		설정.sleep(2500);
		System.out.println("사람들은 에스토니아 가문이 마왕을 불렀다고 저주하였습니다.");
		설정.sleep(2500);
		System.out.println("분노에 찬 사람들은 당신의 시체를 그냥 산짐승의 밥으로 내버려두었죠.");
		설정.sleep(2500);
		System.out.println(설정.purple + "아무튼, 이게 당신이 진정 원하던 결말인가요?" + 설정.exit);
		설정.sleep(2500);
		String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n\n", "   ending 89. 겁쟁이 용사.       ", "    ᘛ⁐̤ᕐᐷ                 ",
				"               ᑄᒾ⁐̤೨     ", "ᘛ⁐̤ᕐᐷ   ●▅▇█▇▆▅▄▇   ᑄᒾ⁐̤೨", "     ᘛ⁐̤ᕐᐷ                ", };
		for (String i : arr) {
			System.out.println(i);
		}
	}

	public static void 공격창(String mop_name, int mop_hp, int mop_lv, 용사 user) {
		String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n\n",
				String.format("%s lv:%d hp:%d", mop_name, mop_lv, mop_hp),
				"                        ●        ", 
				"      ██              \\/|\\     ",
				"      ██               / \\      ",
				String.format(" %s lv:%d hp:%d mp:%d exp:%d/%d", user.getStat().getName(), user.getStat().getLevel(),
						user.getStat().getHp(), user.getStat().getMp(), user.getStat().getExp(), user.getStat().getMaxExp()),
				"┌───────────────────────────┐",
				"│당신은 무엇을 할건가?            │", 
				"└───────────────────────────┘",
				"   1.공격    2.회복    3.행동 " };
		for (String i : arr) {
			System.out.println(i);
		}
	}

	public static void 처치창(String mop_name, int mop_exp, 용사 user) {
		String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n\n", 
				String.format("%s를(을) 물리쳤다! 경험치 %d를 획득했다.", mop_name, mop_exp),
				"                        ●        ",
				"      ██              \\/|\\     ",
				"      ██               / \\      ",
				String.format(" %s lv:%d hp:%d mp:%d exp:%d/%d", user.getStat().getName(), user.getStat().getLevel(),
						user.getStat().getHp(),user.getStat().getMp(), user.getStat().getExp(), user.getStat().getMaxExp()),
				"┌───────────────────────────┐",
				"│당신은 무엇을 할건가?            │", 
				"└───────────────────────────┘",
				"   1.공격    2.회복    3.행동 " };
		for (String i : arr) {
			System.out.println(i);
		}
		설정.sleep(1000);
	}

	public static void 게임오버창() {
		String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n\n", 
				"▀ █ ▀ █ ▀ ▀ █ ▀ █ ▀ █",
				"   ───────────────   ",
				"  G a m e   o v e r  ",
				"   ───────────────   ",
				"        ▄█▀█●        ", 
				"                     ",
				"█ ▄ █ ▄ ▄ █ ▄ █ ▄ █ ▄", };
		for (String i : arr) {
			System.out.println(i);
		}
	}

	public static void 안내창(int w) {
		if (w == 1) {
			System.out.println(설정.yellow + "새로운 장소 해금!!{에테토스 마을}" + 설정.exit);
			System.out.println(설정.yellow + "직업 해금" + 설정.exit);
			System.out.println(설정.yellow + "퀘스트 해금" + 설정.exit);
			System.out.println(설정.yellow + "상점 해금" + 설정.exit);
		} else if (w == 2) {

		}
	}

	public static void 마을행동창(용사 user) {
		String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n\n", 
				"   |    |       5       |    |   ",
				"   | 1 /                 \\ 3 |   ", 
				"   |  /                   \\  |   ",
				" 2 | /          ●          \\ | 4 ", 
				"   |/         \\/|\\          \\|  ",
				"   /           / \\           \\  ",
				String.format(" %s lv:%d hp:%d exp:%d/%d", user.getStat().getName(), user.getStat().getLevel(),
						user.getStat().getHp(), user.getStat().getExp(), user.getStat().getMaxExp()),
				"┌───────────────────────────────────┐",
				"│당신은 어디로 갈건가?                    │",
				"└───────────────────────────────────┘", 
				"1.대장간 2.잡화점 3.골목길 4.모험가 길드 5.왕궁" };
		for (String i : arr) {
			System.out.println(i);
		}
	}
	
	public static void 마을행동창2(용사 user) {
		String arr[] = {"\n\n\n\n\n\n\n\n\n\n\n\n\n",
				"  |     |    |     |    |     |  ",
				"  |  1  |    |  2  |    |  3  |  ",
				"  |     |    |     |    |     |  ",
				"  (_____)    (_____)    (_____)  ",
				"                                 ",
				"   ●   |     |    |     |       ",
				" \\/|\\  |  4  |    |  5  |       ",
				"  / \\  |     |    |     |       ",
				"       (_____)    (_____)       ",
				String.format(" %s lv:%d hp:%d exp:%d/%d", user.getStat().getName(), user.getStat().getLevel(),
						user.getStat().getHp(), user.getStat().getExp(), user.getStat().getMaxExp()),
				"┌────────────────────────────────┐",
				"│당신은 어디로 갈건가?                 │",
				"└────────────────────────────────┘", 
				" 1.절망  2.증오  3.복수  4.단서  5.열쇠" 
				};
		for (String i : arr) {
			System.out.println(i);
		}
	}
	
	public static void 마왕성창() {
		String arr[] = {"\n\n\n\n\n\n\n\n\n\n\n\n\n",
				"    ^      /\\      ^       ",
			    "   / \\    /  \\    / \\    ",
			    "  ┌┐_┌┐ :┌┐__┌┐: ┌┐_┌┐      ",
			    "  └I─I┘  └I👁️I┘  └I─I┘      ",
			    "   I I    I  I    I I       ",
			    "   I I    I  I    I I       ",
			    "  ┌┐_┌┐┌┐_┌─┐_┌┐┌┐_┌┐       ",
			    "  └\\__👁️👁️👁️👁️👁️👁️__/┘      ",
			    "    I👁️   ___   👁️I          ",
			    "    I  👁️/ i \\👁️  I         ",
			    "    I👁️ I: i :I 👁️I          ",
			    " ___I___I:_i_:I___I___      ",
			    "/                     \\    ",
					};
			for(String i:arr) {
				System.out.println(i);
			}
	}


	public static void 대장간(용사 user, int w) {
		if (w == 1) {
			String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n\n", "        |          |   ||",
					"        |" + 설정.yellow + "대장장이" + 설정.exit + "____┌────┐|       ",
					"       /   ●     |" + 설정.back_yellow + "┌───┐" + 설정.exit + " |\\       ",
					"      /" + 설정.red + "⊹_" + 설정.exit + "🔨૮█    |" + 설정.back_yellow + "|_" + 설정.red + 설정.back_yellow
							+ "🔥" + 설정.exit + 설정.back_yellow + "_|" + 설정.exit + "__|\\      ",
					"     /  ▀       ●          \\     ", 
					"    /         \\/|\\          \\   ",
					"   /           / \\           \\  ",
					"┌───────────────────────────────┐",
					"│당신은 무엇을 할건가?                │",
					"└───────────────────────────────┘",
					"   1.구매   2.강화   3.대화   4.공격 " };
			for (String i : arr) {
				System.out.println(i);
			}
		} else if (w == 2) {
			String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n\n", 
					"여기! 내가 직접 만든거니 품질이 아주 좋아!", 
					"=================================",
					" 1.🪓     2.🔪      3.🗡️     4.⚔️  ",
					"=================================", 
					"          5.▬▬ι═══════ﺤ         ",
					"          6.︻[]▄▅▆▇◤           ", 
					"=================================" };
			for (String i : arr) {
				System.out.println(i);
			}
		} else if (w == 3) {
			System.out.println("미안하네... 난 무기 강화에는 손을 뗀지 오래되었다네..");
			설정.sleep(1000);
		} else if (w == 4) {
			System.out.println("나랑 대화를 하고싶다고? 허! 애송이는 가라");
			설정.sleep(1000);
		}else if (w==5) {
			String arr[] = { "(흠... 애송이는 아니구먼..)",
					"자네, 마이하스 산에서 나는 약초를 구해다 줄 수 있겠나?",
					설정.blue+"제가 왜 해야하죠?"+설정.exit,
					"사실, 내 아내가 에스토니아 근처 숲에서 점심거리를 구한 뒤로부터 몸이 안 좋아졌어.",
					"그래서 치유사에게 부탁을 했지만 몸이 낫기는 커녕 더 안 좋아졌다네..",
					"난 그 뒤로 강화하는 일은 그만두고 아내의 몸을 고칠 방법을 찾던 중",
					"최근 마이하스 산에 "+설정.purple+"엘리벳의 눈물"+설정.exit+"이라는 모든 병이 낫는 약초가 있다는 사실을 알게되었네.",
					"그래서, 자네가 이 약초를 찾아준다면 사례는 두둑히 주겠다네."};
			for (String i : arr) {
				System.out.println(i);
				설정.sleep(2000);
			}
		}else if(w==6){
			String arr[] = { "오오...! 이것이 엘리벳의 눈물...!",
					"여보 이것좀 먹어봐요. 모든 병이 낫는 약초에요...",
					"그 순간 대장장이 아내의 안색이 괜찮아졌다.",
					"다행이다...",
					"여..여보..내 말좀.. 들어줘요..",
					"왜그래 여보? 설마 어디 아픈거요?",
					"아뇨.. 아주 멀쩡해요..",
					"그럼 뭔가요..?",
					"제가 서쪽숲에 가서 점심거리를 구하고 있을때 일어난 일이에요.",
					"여느때처럼 점심거리를 구하고 있었는데 제 앞에 갑자기 마왕이 나타난 거에요!",
					"마왕은 제 목을 붙잡고 다짜고짜 지금 당장 \"진실의 서재\"에 가서 책을 찢고 오라고 명령했어요..",
					"그래서 진실의 서재에 가서 마왕이 말한 책을 찢으려고 책을 집어들었는데...",
					"눈을 떠보니 난생 처음 걸려보는 병과 함께 서쪽숲에 누워있었고 그대로 정신을 잃었답니다...",
					"(진실의 서재는 도대체..)",
					"아무튼 여기 사례금^^",
					"1000골드를 받았다.."};
			for (String i : arr) {
				System.out.println(i);
				설정.sleep(2000);
			}
		}else {
			System.out.println("오케이 나랑 싸우고 싶다는 거지?");
			설정.sleep(1000);
		}
	}

	public static void 잡화점(용사 user, int w) {
		if(w == 1) {
			String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n\n", 
					"        |┌─┐┌─┐┌─┐┌─┐┌─┐|        ",
					"        |└─┘└─┘└─┘└─┘└─┘|        ",
					"        |========" + 설정.red + "잡화상" + 설정.exit + "===|        ",
					"       /        /\\_/\\    \\       ", 
						"      /   _____( •ﻌ• )_____\\      ",
					"     /    |     ●          \\     ", 
					"    /         \\/|\\          \\   ",
					"   /           / \\           \\  ", 
					"┌───────────────────────────────────┐",
					"│당신은 무엇을 할거냥?                    │",
					"└───────────────────────────────────┘",
					" 1.구매     2.대화     3.공격" };
				
			for (String i : arr) {
				System.out.println(i);
			}
		}else if(w == 2) {
			String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n\n", 
					"          어떤 걸 원하냥?•ﻌ•          ",
					"             ____                ",
					"          ⡞⠳⣄|⣀Ϟ⣀|⣀⣠⠞⢷            ", 
					"         ⣾　          ⣷           ",
					"         ⠻⣄   ᦲ ᆺ ᦲ  ⣠⠟           ",
					"      🔍⣠⡿           ⢿⣄           ",
					"        ⠙⠛⣾         ⣷⠛⠋💼         ",
					"=================================", 
					" 1.🗝️   2.🏴‍☠️   3.🔮   4.🧸   5.🧶",
					"=================================" };
			for (String i : arr) {
				System.out.println(i);
			}
		}else if(w == 3) {
			String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n\n", 
					"          무슨 말을 할꺼냥?           ",
					"             ____                ",
					"          ⡞⠳⣄|⣀Ϟ⣀|⣀⣠⠞⢷            ", 
					"         ⣾　          ⣷ ??        ",
					"         ⠻⣄   ᦲ ᆺ ᦲ  ⣠⠟           ",
					"      🔍⣠⡿           ⢿⣄           ",
					"        ⠙⠛⣾         ⣷⠛⠋💼         ",
					"=================================", 
					"1.데스필교 어때? 2.웬 고양이?  3.귀엽당...",
					"=================================" };
			for (String i : arr) {
				System.out.println(i);
			}
		}else {
			System.out.println("...");
			설정.sleep(1000);
		}
	}

	public static void 골목길(용사 user, int w) {
		if (w == 1) {
			String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n\n",
					"    " + 설정.BLACK_BOLD_BRIGHT + "스레타하" + 설정.exit + "       |        ",
					"      ● /        \\      ",
					"     <█          \\     ", 
					"      |>           \\    ",
					"    /       ●       \\   ",
					"   /      \\/|\\       \\  ",
					"┌───────────────────────┐",
					"│당신은 무엇을 할건가?        │",
					"└───────────────────────┘", 
					" 1.대화   2.그냥가기   3.공격 " };
			for (String i : arr) {
				System.out.println(i);
			}
		} else if (w == 2) {
			String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n\n",
					"         " + 설정.back_black + "       " + 설정.exit + "         ",
					"        " + 설정.back_black + "         " + 설정.exit + "        ",
					"        " + 설정.back_black + " " + 설정.BLACK_BACKGROUND_BRIGHT + "       " + 설정.back_black + " "+ 설정.exit + "        ",
					"        " + 설정.back_black + "   " + 설정.BLACK_BACKGROUND_BRIGHT + "   " + 설정.back_black + "   "+ 설정.exit + "          ",
					"       " + 설정.back_black + "           " + 설정.exit + "       ",
					"     " + 설정.back_black + "               " + 설정.exit + "     ",
					설정.back_black + 설정.purple + "┌───────────────────────┐" + 설정.exit,
					설정.back_black + 설정.purple + "│호호호.. 당신, 절망에 빠졌군요.│" + 설정.exit,
					설정.back_black + 설정.purple + "└───────────────────────┘" + 설정.exit,
					" 1.?뭔솔   2.(무시)   3.네. " };
			for (String i : arr) {
				System.out.println(i);
			}
			설정.sleep(1000);
		} else if (w == 3) {
			System.out.println("호호호.. 잘가요, 절망이시여..");
			설정.sleep(1000);
		} else {
			System.out.println(설정.back_black+설정.purple+"호호.. " + user.getStat().getName() + ".. 나를 죽이면 후회할 것이다..."+설정.exit);
			설정.sleep(1000);
		}
	}
	
	public static void 스레타하(용사 user, int a) {
		if(a==1) {
			System.out.println(설정.back_black+설정.purple+"저는 스레타하, 데스필교의 증오의 신을 찾고 있죠.. 호호호호....");
			설정.sleep(1300);
			System.out.println("당신에게는 거대한 힘이 보이군요... 마치 증오의 신같은..."+설정.exit);
			설정.sleep(1300);
			System.out.println("(이상한 사람인 것 같다... 그냥 가자)");
			설정.sleep(1400);
		}else if(a==2) {
			System.out.println(설정.back_black+설정.purple+"절망은 피할 수 없는 법!"+설정.exit);
			설정.sleep(1300);
			System.out.println(설정.back_black+설정.purple+"당신은 결국 저희에게 오게될 것입니다!!!!"+설정.exit);
			설정.sleep(1400);
		}else if(a==3) {
			System.out.println(설정.back_black+설정.purple+"오..? 당신 절망에 대해 아는게 있으신가요?"+설정.exit);
			설정.sleep(1300);
			System.out.println(설정.blue+"\"어? 내가 왜 이런 대답을...?\""+설정.exit);
			설정.sleep(1300);
			System.out.println(설정.back_black+설정.purple+"흠.. 아 제 소개가 늦었군요.. 저는 스레타하, 데스필교의 증오의 신을 찾고 있습니다."+설정.exit);
			설정.sleep(1300);
			System.out.println(설정.back_black+설정.purple+"하지만, 방금 막 찾은 것 같군요..."+설정.exit);
			설정.sleep(1300);
			System.out.println(설정.back_black+설정.purple+user.getStat().getName()+"님, 저 스레타하가 데스필교까지 모시도록 하겠습니다."+설정.exit);
			설정.sleep(1400);
		}else {
			System.out.println(설정.back_black+설정.purple+"음? 아무말도 안하시군요... 호호호호..."+설정.exit);
			설정.sleep(1000);
		}
	}

	public static void 모험가길드(용사 user, int w) {
		if (w == 1) {
			String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n\n", "        |               |        ",
					"        |========" + 설정.yellow + "릴리아" + 설정.exit + "===|        ",
					"       /           ●     \\       ", 
					"      /   ________/█\\_____\\      ",
					"     /    |     ●          \\     ", 
					"    /         \\/|\\          \\   ",
					"   /           / \\           \\  ", 
					"┌───────────────────────────────────┐",
					"│당신은 무엇을 할건가?                    │",
					"└───────────────────────────────────┘",
					" 1.모험가 등록   2.퀘스트   3.판매   4.공격" };
			for (String i : arr) {
				System.out.println(i);
			}
		} else if (w == 2) {
			String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n\n", 
					"          ⣠⠛⠛⣄⣠⠶⠛⠛⠛⠶⣄⣠⠛⠛⣄          ",
					"         ⢿  ⠋　　　　 　⠙ 　⡿         ",
					"           ⣾　 ●　ᴥ　●  ⣷           ",
					"            ⠻⣄　        　  ⣠⠟            ", 
					"           ⣠⡿   🎀   ⢿⣄           ",
					"           ⠶ ⣠      ⣄ ⠶           ", 
					"==================================",
					"║          ┌─────────┐    ▲      ║",
					"║          |모험가 등록증|    █      ║",
					"║          |~~~~~~~~~|    █      ║", };
			for (String i : arr) {
				System.out.println(i);
			}
			설정.sleep(1000);
		} else if (w == 3) {
			System.out.println("현재 받을 수 있는 퀘스트가 없습니다.");
			설정.sleep(1000);
		} else if (w == 4) {
			System.out.println("현재 가지고 있는 물품이 없습니다.");
			설정.sleep(1000);
		} else if (w == 89) {
			String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n\n",
					"    /          /|         * *      ",
					"   /＼●        ( |＼●     * ● *     ",
					"     />        \\| /∨    * √|∨*    ",
					"    <＼          />      * /\\*    ",
					"    " + 설정.back_black + 설정.RED_BOLD_BRIGHT + "검사" + 설정.exit + "         " + 설정.back_black
							+ 설정.GREEN_BOLD_BRIGHT + "궁수" + 설정.exit + "       " + 설정.back_black + 설정.BLUE_BOLD_BRIGHT
							+ "마법사" + 설정.exit + "    ", };
			for (String i : arr) {
				System.out.println(i);
			}
		} else {
			System.out.println("저희의 서비스가 마음에 안들었다니 유감이네요.");
			설정.sleep(1000);
		}
	}
	
	public static void 왕궁(용사 user, int w) {
		String arr[] = {"\n\n\n\n\n\n\n\n\n\n\n\n\n",
				"           "+설정.back_yellow+" "+설정.exit+"   "+설정.back_yellow+" "+설정.exit,
				"           "+설정.back_yellow+"  "+설정.exit+" "+설정.back_yellow+"  "+설정.exit,
				"           "+설정.back_yellow+"     "+설정.exit,
				"         "+설정.back_blue+"         "+설정.exit,
				"        "+설정.back_blue+"  "+설정.YELLOW_BACKGROUND_BRIGHT+" "+설정.back_black+"  "+설정.YELLOW_BACKGROUND_BRIGHT+" "+설정.back_black+"  "+설정.YELLOW_BACKGROUND_BRIGHT+" "+설정.back_blue+"  "+설정.exit,
				"         "+설정.YELLOW_BACKGROUND_BRIGHT+"   "+설정.back_green+" "+설정.YELLOW_BACKGROUND_BRIGHT+" "+설정.back_green+" "+설정.YELLOW_BACKGROUND_BRIGHT+"   "+설정.exit,
				"          "+설정.YELLOW_BACKGROUND_BRIGHT+"       "+설정.exit,
				"            "+설정.YELLOW_BACKGROUND_BRIGHT+"   "+설정.exit,
				"     "+설정.back_yellow+"       "+설정.back_green+"   "+설정.back_yellow+"       "+설정.exit,
				"    "+설정.back_red+"       "+설정.back_white+"     "+설정.back_red+"       "+설정.exit,
				"    "+설정.back_red+"       "+설정.back_white+"     "+설정.back_red+"       "+설정.exit,				
				};
		for(String i:arr) {
			System.out.println(i);
		}
		if (w == 1) {
			String arr1[] = {
					설정.back_yellow+"흠...? 궁정마법사 셰리? 이놈의 신원을 확인해줘",
					"뭐? 확인할 수 있는게 레벨과 이름만 가능하다고?? 쯧 도움이 안되네",
					"어디보자.. 뭐야 "+user.getStat().getLevel()+"lv밖에 안되잖아?",
					"니깟게 나와 대화할 수 있다고 생각하는가? 당장 꺼져라!"+설정.exit,
					};
			for(String i:arr1) {
				System.out.println(i);
				설정.sleep(2000);
			}
		}else if (w == 2) {
			String arr1[] = {
					설정.back_yellow+"흠...? 궁정마법사 셰리? 이놈의 신원을 확인해줘",
					"뭐? 확인할 수 있는게 레벨과 이름만 가능하다고?? 쯧 도움이 안되네",
					"어디보자.. 음? 오~ 우리나라의 용사, "+user.getStat().getName()+"이 아닌가?",
					"무슨일로 온게냐?"+설정.exit, "당신은 그냥 보고 싶어서 왔다고 하였다.",
					설정.back_yellow+"하하하하! 아이고 내 손주도 이렇게 애교가 많았으면 좋겠구먼...",
					"나를 할애비라고 생각하며 자주 오거라~~", "하... 셰리, 저 놈 그 망해빠진 에스토니아의 자식이지?",
					"참 탐나는 인재구먼... 내 양손주로 받아들일 수는 없나..?",
					"알잖아~ 내 손주는 실패작인거.. 마력도, 검술도, 궁술도... 나라를 지킬만한 힘이 없어 쯧쯧쯧",
					"에휴..."+설정.exit,
					};
			for(String i:arr1) {
				System.out.println(i);
				설정.sleep(2000);
			}
		}else if (w == 3) {
			String arr1[] = {
					설정.back_yellow+"흠...? 궁정마법사 셰리? 이놈의 신원을 확인해줘",
					설정.purple+"도망가십시오 전하. 이 자에게서 엄청난 살의가 느껴집니다...",
					설정.back_yellow+설정.black+"무...무슨...?",
					설정.back_black+설정.purple+"감히 나의 소중한 에스토니아를....",
					설정.back_yellow+설정.black+"윽... 이 녀석 설마...?",
					설정.back_black+설정.purple+"너도 알고 있겠지.. 오늘 여기는 너의 무덤이 되는 동시에 에스토니아가 될 예정이다.", 
					설정.back_yellow+설정.black+"셰리!! 빨리 저 녀석을 죽여라!!!!!!!",
					"셰리? 왜 그래 셰리...?",
					설정.purple+"전하... 저는 이 자를 이길 수 없습니다...",
					"전하 빨리 제가 시간을 벌 동ㅇ..."+설정.exit,
					"(셰리의 몸이 빠르게 잠식당한다...)",
					설정.back_yellow+설정.black+"으...으악!!!!! 사람 살려!!!!",
					"제발... 내 모든 것을 바칠테니 목숨만은...",
					설정.back_black+설정.purple+"절대 그럴순 없지... 내 행복한 복수를 위해선... 피가 필요해...",
					설정.back_yellow+설정.black+"살ㄹ",
					설정.back_black+설정.purple+"하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하\n"
							+ "하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하\n"
							+ "하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하\n"
							+ "하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하\n"
							+ "하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하\n"
							+ "하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하\n"
							+ "하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하\n"
							+ "하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하\n"
							+ "하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하\n"
							+ "하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하하",
					"아주 만족스럽구나!!!! 맛있도다 맛있어!!!!"+설정.exit,
					};
			for(String i:arr1) {
				System.out.println(i);
				설정.sleep(2000);
			}
		}
	}

	public static void 데스필교(용사 user) {
		String arr[] = {"\n\n\n\n\n\n\n\n\n\n\n\n\n",
				"       ",
				"       __",
				"      / \\\\",
				"      |O||",
				" -----| |/\\",
				"        /  \\",
				" ------/ /\\ \\",
				"  O O  | || |",
				"       | || |",
				"-------------",
		};
		for(String i:arr) {
			System.out.println(i);
		}
	}
	
	public static void 데스필교행동창(용사 user, int w) {
		String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n\n",
				"        _________________          ",
				"       /|               |\\        ",
				"      / |    Are you    | \\       ",
				"     /  |{h}{a}{t}{e}{r}|  \\      ",
				"    /   |    (__?__)    |   \\     ",
				"   /| /||   [|     |]   ||\\ |\\   ",
				"  /||/ ||    )     (    || \\||\\  ",
				" / ||| ||   (       )   || ||| \\  ",
				"/  ||| /                 \\ |||  \\", 
				" /||||/         ●         \\||||\\ ",
				"/ |||/         /|\\         \\||| \\", 
				"  ||/          / \\          \\||  ",
				"  |/                         \\|  ",
				};
		for (String i : arr) {
			System.out.println(i);
		}
		설정.sleep(1500);
		if(w == 1){
			System.out.println(설정.red+"절망의 길을 통과하신 분...");
			설정.sleep(1500);
			System.out.println("이제 절망의 맛을 보았으니, 타락의 맛도 보셔야죠.. 뇽뇽뇽...");
			설정.sleep(1500);
			System.out.println("저는 타락의 하수인...의 대리입니다.");
			설정.sleep(1500);
			System.out.println("타락의 길은 타락의 하수인을 찾는 것입니다.");
			설정.sleep(1500);
			System.out.println("쉽진 않을 겁니다. 저조차도 타락의 하수인님을 찾기 힘들거든요..");
			설정.sleep(1500);
			System.out.println("힘내세요..뇽뇽뇽"+설정.exit);
			설정.sleep(1500);
		}else if(w==2) {
			System.out.println(설정.back_black+설정.back_yellow+"음? 어우 타락의 냄새;;");
			설정.sleep(1500);
			System.out.println("빨리 냄새를 지워야겠어요.. 진실의 서재에 가서 빨리 탐욕을 알아오세요.. 우욱");
			설정.sleep(1500);
			System.out.println("타락은 오물냄새와 같다니까 으.."+설정.exit);
			설정.sleep(1500);
			System.out.println("(저 멀리서 타락의 하수...아니 대리가 욕을 하며 뛰어오는 것이 보인다..)");
			설정.sleep(1500);
		}else if(w==3){
			System.out.println(설정.green+"탐욕은 늘 타락을 싫어해요..");
			설정.sleep(2000);
			System.out.println("물론 겉으로만 싫어하는 것이죠ㅎㅎ");
			설정.sleep(2000);
			System.out.println("사실 탐욕은 타락을 좋아합니다ㅎㅎ"+설정.exit);
			설정.sleep(2000);
			System.out.println(설정.back_black+설정.back_yellow+"ㅁ..뭐라고?? 이 잡초도 키우지 못하는게?"+설정.exit);
			설정.sleep(2000);
			System.out.println(설정.green+"나도 키우고 싶다고요! 이 빌어먹을 죽음의 힘때문에 다 죽는다고!!");
			설정.sleep(2000);
			System.out.println("앗? 당신을 잊고있었네요.. 당신도 이 죽음의 힘을 얻어야해요.");
			설정.sleep(2000);
			System.out.println("라니아나 던전에 가서 생명의 돌을 얻어오세요."+설정.exit);
			설정.sleep(2000);
			System.out.println(설정.back_black+설정.back_yellow+"아하~ 죽음의 힘은 그냥 줄 수 있으면서 잡초들 키우고 싶으니까 그 돌 가져오라는 거지ㅋㅋ"+설정.exit);
			설정.sleep(2000);
			System.out.println("(이번에는 탐욕과 죽음이 싸우고 있다.. 타락 대리는 부끄러워하고 있다..)");
			설정.sleep(2000);
		}else if(w==4) {
			System.out.println(설정.back_black+설정.purple+"어머나~ 설마 모든 길을 다 갔다온거야~?");
			설정.sleep(1500);
			System.out.println("내 동생 스레타하가 제대로 데리고 왔나보네~");
			설정.sleep(1500);
			System.out.println("하.지.만.");
			설정.sleep(1500);
			System.out.println("증오는 다루기 힘들텐뎅ㅎ");
			설정.sleep(1500);
			System.out.println("넌 진심으로 남을 증오해본 적이 없는 용.사.잖.아~");
			설정.sleep(1500);
			System.out.println("어멋? 한심해라~ 그건 증오보단 분노인걸~");
			설정.sleep(1500);
			System.out.println("제대로 알아와봐~ 아마 시실리아 세계수에서 알 수 있을꺼야~"+설정.exit);
			설정.sleep(1500);
		}else {
			System.out.println(설정.back_black+설정.purple+"당신은 지금부터 절망, 타락, 탐욕, 죽음, 증오를 배워야합니다.");
			설정.sleep(1500);
			System.out.println("우선 절망의 길을 해야하는데...");
			설정.sleep(1500);
			System.out.println("음~ 향기로운 절망의 냄새...");
			설정.sleep(1500);
			System.out.println("이미 당신은 절망의 힘을 가지고 있네요...");
			설정.sleep(1500);
			System.out.println("어쩔 수 없죠.. 절망의 길은 통과입니다"+설정.exit);
			설정.sleep(1500);
			System.out.println("(너무 쉽다..)");
			설정.sleep(1500);
		}
	}

	public static void 채집창(용사 user) {
		if(user.getStat().getPlace().equals("서쪽 숲")) {
			System.out.println(설정.blue+"풀..돌...나무.. 그냥 숲이다.."+설정.exit);
			설정.sleep(1000);
		}else if(user.getStat().getPlace().equals("라니아나 던전")) {
			System.out.println(설정.blue+"돌,돌,돌 그리고, 돌이다. 왜 광석이 없지?"+설정.exit);
			설정.sleep(1000);
			if(user.getStat().getQuest().equals("죽음의 길")) {
				System.out.println("이 던전은 이상하다... 온통 돌밖에 없다...");
				설정.sleep(1500);
				System.out.println("어? 이 돌은 모양이 희한하네?");
				설정.sleep(1500);
				System.out.println("(돌을 만지니 초록색의 빛이 난다...!)");
				설정.sleep(1500);
				System.out.println("세상에 만지니까 돌이 보석이 되었어!!");
				설정.sleep(1500);
				System.out.println("라니아나 던전의 광석들은 돌로 둔갑하고 있었구나!");
				설정.sleep(1500);
				System.out.println(설정.green+"생명의 돌을 얻었다!"+설정.exit);
				설정.sleep(1500);
			}
		}else if(user.getStat().getPlace().equals("마이하스산")) {
			if (user.getStat().getQuest().equals("대장장이의 부탁")) {
				System.out.println(설정.blue+"도대체 약초 이름이 \"엘리벳의 눈물\"인거지?"+설정.exit);
				설정.sleep(1000);
				System.out.println(설정.blue+"어? 이건가?"+설정.exit);
				설정.sleep(1000);
				System.out.println(설정.blue+"빨리 가서 주자."+설정.exit);
				설정.sleep(1000);
			}else {
				System.out.println(설정.blue+"음 등산만 했다."+설정.exit);
				설정.sleep(1000);
			}
		}else if(user.getStat().getPlace().equals("절망의 고원")) {
			System.out.println(설정.blue+"예전에는 여기가 \"희망의 고원\"이었다지?"+설정.exit);
			설정.sleep(1000);
		}else if(user.getStat().getPlace().equals("진실의 서재")) {
			System.out.println(설정.blue+"와 정말 많은 책들이 있다!!"+설정.exit);
			설정.sleep(1300);
			System.out.println("갑자기 내 앞에 책 한 권이 떨어졌다.");
			설정.sleep(1300);
			if(user.getStat().getQuest().equals("탐욕의 길")) {
				String arr[] = {
						설정.purple+"세상의 진실? 읽어봐야지~"+설정.exit,"이 세상에 있는 국가는 총 4개이다.","자연의 나라, 이시스.",
						"검의 나라, 자이로스.","마법의 나라, 사살리우스.","그리고, 희망의 나라, 에스토니아.",
						"그중 에스토니아가 가장 부귀한 나라였다.","어느날, 사살리우스에서 무시무시한 전염병이 퍼졌다.",
						"순식간에 사람들은 마괴수들로 변하였고, 다른 세 국가는 사살리우스를 봉쇄하였다.",
						"그 후 사살리우스 국왕이 이시스에 전쟁을 선포하였다. 많은 마괴수와 함께..",
						"사살리우스 국왕도 감염이 된 것인지는 몰라도 더 이상 인간이라고 부를수 없었다.",
						"당연히 자연만 좋아했기에 군사력이 0에 수렴하는 이시스는 너무 쉽게 무너졌고",
						"단 2년만에 두 국가가 지도상에서 사라졌다.",
						"살아남았던 두 국가는 두려움에 떨고 있었다. 왜냐하면 언젠가는 자신들이 피해를 입을게 뻔하니..",
						"그래서 두 국가는 힘을 합쳐 한 국가로 만들기로 조약을 맺었다.","당연히 자이로스가 에스토니아 산하로 들어가는 구조였다.",
						"그러나 자이로스 국왕은 이를 탐탁지 않게 여겼고,","그래서 자이로스 국왕이 기념식에서 에스토니아 국왕을 살해했다.",
						"에스토니아 가문은 멸문될 뻔했지만 에스토니아 국왕의 동생은 적당한 작위만 주면 가만히 있겠다고 하여 멸문까진 되지 않았다.",
						"자이로스 국왕은 그 후 이 일을 이 곳, 진실의 서재에 영원히 봉인하였다.",
						"현재는 이 일을 아는 사람들은 다 죽었고, 현 자이로스 대제국의 만행을 아무도 모른다.",
						설정.back_black+설정.purple+"... 감히 우리의 선조를 죽이고 잘 살고 있다고??","...용서하지않겠어.",
						"일단 마왕부터 죽이고 왕궁을 쳐부숴버리겠어."+설정.exit
				};
				for (String i : arr) {
					System.out.println(i);
					설정.sleep(2000);
				}
			}else if(user.getStat().getQuest().equals("마왕의 모략")) {
				System.out.println(설정.blue+"마왕의 비밀? 약점이 있을지도 몰라! 읽어봐야지~"+설정.exit);
				설정.sleep(2000);
				System.out.println("마왕은 아주 강력한 힘을 가지고 있다.");
				설정.sleep(2000);
				System.out.println("마괴수들을 다루는 강력한 힘... 그러나 이뿐만이 아니다.");
				설정.sleep(2000);
				System.out.println("마왕은 사실, 죽음이 다가올 때쯤이면 인간 하나를 납치해온다.");
				설정.sleep(2000);
				System.out.println("단 조건이 있는데 바로 자신을 죽여줄 \"용사\"를 만들어야한다.");
				설정.sleep(2000);
				System.out.println("그래야지 새로운 몸으로 옮길때 필요한 힘을 얻을 수 있기 때문이다.");
				설정.sleep(2000);
				System.out.println("마왕은 옮겨갈 몸에 표식을 남기는데 좀 처럼 찾기 힘들다.");
				설정.sleep(2000);
				System.out.println("하지만 마괴수들은 마왕과 연결되어있다. 그리고 특히 진실의 서재에 있는 마괴수들은 \"오직 진실만을\" 말한다.");
				설정.sleep(2000);
				System.out.println("그러나 이미 몬스터들을 쓰러뜨렸다면, 어쩔 수 없다. 기억해라 그들의 이름을!");
				설정.sleep(2000);
				System.out.println("음 아주 중요한 정보를 얻었다.");
				설정.sleep(2000);
			}else {
				System.out.println("근데 책이 안 펼쳐진다.. "+설정.purple+"특수한 마법"+설정.exit+"이라도 걸린 것처럼...");
				설정.sleep(1300);
			}
		}else if(user.getStat().getPlace().equals("이실리아 세계수")) {
			if(user.getStat().getQuest().equals("증오의 길")) {
				System.out.println("왜 나무의 주인이 이실리아인거지?");
				설정.sleep(2000);
				System.out.println(설정.back_green+"왜냐하면 제 언니 시실리아는 큰 죄를 저질렀기 때문이죠."+설정.exit);
				설정.sleep(2000);
				System.out.println("넌 누구냐!");
				설정.sleep(2000);
				System.out.println(설정.back_green+"전 이실리아, 현 나무의 주인이죠.");
				설정.sleep(2000);
				System.out.println("당신은 시실리아를 만나러 온 모양이군요.");
				설정.sleep(2000);
				System.out.println("죄송하지만, 당신은 시실리아를 만날 수 없습니다."+설정.exit);
				설정.sleep(2000);
				System.out.println("뭐...뭐라고?? 아니 난 만나야해. 꼭.");
				설정.sleep(2000);
				System.out.println(설정.back_green+"하... 참 끈질기시군요.");
				설정.sleep(2000);
				System.out.println("시실리아는 이미 봉인 당한지 오래입니다.");
				설정.sleep(2000);
				System.out.println("아마 지금쯤이면 마수가 되었을지도.");
				설정.sleep(2000);
				System.out.println("멍청한 시실리아, 그러니까 속지ㅎㅎ");
				설정.sleep(2000);
				System.out.println("정 만나고 싶다면 찾아보시지요. 이 세계수 어딘가에 있는 시실리아를! 하하하하핳"+설정.exit);
				설정.sleep(2000);
				System.out.println("이런.. 시실리아는 이실리아에게 속았군..");
				설정.sleep(2000);
				System.out.println("골치 아프군..");
				설정.sleep(2000);
			}else {
				System.out.println(설정.blue+"음? 이실리아? 원래 \"시실리아\" 세계수 아니였나?"+설정.exit);
				설정.sleep(1000);
				System.out.println(설정.blue+"이상하네..."+설정.exit);
				설정.sleep(1000);
			}
		}
	}

	public static void NPC공격창(String npc_name, int npc_hp, int npc_lv, 용사 user, int num) {
		String items[] = { "🔨", "🧹", "🌌", "🪓", "⚔️" };
		String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n\n", 
				String.format("%s lv:%d hp:%d", npc_name, npc_lv, npc_hp),
				"      ●                ●        ", 
				String.format("   %s███🛡️            \\/|\\     ", items[num]),
				"      █               / \\      ",
				String.format(" %s lv:%d hp:%d exp:%d/%d", user.getStat().getName(), user.getStat().getLevel(),
						user.getStat().getHp(), user.getStat().getExp(), user.getStat().getMaxExp()),
				"┌───────────────────────────┐",
				"│당신은 무엇을 할건가?            │",
				"└───────────────────────────┘",
				"   1.공격    2.회복    3.행동 " };
		for (String i : arr) {
			System.out.println(i);
		}
	}

	public static void 절망() {
		String arr[] = {"\n\n\n\n\n\n\n\n\n\n\n\n\n",
				"        "+설정.BLACK_BACKGROUND_BRIGHT+"|  |  |  |  |"+설정.exit+"       ",
				"       "+설정.BLACK_BACKGROUND_BRIGHT+"||  | | | |  ||"+설정.exit+"      ",
				"      "+설정.BLACK_BACKGROUND_BRIGHT+"| |  || O ||  | |"+설정.exit+"     ",
				"     "+설정.BLACK_BACKGROUND_BRIGHT+"|  |  |  O  |  |  |"+설정.exit+"    ",
				"    "+설정.BLACK_BACKGROUND_BRIGHT+"||  | |       | |  ||"+설정.exit+"   ",
				"   "+설정.BLACK_BACKGROUND_BRIGHT+"| |  || ▃▂▁▁▂▃ ||  | |"+설정.exit+"  ",
				"  "+설정.BLACK_BACKGROUND_BRIGHT+"|  |  |           |  |  |"+설정.exit+" ",
				"┌───────────────────────────┐",
				"│           절망적.           │",
				"└───────────────────────────┘",
				"  1.잡아먹기  2.받아들이기  3.공격  ",
				};
		
		for (String i : arr) {
			System.out.println(i);
		}
	}

	public static void 증오() {
		String arr[] = {"\n\n\n\n\n\n\n\n\n\n\n\n\n",
				"        "+설정.back_black+설정.purple+"|  |  |  |  |"+설정.exit+"       ",
				"       "+설정.back_black+설정.purple+"||  | | | |  ||"+설정.exit+"      ",
				"      "+설정.back_black+설정.purple+"| |  || O ||  | |"+설정.exit+"     ",
				"     "+설정.back_black+설정.purple+"|  |  |  O  |  |  |"+설정.exit+"    ",
				"    "+설정.back_black+설정.purple+"||  | |       | |  ||"+설정.exit+"   ",
				"   "+설정.back_black+설정.purple+"| |  || ▃▂▁▁▂▃ ||  | |"+설정.exit+"  ",
				"  "+설정.back_black+설정.purple+"|  |  |           |  |  |"+설정.exit+" ",
				"┌──────────────────────────┐",
				"│        증오를 받아라.        │",
				"└──────────────────────────┘",
				" 1.잡아먹기  2.받아들이기  3.공격  ",
				};
		for(String i:arr) {
			System.out.println(i);
		}
	}

	public static void 복수() {
		String arr[] = {"\n\n\n\n\n\n\n\n\n\n\n\n\n",
				"        "+설정.back_black+설정.purple+"|  |  |  "+설정.back_red+설정.black+"|  |"+설정.exit+"       ",
				"       "+설정.back_black+설정.purple+"||  | | | |  "+설정.back_red+설정.black+"||"+설정.exit+"      ",
				"      "+설정.back_black+설정.purple+"| |  || "+설정.red+"O"+설정.purple+" ||  | "+설정.back_red+설정.black+"|"+설정.exit+"     ",
				"     "+설정.back_black+설정.purple+"|  |  |  "+설정.red+"O"+설정.purple+"  |  |  |"+설정.exit+"    ",
				"    "+설정.back_red+"||"+설정.back_black+설정.purple+"  | |       | |  ||"+설정.exit+"   ",
				"   "+설정.back_red+"| |  ||"+설정.back_black+설정.purple+" "+설정.red+"▃▂▁▁▂▃"+설정.purple+" ||  | |"+설정.exit+"  ",
				"  "+설정.back_red+"|  |  |   "+설정.back_black+설정.purple+"        |  |  |"+설정.exit+" ",
				"┌──────────────────────────┐",
				"│        완벽한 복수를!        │",
				"└──────────────────────────┘",
				" 1.잡아먹기  2.받아들이기  3.공격  ",
				};
		for(String i:arr) {
			System.out.println(i);
		}
	}

	public static void 단서() {
		String arr[] = {"\n\n\n\n\n\n\n\n\n\n\n\n\n",
				"        "+설정.BLUE_BACKGROUND_BRIGHT+"|  |  |  |  |"+설정.exit+"       ",
				"       "+설정.RED_BACKGROUND_BRIGHT+설정.white+"||  | | | |  ||"+설정.exit+"      ",
				"      "+설정.BLUE_BACKGROUND_BRIGHT+"| |  || O ||  | |"+설정.exit+"     ",
				"     "+설정.RED_BACKGROUND_BRIGHT+설정.white+"|  |  |  O  |  |  |"+설정.exit+"    ",
				"    "+설정.BLUE_BACKGROUND_BRIGHT+"||  | |       | |  ||"+설정.exit+"   ",
				"   "+설정.RED_BACKGROUND_BRIGHT+설정.white+"| |  || ▃▂▁▁▂▃ ||  | |"+설정.exit+"  ",
				"  "+설정.BLUE_BACKGROUND_BRIGHT+"|  |  |           |  |  |"+설정.exit+" ",
				"┌───────────────────────────┐",
				"│   "+설정.blue+"당신에게 "+설정.red+"알려줄 "+설정.blue+"것은 "+설정.red+"없네요."+설정.exit+"    │",
				"└───────────────────────────┘",
				"  1.잡아먹기  2.받아들이기  3.공격  ",
				};
		for(String i:arr) {
			System.out.println(i);
		}
	}

	public static void 열쇠() {
		String arr[] = {"\n\n\n\n\n\n\n\n\n\n\n\n\n",
				"        "+설정.YELLOW_BACKGROUND_BRIGHT+설정.CYAN_BOLD_BRIGHT+"|  |  |  |  |"+설정.exit+"       ",
				"       "+설정.YELLOW_BACKGROUND_BRIGHT+설정.CYAN_BOLD_BRIGHT+"||  | | | |  ||"+설정.exit+"      ",
				"      "+설정.YELLOW_BACKGROUND_BRIGHT+설정.CYAN_BOLD_BRIGHT+"| |  || O ||  | |"+설정.exit+"     ",
				"     "+설정.YELLOW_BACKGROUND_BRIGHT+설정.CYAN_BOLD_BRIGHT+"|  |  |O O O|  |  |"+설정.exit+"    ",
				"    "+설정.YELLOW_BACKGROUND_BRIGHT+설정.CYAN_BOLD_BRIGHT+"||  | |   O   | |  ||"+설정.exit+"   ",
				"   "+설정.YELLOW_BACKGROUND_BRIGHT+설정.CYAN_BOLD_BRIGHT+"| |  ||  <___>  ||  | |"+설정.exit+"  ",
				"  "+설정.YELLOW_BACKGROUND_BRIGHT+설정.CYAN_BOLD_BRIGHT+"|  |  |           |  |  |"+설정.exit+" ",
				"┌────────────────────────────┐",
				"│      최후를 알고 싶은 사람       │",
				"└────────────────────────────┘",
				"  1.잡아먹기  2.받아들이기  3.공격  ",
				};
		for(String i:arr) {
			System.out.println(i);
		}
	}

	public static void 잡화상대화(용사 user, int w) {
		if(w == 1 && user.getStat().getQuest().equals("타락의 길")) {
			System.out.println(설정.red+"데스필교의 증오의 신 후보자님이셨군뇽..");
			설정.sleep(1500);
			System.out.println("처음뵙겠습니다. 저는 대외적으론 잡화상인으로 알려져있지만 사실 데스필교의 타락의 하수인 에빌린입니다.");
			설정.sleep(1500);
			System.out.println("증오의 신 후보자께선 정말 대단한 능력을 가지고 계시군요..");
			설정.sleep(1500);
			System.out.println("크흠.. 아무튼 저를 찾으셨으니 타락의 길은 통과입니다."+설정.exit);
			설정.sleep(1500);
			System.out.println(설정.purple+"엥 이렇게 쉽게?"+설정.exit);
			설정.sleep(1500);
			System.out.println(설정.red+"뇽뇽뇽.. 저는 강한자만 받거든요.."+설정.exit);
			설정.sleep(1500);
		}else if(w == 1){
			System.out.println("데스필교...? 너 그런거 믿는거냐옹?");
			설정.sleep(1500);
			System.out.println("거긴 무서운 곳이다옹...");
			설정.sleep(1500);
			System.out.println("소문에 의하면, 거기 신도들은 무시무시한 짓도 아무렇지도 않게 한다는데..뇽덜덜..");
			설정.sleep(1500);
			System.out.println("ㅅ..설마 ㄴ너도 그런거냐옹!!!! 캬아악!!");
			설정.sleep(1500);
			System.out.println("(당신은 절대 아니라고 했다.)");
			설정.sleep(1500);
			System.out.println("뭐냥... 장난이라도 그쪽 얘기는 하지말라옹");
			설정.sleep(1500);
		}else if(w == 2) {
			System.out.println("뭐.. 고양이가 잡화점 운영하면 안되는 법있냐옹?");
			설정.sleep(1500);
			System.out.println("심지어 모험가 길드놈들 접수원은 곰돌이 인형이라구옹!!");
			설정.sleep(1500);
			System.out.println("나는 적어도 무생물은 아니다옹 흥");
			설정.sleep(1500);
			System.out.println("(생각보다 쌓인게 많아 보인다...)");
			설정.sleep(1500);
		}else if(w==3) {
			System.out.println("내가 좀 한 귀여움하지 뇽뇽뇽~^-^");
			설정.sleep(1500);
			System.out.println("좋아 너는 나를 쓰다듬어도 된다옹!");
			설정.sleep(1500);
			System.out.println("(당신은 잡화상인을 쓰다듬었다.)");
			설정.sleep(1500);
			System.out.println("(보들보들하다. 너무 귀엽다..)");
			설정.sleep(1500);
			System.out.println("(잡화상인이 그릉그릉거린다..)");
			설정.sleep(1500);
		}
	}
}
