import pygame as pg
from pygame.sprite import Sprite
from pygame.color import Color
from pygame.surface import Surface
from settings import *
vec = pg.math.Vector2

#Player
class Runner(Sprite):
    def __init__(self, game):
        Sprite.__init__(self)
        #러너 설정
        self.image = pg.image.load('네모모.png')
        self.image = pg.transform.scale(self.image,(70,70))
        self.game = game
        self.rect = self.image.get_rect()
        self.rect.center = (0, 240)

        self.pos = vec(230,780) #위치
        self.vel = vec(0,0) #속도
        self.acc = vec(0,0) #가속도

    def jump(self):
        #블록을 밟고 있을 때만 점프하기
        self.rect.y += 0.1
        hits = pg.sprite.spritecollide(self,self.game.blocks,False)
        self.rect.y -= 0.1
        if hits:
            self.vel.y = -23

    def update(self):
        self.acc = vec(0, PLAYER_GRAVITY) #초기 가속도 줌
        keys = pg.key.get_pressed()

        if keys[pg.K_LEFT]:
            self.acc.x = -PLAYER_ACC
        elif keys[pg.K_RIGHT]:
            self.acc.x = PLAYER_ACC

        self.acc.x += self.vel.x*PLAYER_FRICTION #마찰추가
        self.vel += self.acc #v = v0 + at 공식
        self.pos += self.vel + 0.5*self.acc #x = x0 + 1/2a^2 공식

        #캐릭터가 화면 밖으로 나가지 않게 하기
        if self.pos.x > GAME_WINDOW_WIDTH:
            self.pos.x = GAME_WINDOW_WIDTH
        elif self.pos.x < 0:
            self.pos.x = 0

        self.rect.midbottom = self.pos

class Block(Sprite):
    def __init__(self, x, y, w, h):
        Sprite.__init__(self)
        self.image = pg.image.load('구름.png')
        self.image = pg.transform.scale(self.image,(w,h))
        self.rect = self.image.get_rect()
        self.rect.x = x
        self.rect.y = y

class Jumpbooster(Sprite):
    def __init__(self, x, y, w, h):
        Sprite.__init__(self)
        self.image = pg.image.load('스프링잔디.png')
        self.image = pg.transform.scale(self.image,(w,h))
        self.rect = self.image.get_rect()
        self.rect.x = x
        self.rect.y = y

#class Cloud(Sprite):
#    def __init__(self, x, y, w, h):
 #       Sprite.__init__(self)
  #      self.image = pg.image.load('구름.png')
   #     self.image = pg.transform.scale(self.image,(w,h))
    #    self.rect = self.image.get_rect()
     #   self.rect.x = x
      #  self.rect.y = y

        
    
