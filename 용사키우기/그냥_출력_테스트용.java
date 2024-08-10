package 용사키우기;

public class 그냥_출력_테스트용 {
//"+설정.blue+" "+설정.exit+"
	public static void main(String[] args) {
		용사 user = new 용사();
		int num = 4;
		String arr[] = {"\n\n\n\n\n\n\n\n\n\n\n\n",
				String.format("이름: %s lv: %d 성별: %s", user.getStat().getName(), 
						user.getStat().getLevel(),user.getStat().getGender()),
				"━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━",
				String.format("직업: %s \n호칭: %s", user.getStat().getJob(), 
						user.getStat().getTitle()),
				String.format("보유 스킬: %s \n진행중인 퀘스트: %s", user.getStat().getSkill(), 
						user.getStat().getQuest()),
				String.format("공격력: %d+%d \n방어력: %d \nmp: %d/%d", user.getStat().getAtk(),
						user.getStat().getWeaponAtk(), user.getStat().getDef(),
						user.getStat().getMp(),user.getStat().getMaxMp()),
				String.format("현재 체력: %d/%d \n현재 무기: %s", user.getStat().getHp(), 
						user.getStat().getMaxHp(),user.getStat().getCurrentWeapon()),
				"\n스킬과 직업 설명은 마을 도섣관으로..."
				};
		for(String i:arr) {
			System.out.println(i);
		}//║▌│█║▌│ █║▌│█│║▌║ ૮(   •ﻌ• )ა 🔨       ☆⠀ ╲⠀⠀ ⊹   ⠀.   ☆.  /\_/\    ♡Δ~~~Δ▲ ◥▦◣
	}

}
/*
＼●　 ●＿　　＼●　 　＜●〉　* ● *
 />　 <│　　 /∨　　　│ 　* √|∨*
<＼　　∠＼　　/>　　　 〈〉　* /\*
~ 앗싸~ 오늘도 활기차게 발랄하게~ 오예~~!!! ^^*/
