n = input()
year = n[:2]
mon = n[2:4]
day = n[4:6]

if day > 31:
    print('생일을 정확히 입력해주세요.')

if mon <= 3:
    print('당신의 생일은 봄입니다.')
elif mon > 3 and mon <= 6:
    print('당신의 생일은 여름입니다.')
elif mon > 6 and mon <=9
