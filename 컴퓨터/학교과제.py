s = input() 
a = '' 
cnt = 0 

for i in s:
    if a == '':
        a = i
        cnt += 1 
    else:
        if a == i:
            cnt += 1
        else:
            if cnt == 1:
                print(a, end='')
            else:
                print(str(cnt)+a, end='')
            a = i
            cnt = 0
            cnt += 1
if cnt == 1:
    print(a)
else:
    print(str(cnt)+a) 
