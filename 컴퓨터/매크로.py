import pyautogui as pg
import keyboard as keys

pg.moveTo(500,500,1)
def Stop():
    if keys.is_pressed('q'):
        print('STOP')
        return 1

while True:
    pg.click(clicks=2)

    stop = Stop()

    if stop == 1:
        break

    


