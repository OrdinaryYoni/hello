#pip install selenium webdriver_manager
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager

chrome_options = webdriver.ChromeOptions() #자동으로 다운받은 후 실행
driver = webdriver.Chrome(service=Service(
    ChromeDriverManager().install()),
    options=chrome_options)
ID = 'lgayeon07@naver.com'
PW = 'smflal3940'
#\지우고 한줄로 써도 사용가능
url = 'https://discord.com/login'
driver.get(url)           #해당 url로 접속
driver.implicitly_wait(3) #인터넷정보 다 다운받을때까지 대기(초)

e = driver.find_element(By.ID,'uid_8')
e.clear()
e.send_keys(ID)
e = driver.find_element(By.ID,'uid_11')
e.clear()
e.send_keys(PW)
e.send_keys(Keys.ENTER)
driver.implicitly_wait(3) #인터넷정보 다 다운받을때까지 대기(초)

driver.get('https://discord.com/channels/758909732697276457/983046700216221826')
webpage = driver.page_source

a = dirver.find_element(By.d
