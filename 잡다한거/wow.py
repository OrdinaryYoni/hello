song='''동해물과 백두산이 마르고 닳도록
하느님이 보우하사 우리나라 만세
무궁화 삼천세
대한사람 대한으로 길이 보전하세'''
 
print(song[0:4])
print(song[5:9])
print(song[10:13])
print(song[14:17])
print(song[18:22])
print(song[23:27])
print(song[28:32])
print(song[33:35])
print(song[36:39])
print(song[40:43])
print(song[44:48])
print(song[49:53])
print(song[54:58])
print(song[59:61])
print(song[62:66])

a= song.find('세')

song = song[a+1:]

a= song.find('세')
print(song[a-1 : a+1])
#print(song[a-1 : a+1])
#print(song[b-1:b+1])
#print(song.split('세'))
