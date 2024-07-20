import pyautogui as pg
import time as t

def NameWrite():
    pg.moveTo(200,500)
    pg.drag(125,0,0.5)
    pg.drag(0,125,0.5)
    pg.drag(-125,0,0.5)
    pg.drag(0,-125,0.5)
    pg.moveTo(360,500)
    pg.drag(0,125,0.5)
    pg.moveTo(340,562)
    pg.drag(20,0,0.5)
    pg.moveTo(390,500)
    pg.drag(0,125,0.5)
    pg.moveTo(440,500)
    pg.drag(125,0,0.5)
    pg.drag(0,50,0.5)
    pg.drag(-125,0,0.5)
    pg.drag(0,50,0.5)
    pg.drag(125,0,0.5)
    pg.moveTo(630,500)
    pg.drag(0,125,0.5)
    pg.moveTo(630,562)
    pg.drag(-20,0,0.5)
    pg.moveTo(364,120)
    pg.click()
    pg.moveTo(293,163)
    pg.click()
    pg.moveTo(455,633)
    pg.drag(171,100,0.5)
    pg.moveTo(308,113)
    pg.click()




