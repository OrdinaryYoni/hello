package 용사키우기;

public class 그냥_출력_테스트용 {

	public static void main(String[] args) {
		int num = 4;
		String items[] = {"🔨","🧹","🌌","🪓","⚔️"};
		String arr[] = {"\n\n\n\n\n\n\n\n\n\n\n\n",
				"      ●                ●        ",
				String.format("   %s███🛡️            \\/|\\     ",items[num]),
				"      █               / \\      ",
				"┌───────────────────────────┐",
				"│당신은 무엇을 할건가?            │",
				"└───────────────────────────┘",
				"   1.공격    2.회복    3.행동 "
				};
		for(String i:arr) {
			System.out.println(i);
		}//║▌│█║▌│ █║▌│█│║▌║ ૮( • ﻌ • )ა 🔨       ☆⠀ ╲⠀⠀ ⊹   ⠀.   ☆.  /\_/\    ♡Δ~~~Δ▲
	}

}
