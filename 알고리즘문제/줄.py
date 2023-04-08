n = int(input())
m = n // 5 + 1
Break = True
arr = [[' ' for j in range(5)]for i in range(m)]
a = 0
for i in range(m):
    for j in range(5):
        a += 1
        arr[i][j] = a
        if a == n:
            Break = False
            break
    if Break == False:
        break
for i in range(m):
    if i % 2 != 0:
        arr[i].reverse()
    for j in range(5):
        print(arr[i][j],end =' ')
    print(' ')
