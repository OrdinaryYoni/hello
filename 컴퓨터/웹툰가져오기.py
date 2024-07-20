import requests
import urllib

def ChangeUrl(link):
    headers = {'User-Agent':'Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko'}
    url = link
    site = requests.get(url, headers=headers)
    source_data = site.text
    return source_data
def DataMoveFoward(source, word):
    pos1 = source.find(word) + len(word)
    source = source[pos1:]
    return source
def DataMoveBackward(source,word):
    pos2 = source.find(word)
    source = source[:pos2]
    return source

print('링크:', end='')
link = input()
print('코드(앞):', end='')
word1 = input()
print('코드(뒤):', end='')
word2 = input()
source_data = ChangeUrl(link)
count = source_data.count(word1)
for i in range(count):
    source_data = DataMoveFoward(source_data, word1)
    extract_data = DataMoveBackward(source_data, word2)
    source_data = DataMoveFoward(source_data, word2)
    print(i+1, extract_data)
    
    try:
        
        filename = '{0}{1}.jpg'.format(extract_data, o+1)
        #urllib.request.urlretrieve(extract_data4, filename)
        ss = requests.get(extract_data4, headers=headers)
        file = open(filename, 'wb')
        file.write(ss.content)
        file.close()

        except Exception as e:
            print('에러발생', e)

    
