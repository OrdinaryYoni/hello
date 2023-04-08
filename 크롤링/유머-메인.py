import requests

headers = {'User-Agent':'Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko'}

url = 'http://www.todayhumor.co.kr/board/list.php?table=bestofbest'
site = requests.get(url, headers = headers)
source_data = site.text
source_data2 = site.text
source_data3 = site.text

count = source_data.count('<td class="subject">')

for i in range(count):

    pos1 = source_data.find('<td class="subject">') + len('<td class="subject">')
    source_data = source_data[pos1:]

    pos2 = source_data.find('target="_top">') + len('target="_top">')
    source_data = source_data[pos2:]

    pos3 = source_data.find('</a>')
    extract_data = source_data[:pos3]

    source_data = source_data[pos3+1:]
    print(i+1, extract_data.replace('&quot;',''))

#////////////////////////////////////////////////////////////////////////////

    posa = source_data2.find('<td class="subject">') + len('<td class="subject">')
    source_data2 = source_data2[posa:]

    posb = source_data2.find('<a href="') + len('<a href="')
    source_data2 = source_data2[posb:]

    posc = source_data2.find('" target')
    extract_data2 = source_data2[:posc]

    source_data2 = source_data2[posc+1:]

    extract_data2 = 'http://www.todayhumor.co.kr{0}'.format(extract_data2)
    print('링크: ', extract_data2)

#////////////////////////////////////////////////////////////////////////////
    
    '''pos_1 = source_data3.find("<span style='margin-left:4px;'>") + len("<span style='margin-left:4px;'>")
    source_data3 = source_data3[pos_1:]

    pos_2 = source_data3.find("<img src='") + len("<img src='")
    source_data3 = source_data3[pos_2:]

    pos_3 = source_data3.find("' style='")
    extract_data3 = source_data3[:pos_3]

    source_data3 = source_data3[pos_3+1:]
    print('사진:', extract_data3)
'''





















