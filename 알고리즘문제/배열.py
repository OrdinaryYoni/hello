n = int(input())
m = 0
arr = [[0 for j in range(n)] for i in range(n)]
for i in range(n):
    for j in range(n):
        m+=1
        arr[i][j] = m
for i in range(n):
    for j in range(n):
        print(arr[i][j], end=' ')
    print()






