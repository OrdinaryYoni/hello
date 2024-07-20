package 용사키우기;

public class 화면 {
	public static void 메인(용사 user) {
		String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n", String.format("%s", user.getStat().getPlace()),
				"           ●        ", "         \\/|\\     ", "          / \\      ",
				String.format(" %s lv:%d hp:%d exp:%d/%d", user.getStat().getName(), user.getStat().getLevel(),
						user.getStat().getHp(), user.getStat().getExp(), user.getStat().getMaxExp()),
				"┌─────────────────────┐", "│당신은 무엇을 할건가?      │", "└─────────────────────┘", "  1.이동  2.가방  3.행동 " };
		for (String i : arr) {
			System.out.println(i);
		}
	}

	public static void 이동창(int lv) {
		if (lv == 100) {
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

	public static void 가방창() {
		String items[] = { "︻[]▄▅▆▇◤", "▬▬ι═══════ﺤ", "▄█▀█●", "●▅▇█▇▆▅▄▇", "🔪", "🗡️", "" };
		System.out.println(items[0]);
	}

	public static void 행동창() {
		System.out.println("1.사냥 2.채집 3.대화");
	}

	public static void 장소(int w) {

	}

	public static void 인트로(String gender) {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
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

	}

	public static void 엔딩2() {

	}

	public static void 엔딩3() {

	}

	public static void 엔딩4() {

	}

	public static void 흐접엔딩() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
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
		String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n", "   ending 89. 허접.       ", "    ᘛ⁐̤ᕐᐷ                 ",
				"               ᑄᒾ⁐̤೨     ", "ᘛ⁐̤ᕐᐷ   ●▅▇█▇▆▅▄▇   ᑄᒾ⁐̤೨", "     ᘛ⁐̤ᕐᐷ                ", };
		for (String i : arr) {
			System.out.println(i);
		}
	}

	public static void 공격창(String mop_name, int mop_hp, int mop_lv, 용사 user) {
		String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n", String.format("%s lv:%d hp:%d", mop_name, mop_lv, mop_hp),
				"                        ●        ", "      ██              \\/|\\     ",
				"      ██               / \\      ",
				String.format(" %s lv:%d hp:%d mp:%d exp:%d/%d", user.getStat().getName(), user.getStat().getLevel(),
						user.getStat().getHp(), user.getStat().getMp(), user.getStat().getExp(), user.getStat().getMaxExp()),
				"┌───────────────────────────┐", "│당신은 무엇을 할건가?            │", "└───────────────────────────┘",
				"   1.공격    2.회복    3.행동 " };
		for (String i : arr) {
			System.out.println(i);
		}
	}

	public static void 처치창(String mop_name, int mop_exp, 용사 user) {
		String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n", String.format("%s를(을) 물리쳤다! 경험치 %d를 획득했다.", mop_name, mop_exp),
				"                        ●        ", "      ██              \\/|\\     ",
				"      ██               / \\      ",
				String.format(" %s lv:%d hp:%d exp:%d/%d", user.getStat().getName(), user.getStat().getLevel(),
						user.getStat().getHp(), user.getStat().getExp(), user.getStat().getMaxExp()),
				"┌───────────────────────────┐", "│당신은 무엇을 할건가?            │", "└───────────────────────────┘",
				"   1.공격    2.회복    3.행동 " };
		for (String i : arr) {
			System.out.println(i);
		}
		설정.sleep(1000);
	}

	public static void 게임오버창() {
		String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n", "▀ █ ▀ █ ▀ ▀ █ ▀ █ ▀ █", "   ───────────────   ",
				"  G a m e   o v e r  ", "   ───────────────   ", "        ▄█▀█●        ", "                     ",
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
		String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n", "   |    |       5       |    |   ",
				"   | 1 /                 \\ 3 |   ", "   |  /                   \\  |   ",
				" 2 | /          ●          \\ | 4 ", "   |/         \\/|\\          \\|  ",
				"   /           / \\           \\  ",
				String.format(" %s lv:%d hp:%d exp:%d/%d", user.getStat().getName(), user.getStat().getLevel(),
						user.getStat().getHp(), user.getStat().getExp(), user.getStat().getMaxExp()),
				"┌───────────────────────────────────┐", "│당신은 어디로 갈건가?                    │",
				"└───────────────────────────────────┘", "1.대장간 2.잡화점 3.골목길 4.모험가 길드 5.왕궁" };
		for (String i : arr) {
			System.out.println(i);
		}
	}

	public static void 대장간(용사 user, int w) {
		if (w == 1) {
			String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n", "        |          |   ||",
					"        |" + 설정.yellow + "대장장이" + 설정.exit + "____┌────┐|       ",
					"       /   ●     |" + 설정.back_yellow + "┌───┐" + 설정.exit + " |\\       ",
					"      /" + 설정.red + "⊹_" + 설정.exit + "🔨૮█    |" + 설정.back_yellow + "|_" + 설정.red + 설정.back_yellow
							+ "🔥" + 설정.exit + 설정.back_yellow + "_|" + 설정.exit + "__|\\      ",
					"     /  ▀       ●          \\     ", "    /         \\/|\\          \\   ",
					"   /           / \\           \\  ", "┌───────────────────────────────┐",
					"│당신은 무엇을 할건가?                │", "└───────────────────────────────┘",
					"   1.구매   2.강화   3.대화   4.공격 " };
			for (String i : arr) {
				System.out.println(i);
			}
		} else if (w == 2) {
			String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n", "여기 좋은 물건들이 들어왔다네             ",
					"=================================", " 1.📏   2.🏹   3.🔧   4.⛏️   5.🪓 ",
					"=================================", " 6.🔨   7.🔪   8.🗡️   9.⚔️   10.🧱",
					"=================================", "          11.▬▬ι═══════ﺤ         ",
					"          12.︻[]▄▅▆▇◤           ", "=================================" };
			for (String i : arr) {
				System.out.println(i);
			}
		} else if (w == 3) {
			System.out.println("미안하네... 난 이제 무기 강화에는 손을 땠어..");
			설정.sleep(1000);
		} else if (w == 4) {
			if (user.getStat().getLevel() < 30) {
				System.out.println("나랑 대화를 하고싶다고? 허! 애송이는 가라");
				설정.sleep(1000);
			} else {
				String arr[] = { "(흠... 애송이는 아니구먼..)",
						"사실 난 에스토니아에서 살았던 사람인데.. 자네도 알다시피 요즘 우리 국왕께선 남겨진 에스토니아인들을 잡아가고 있어.",
						"아무튼 그 에스토니아인들이 어디로 가는지 아는가?", "왕립 마법사의 재료로 쓰인다지..!", "충격적이지? 근데.. 어제 내 아내가 그곳으로 끌려간 것 같아...",
						"어제 집에 들어가니까 집안이 난장판이고 아내가 없어졌더라고...", "젠장! 잘 숨겼었는데..!!",
						"그래서 말이야 네가 내 아내를 찾아줬으면 해. 할 수 있지?? 제발 내 아내를 구해줘..." };
				for (String i : arr) {
					System.out.println(i);
					설정.sleep(1000);
				}
			}
		} else {
			System.out.println("오케이 나랑 싸우고 싶다는 거지?");
			설정.sleep(1000);
		}
	}

	public static void 잡화점(용사 user) {

	}

	public static void 골목길(용사 user, int w) {
		if (w == 1) {
			String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n",
					"    " + 설정.BLACK_BOLD_BRIGHT + "스레타하" + 설정.exit + "       |        ", "      ● /        \\      ",
					"     <█          \\     ", "      |>           \\    ", "    /       ●       \\   ",
					"   /      \\/|\\       \\  ", "┌───────────────────────┐", "│당신은 무엇을 할건가?        │",
					"└───────────────────────┘", " 1.대화   2.그냥가기   3.공격 " };
			for (String i : arr) {
				System.out.println(i);
			}
		} else if (w == 2) {
			String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n",
					"         " + 설정.back_black + "       " + 설정.exit + "         ",
					"        " + 설정.back_black + "         " + 설정.exit + "        ",
					"        " + 설정.back_black + " " + 설정.BLACK_BACKGROUND_BRIGHT + "       " + 설정.back_black + " "
							+ 설정.exit + "        ",
					"        " + 설정.back_black + "   " + 설정.BLACK_BACKGROUND_BRIGHT + "   " + 설정.back_black + "   "
							+ 설정.exit + "          ",
					"       " + 설정.back_black + "           " + 설정.exit + "       ",
					"     " + 설정.back_black + "               " + 설정.exit + "     ",
					설정.back_black + 설정.purple + "┌───────────────────────┐" + 설정.exit,
					설정.back_black + 설정.purple + "│호호호.. 당신, 절망에 빠졌군요.│" + 설정.exit,
					설정.back_black + 설정.purple + "└───────────────────────┘" + 설정.exit, " 1.?뭔솔   2.(무시)   3.네. " };
			for (String i : arr) {
				System.out.println(i);
			}
			설정.sleep(1000);
		} else if (w == 3) {
			System.out.println("호호호.. 잘가요, 절망이시여..");
			설정.sleep(1000);
		} else {
			System.out.println("호호.. " + user.getStat().getName() + ".. 나를 죽이면 후회할 것이다...");
			설정.sleep(1000);
		}
	}

	public static void 모험가길드(용사 user, int w) {
		if (w == 1) {
			String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n", "        |               |        ",
					"        |========" + 설정.yellow + "릴리아" + 설정.exit + "===|        ",
					"       /           ●     \\       ", "      /   ________/█\\_____\\      ",
					"     /    |     ●          \\     ", "    /         \\/|\\          \\   ",
					"   /           / \\           \\  ", "┌───────────────────────────────────┐",
					"│당신은 무엇을 할건가?                    │", "└───────────────────────────────────┘",
					" 1.모험가 등록   2.퀘스트   3.판매   4.공격" };
			for (String i : arr) {
				System.out.println(i);
			}
		} else if (w == 2) {
			String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n", "          ⣠⠛⠛⣄⣠⠶⠛⠛⠛⠶⣄⣠⠛⠛⣄          ",
					"         ⢿  ⠋　　　　 　⠙ 　⡿         ", "           ⣾　 ●　ᴥ　●  ⣷           ",
					"            ⠻⣄　        　  ⣠⠟            ", "           ⣠⡿   🎀   ⢿⣄           ",
					"           ⠶ ⣠      ⣄ ⠶           ", "==================================",
					"║          ┌─────────┐    ▲      ║", "║          |모험가 등록증|    █      ║",
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
			String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n", "    /          /|         * *      ",
					"   /＼●        ( |＼●     * ● *     ", "     />        \\| /∨    * √|∨*    ",
					"    <＼          />      * /\\*    ",
					"    " + 설정.back_black + 설정.RED_BOLD_BRIGHT + "검사" + 설정.exit + "         " + 설정.back_black
							+ 설정.GREEN_BOLD_BRIGHT + "궁수" + 설정.exit + "       " + 설정.back_black + 설정.BLUE_BOLD_BRIGHT
							+ "마법사" + 설정.exit + "    ", };
			for (String i : arr) {
				System.out.println(i);
			}
		} else {
			System.out.println("오케이 나랑 싸우고 싶다는 거지?");
			설정.sleep(1000);
		}
	}

	public static void 왕궁(용사 user) {

	}

	public static void 채집창(용사 user) {

	}

	public static void NPC공격창(String npc_name, int npc_hp, int npc_lv, 용사 user, int num) {
		String items[] = { "🔨", "🧹", "🌌", "🪓", "⚔️" };
		String arr[] = { "\n\n\n\n\n\n\n\n\n\n\n\n", String.format("%s lv:%d hp:%d", npc_name, npc_lv, npc_hp),
				"      ●                ●        ", String.format("   %s███🛡️            \\/|\\     ", items[num]),
				"      █               / \\      ",
				String.format(" %s lv:%d hp:%d exp:%d/%d", user.getStat().getName(), user.getStat().getLevel(),
						user.getStat().getHp(), user.getStat().getExp(), user.getStat().getMaxExp()),
				"┌───────────────────────────┐", "│당신은 무엇을 할건가?            │", "└───────────────────────────┘",
				"   1.공격    2.회복    3.행동 " };
		for (String i : arr) {
			System.out.println(i);
		}
	}
}
