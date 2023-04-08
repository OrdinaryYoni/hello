from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
import time
name = []
answer = []
comment = {}
b=[]
chrome_options = webdriver.ChromeOptions()
driver = webdriver.Chrome(service=Service(
    ChromeDriverManager().install()),
    options=chrome_options)

url ='https://www.youtube.com/watch?v=P51SrprUFBY'
driver.get(url)
driver.maximize_window()
driver.implicitly_wait(3)
for i in range(3):
    driver.find_element(By.TAG_NAME,'body').send_keys(Keys.PAGE_DOWN)
    time.sleep(1)
driver.implicitly_wait(3)
e = driver.find_elements(By.CLASS_NAME, 'style-scope ytd-comment-renderer')

for i in e:
    a=i.text
    if a=='':
        continue
    b=a.split('\n')
    if b == None:
        continue
    comment[b[0]] = b[2]

for j in comment.items():
    print(j[0]+' : '+j[1])
