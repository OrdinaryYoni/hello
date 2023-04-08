n = int(input())
li1 = []
li2 = []
li3 = []
plus = []
for i in range(n):
    m = input() #90 80\70 70\95 75
    c = m.split(' ')
    p = int(c[0]) + int(c[1])
    li1.append(c[0]) # 90,70,95
    li2.append(c[1]) # 80,70,75
    li3.append(c)    # [90,80][70,70][95,75]
    plus.append(p)   # 170,140,170
su1 = 0
su2 = 0
for i in range(len(li1)):
    su1 = su1 + int(li1[i])
    su2 = su2 + int(li2[i])
su1 = int(su1/len(li1)) #평균
su2 = int(su2/len(li2)) #평균
lis = [su1,su2,0]
arr = []
for i in range(n):
    arr.append(li3[i])
    arr[i].append(plus[i])
arr.append(lis)
for i in range(n+1):
    for j in range(3):
        print(arr[i][j],end=' ')
    print(' ')


    
