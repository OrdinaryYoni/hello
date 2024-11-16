package 용사키우기;

public class 데스필교 {
	NPC[] npcs = new NPC[5];
	int [] cnt = {0,0,0,0,0};
	public 데스필교() {
		npcs[0] = new NPC("스레타하", 1, 1, 1, 1, 1);//절망의 하수인
		npcs[1] = new NPC("에빌린", 1, 1, 1, 1, 1);//타락의 하수인
		npcs[2] = new NPC("베티", 1, 1, 1, 1, 1);//탐욕의 하수인
		npcs[3] = new NPC("슬립투벳", 1, 1, 1, 1, 1);//죽음의 하수인
		npcs[4] = new NPC("언홀리", 1, 1, 1, 1, 1);//증오의 하수인
	}
	public void 절망의길(용사 user) {
		화면.데스필교행동창(user,0);
		user.getStat().setCompleteQuest(user.getStat().getCompleteQuest()+"절망의 길 ");
		user.getStat().setQuest("타락의 길");
	}
	public void 타락의길(용사 user) {
		if(user.getStat().getCompleteQuest().indexOf("타락의 길") != -1) {
			System.out.println(설정.red+"오 우리 타락의 하수인님을 찾으셨나보네요!");
			설정.sleep(1500);
			System.out.println("아! 증표없이 알 수 있습니다. 우리 타락의 하수인님께선 독특한 냄새가 나시거든요~");
			설정.sleep(1500);
			System.out.println("다음 길로 가시죠"+설정.exit);
			설정.sleep(1500);
			user.getStat().setQuest("탐욕의 길");
		}else {
			화면.데스필교행동창(user,1);
		}
	}
	public void 탐욕의길(용사 user) {
		if(user.getStat().getCompleteQuest().indexOf("탐욕의 길") != -1) {
			System.out.println(설정.back_black+설정.back_yellow+"휴~ 드디어 냄새가 좋아졌네^^ (그 대리인 자식.. 아무한테나 냄새 뭍히지 말라니까...)");
			설정.sleep(1500);
			System.out.println("음 이제 가~ 너 해야할 일이 있잖아"+설정.exit);
			설정.sleep(1500);
			user.getStat().setQuest("죽음의 길");
		}else {
			화면.데스필교행동창(user,2);
		}
	}
	public void 죽음의길(용사 user) {
		if(user.getStat().getCompleteQuest().indexOf("죽음의 길") != -1) {
			System.out.println(설정.green+"흠흠흠~ 이제 생명을 키울 ㅅ...ㅇ..아니, 죽음의 힘을 드리겠습니다.");
			설정.sleep(1500);
			user.getStat().setBag(user.getStat().getBag().replace("생명의 돌 ", ""));
			System.out.println("이제 마지막 길만 남았군요. 열심히 하십시요."+설정.exit);
			설정.sleep(1500);
			user.getStat().setQuest("증오의 길");
		}else {
			화면.데스필교행동창(user,3);
		}
	}
	public void 증오의길(용사 user) {
		if(user.getStat().getCompleteQuest().indexOf("증오의 길") != -1) {
			System.out.println(설정.back_black+설정.purple+"ㅈ...진짜로 성공할 줄은 몰랐는데...");
			설정.sleep(2000);
			System.out.println("아무래도 진짜 증오의 신인가보네...");
			설정.sleep(2000);
			System.out.println("나 데스필교 대교주 언홀리는 오늘부로 증오의 신께 이 힘을 바치고,");
			설정.sleep(2000);
			System.out.println("증오의 화신으로써의 역할을 마침을 선포합니다."+설정.exit);
			설정.sleep(2000);
			System.out.println(설정.purple+"자 증오의 신님.. 이 힘을 받으십시요...");
			설정.sleep(2000);
			user.getStat().setSkill("에스토니아의 비명");
			System.out.println(설정.back_black+"참으로 강력한 힘이다...");
			설정.sleep(2000);
			System.out.println("뭔가... 다 없애버리고 싶다... "+설정.exit);
			설정.sleep(2000);
			
			user.getStat().setCompleteQuest(user.getStat().getCompleteQuest()+"증오가 날 감싸네 ");
			user.getStat().setQuest("엄숨");
		}else {
			화면.데스필교행동창(user,4);
		}
	}
}
