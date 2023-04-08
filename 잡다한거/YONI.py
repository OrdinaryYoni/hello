log = {}
while(True):  
    print("############################YONI GAME##############################")
    print("로그인 하시겠습니까? [예/아니요]")
    print("**아직 회원가입을 안하셨다면 [ 회 ] 라고 써주십시오.**")
    yn = input()

    if yn == '회':
        print("새로 만들 ID를 입력해주세요. :", end = "")
        NID = input()
        print("비밀번호를 설정해주세요. :", end = "")
        Npw = input()
        print("회원가입이 완료되었습니다.")
        log[NID] = Npw
    elif yn == '예':
        print("ID를 입력해주세요. :", end = "")
        ID = input()
        print("비밀번호를 입력해주세요. :", end = "")
        PW = input()
        if ID in log.keys():
            if PW == log[ID]:
                print("로그인 성공!!")
                print("[{0}]".format(ID))
                print("(>-<)")
                print(" --|--/")
                print("   ^   ")
                break
        else:
            print("아이디나 비밀번호가 잘못되었습니다. 다시 입력해주십시오.")
    elif yn == '아니요':
        print("종료.")
        break
        
              
