from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
import time
name = []
answer = []
link = []
chrome_options = webdriver.ChromeOptions()
driver = webdriver.Chrome(service=Service(
    ChromeDriverManager().install()),
    options=chrome_options)

url ='https://www.youtube.com/@MOMOISDOG/videos'
driver.get(url)
driver.implicitly_wait(3)

#스크롤 내리기
for i in range(10):
    driver.find_element(By.TAG_NAME,'body').send_keys(Keys.PAGE_DOWN)
    time.sleep(1)
    
videos = driver.find_elements(By.CLASS_NAME, 'yt-simple-endpoint.inline-block.style-scope.ytd-thumbnail')

#링크가져오기    
for v in videos[1:]:
    try:
        link.append(v.get_attribute('href'))
        time.sleep(0.5)
    except:
        pass
    
#댓글 가져오기
for j in link:
    driver.get(j)
    driver.implicitly_wait(3)

    for i in range(10):
        driver.find_element(By.TAG_NAME,'body').send_keys(Keys.PAGE_DOWN)
        time.sleep(1)

    driver.implicitly_wait(3)
    e = driver.find_elements(By.CLASS_NAME, 'style-scope.ytd-comment-renderer')

    for i in e:
        driver.implicitly_wait(3)
        a=i.text
        b = a.split('/n')
        name.append(b[0])
        answer.append(b[2])
    for k in answer:
        print(k)
