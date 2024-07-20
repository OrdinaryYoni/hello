import requests

headers = {'User-Agent':'Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko'}

url = 'http://www.todayhumor.co.kr/board/list.php?table=bestofbest'
site = requests.get(url, headers=headers)
source_data1 = site.text
source_data2 = site.text
source_data3 = site.text

count = source_data1.count('<td class="subject"><a ')

for i in range(count):
    pos1 = source_data1.find('<td class="subject"><a ') + len('<td class="subject"><a ')
    source_data1 = source_data1[pos1:]

    pos2 = source_data1.find('" target="')
    extract_data = source_data1[:pos2]

    source_data1 = source_data1[pos2+1:]
    print(i+1,'링크:',extract_data)

    pos_1 = source_data2.find('<td class="subject"><a ') + len('<td class="subject"><a ')
    source_data2 = source_data2[pos_1:]

    pos_2 = source_data2.find('"_top">') + len('"_top">')
    source_data2 = source_data2[pos_2:]

    pos_3 = source_data2.find('</a>')
    extract_data2 = source_data2[:pos_3]

    source_data2 = source_data2[pos_3+1:]
    print('  제목:',extract_data2)

    '''pos3 = source_data3 = source_data3.find("'<img src='") + len("'<img src='")
    source_data3 = source_data3[pos3:]

    pos4 = source_data3 = source_data3.find("' style=")
    extract_data3 = source_data3[:pos4]

    source_data3 = source_data3[pos4+1:]
    print('사진:',extract_data3)
'''
    
    
    
