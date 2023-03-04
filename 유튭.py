from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
import time
name = []
answer = []
chrome_options = webdriver.ChromeOptions()
driver = webdriver.Chrome(service=Service(
    ChromeDriverManager().install()),
    options=chrome_options)

url ='https://www.youtube.com/watch?v=P51SrprUFBY'
driver.get(url)
driver.maximize_window()
driver.implicitly_wait(3)
for i in range(10):
    driver.find_element(By.TAG_NAME,'body').send_keys(Keys.PAGE_DOWN)
    time.sleep(1)
driver.implicitly_wait(3)
e = driver.find_elements(By.CLASS_NAME, 'style-scope.ytd-comment-renderer')

for i in e:
    a=i.text
    b = a.split('\n')
    name.append(b[0])
    answer.append(b[2])
for j in answer:
    print(j)

