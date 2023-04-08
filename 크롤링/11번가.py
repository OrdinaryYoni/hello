import requests
import urllib

headers = {'User-Agent':'Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Geoko'}

url = 'https://www.11st.co.kr/browsing/BestSeller.tmall?method=getBestSellerMain&xfrom=main^gnb'
site = requests.get(url, headers = headers)
source_data = site.text
source_data2 = site.text
source_data3 = site.text
count = source_data.count('<li id="thisClick')

for i in range(count):
    #이름
    pos1 = source_data.find('<li id="thisClick') + len('<li id="thisClick')
    source_data = source_data[pos1:]

    pos2 = source_data.find('<p>') + len('<p>')
    source_data = source_data[pos2:]

    pos3 = source_data.find('</p>')
    extract_data = source_data[:pos3]

    source_data = source_data[pos3+1:]
    print(i+1,extract_data.strip())
    #사진
    pos_1 = source_data2.find('') + len('<li id="thisClick')
    source_data2 = source_data2[pos_1:]

    pos_2 = source_data2.find('<img src="') + len('<img src="')
    source_data2 = source_data2[pos_2:]

    pos_3 = source_data2.find('"')
    extract_data2 = source_data2[:pos_3]

    source_data = source_data[pos_3+1:]
    print('사진:',extract_data2)

    posi1 = source_data3.find('<li id="thisClick') + len('<li id="thisClick')
    source_data3 = source_data3[posi1:]

    posi2 = source_data3.find('<strong class="sale_price">') + len('<strong class="sale_price">')
    source_data3 = source_data3[posi2:]

    posi3 = source_data3.find('\n')
    extract_data3 = source_data3[:posi3]
    extract_data3 = extract_data3.strip()
    extract_data3 = extract_data3.replace('</strong>','')

    source_data3 = source_data3[posi3+1:]
    print(extract_data3)

    try:
        
        filename = '{0}-{1}.jpg'.format(extract_data.strip(), extract_data3)
        ss = requests.get(extract_data2, headers=headers)
        file = open(filename,'wb')
        file.write(ss.content)
        file.close()

    except Exception as e:
        print('에러발생', e)
