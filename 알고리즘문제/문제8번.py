n = int(input())

li = []
for i in range(n):
    m = int(input())

    li.append(m)

for i in range(n-1):
    print(li[i], end='♥')
print(li[-1])


'''for i in li[:-1]:
    print(i, end='♥')

print(li[-1])'''
