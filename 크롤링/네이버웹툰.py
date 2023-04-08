import requests
import urllib
for j in range(0,22,1):
    
    headers = {'User-Agent':'Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko'}

    url = 'https://comic.naver.com/webtoon/list?titleId=685460&page={0}'.format(j+1)
    site = requests.get(url, headers = headers)
    source_data = site.text
    source_data2 = site.text

    count = source_data.count('<td class="title">')

    for i in range(count):
    #제목
        pos1 = source_data.find('<td class="title">') + len('<td class="title">')
        source_data = source_data[pos1:]

        pos2 = source_data.find('">') + len('">')
        source_data = source_data[pos2:]

        pos3 = source_data.find('</a>')
        extract_data = source_data[:pos3]

        source_data = source_data[pos3+1:]
        print(i+1, extract_data)


    #링크
        pos_1 = source_data2.find('<td class="title">') + len('<td class="title">')
        source_data2 = source_data2[pos_1:]

        pos_2 = source_data2.find('<a href="') + len('<a href="')
        source_data2 = source_data2[pos_2:]
    
        pos_3 = source_data2.find('" onclick=')
        extract_data2 = 'https://comic.naver.com'+source_data2[:pos_3]

        source_data2 = source_data2[pos_3+1:]
        print('링크:',extract_data2)

        #사진
        url = extract_data2
        site = requests.get(url, headers = headers)
        source_data3 = site.text
        
        for k in range(source_data3.count('image-comic.pstatic.net')):
                       
            posi1 = source_data3.find(' <div class="wt_viewer" style="background:#FFFFFF">') + len(' <div class="wt_viewer" style="background:#FFFFFF">')
            source_data3 = source_data3[posi1:]

            posi2 = source_data3.find('<img src="') + len('<img src="')
            source_data3 = source_data3[posi2:]

            posi3 = source_data3.find('"')
            extract_data3 = source_data3[:posi3]

            source_data3 = source_data3[posi3+1:]
            print('사진:',extract_data3)

            try:

                filename ='{0}{1}.jpg'.format(extract_data, k+1)
                ss = requests.get(extract_data3,  headers = headers)
                file = open(filename, 'wb')
                file.write(ss.content)
                file.close()

            except Exception as e:
                print('에러발생', e)
                
