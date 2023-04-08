import requests
def DataForward(source, word):
    pos1 = source.find(word) + len(word)
    source = source[pos1:]
    return source
def DataBackward(source, word):
    pos2 = source.find(word)
    extract_data = source[:pos2]
    return extract_data
def DataExtract(source, word1, word2):
    source = DataForward(source, word1)
    extract = DataBackward(source, word2)
    source = DataForward(source, word2)
    return source, extract

headers = {'User-Agent':'Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko'}

url = 'https://news.naver.com/'
site = requests.get(url, headers=headers)
source_data = site.text

count = source_data.count('"cjs_t">')

for i in range(count):
    source_data, extract_data = DataExtract(source_data, '"cjs_t">', '</div>')
    #source_data = DataForward(source_data, '"cjs_t">')
    #extract_data = DataBackward(source_data,'</div>')
    #source_data = DataForward(source_data, '</div>')
    print(i+1,extract_data)
