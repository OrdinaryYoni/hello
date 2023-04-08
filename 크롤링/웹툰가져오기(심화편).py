import requests
import urllib
def DataForward(source, word):
    pos1 = source.find(word) + len(word)
    source = source[pos1:]
    return source
def DataBackward(source, word):
    pos2 = source.find(word)
    extract_data = source[:pos2]
    return extract_data
def DataExtract1(source, word1, word2,word3):
    source = DataForward(source,word1)
    source = DataForward(source,word3)
    extract = 'https://comic.naver.com'+DataBackward(source,word2)
    source = DataForward(source, word2)
    return source, extract
def DataExtract2(source, word1, word2, word3):
    source = DataForward(source, word1)
    source = DataForward(source, word3)
    extract = DataBackward(source, word2)
    source = DataForward(source, word2)
    return source, extract
def ChangeUrl(link):
    headers = {'User-Agent':'Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko'}

    url = link
    site = requests.get(url, headers=headers)
    source_data = site.text
    return source_data
def DownloadPicture(filename):
    headers = {'User-Agent':'Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko'}
    ss= requests.get(extract_data2,headers = headers)
    file = open(filename, 'wb')
    file.write(ss.content)
    file.close()

print('링크:',end='')
link = input()
'''print('코드(앞):',end='')
word1 = input()
print('코드(뒤):',end = '')
word2 = input()
print('추가코드:',end='')
word3 = input()#image-comic.pstatic
print('코드2(앞):',end='')
word_1 = input()
print('코드2(뒤):',end='')
word_2 = input()
print('추가코드2:',end='')
word_3 = input()'''
#링크
source_data = ChangeUrl(link)
count = source_data.count('<td class="title">')
for i in range(count):
    source_data, extract_data = DataExtract1(source_data, '<td class="title">', '" o','<a href="')
#사진
    source_data2 = ChangeUrl(extract_data)
    for j in range(source_data2.count('<img src="https://image-comic.pstatic')):
        source_data2, extract_data2 = DataExtract2(source_data2, '<div class="wt_viewer" style="background:#FFFFFF">', '"', '<img src="')
        print(j+1, extract_data2)
        try:
            filename = './img/{0}{1}-{2}.jpg'.format('숲속의 담', i+1, j+1)
            DownloadPicture(i,j)
        except Exception as e:
            print('에러발생',e)

