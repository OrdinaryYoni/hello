a,b = input().split()
c = ord(a)+int(b)
while c > 122: c -= 25
print(chr(c))
