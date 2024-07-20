for j in range(0,5,1):

    for k in range(1,4,1):
        
        import requests

        headers = {'User-Agent':'Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko'}

        url = 'https://news.naver.com/main/list.naver?mode=LS2D&mid=shm&sid2=731&sid1=105&date={0}&page={1}'.format(20220808+j, k)

        site = requests.get(url, headers = headers)
        source_data = site.text

        count = source_data.count('<dt>')

        for i in range(count):
            pos1 = source_data.find('<dt>') + len('<dt>')
            source_data = source_data[pos1:]

            pos2 = source_data.find('">') + len('">')
            source_data = source_data[pos2:]

            pos3 = source_data.find('</a>')
            extract_data = source_data[:pos3]

            source_data = source_data[pos3+1:]
            print(i+1,extract_data.strip())

