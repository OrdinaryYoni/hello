import pygame as pg
from pygame.sprite import Sprite
from pygame.color import Color
from pygame.surface import Surface
from settings import *
vec = pg.math.Vector2

#Player
class Runner(Sprite):
    def __init__(self):
        Sprite.__init__(self)

        #러너 동작 설정
        self.sprite_image = 'runnersprite_crop.png'
        self.sprite_width = 70
        self.sprite_height = 77
        self.sprite_sheet = pygame.image.load(self.sprite_image).convert()

        self.sprite_columns = 14
        self.current_frame = 0
        self.image = Surface((self.sprite_width, self.sprite_height))

        rect = (self.sprite_width*self.current_frame, 0,
                self.sprite_width, self.sprite_height)
        self.image.blit(self.sprite_sheet,(0,0),rect)
        self.image.set_colorkey(Color(255,0,255))

        #러너 설정
        self.game = game
        self.rect = (self.image.get_rect())
        self.rect.center = (0, 190)

        self.pos = vec(0, 190) #위치
        self.vel = vec(0,0) #속도
        self.acc = vec(0,0) #가속도

    def jump(self):
        #블록을 밟고 있을 때만 점프하기
        self.rect.y += 0.1
        hits = pg.sprite.spritecollide(self,self.game.block,False)
        self.rect.y -= 0.1
        if hits:
            self.vel.y = -20

    def update(self):
        self.acc = vec(0, PLAYER_GRAVITY) #초기 가속도 줌
        keys = pg.key.get_pressed()

        if keys[pg.K_LEFT]:
            self.acc.x = -PLAYER_ACC
        elif keys[pg.K_RIGHT]:
            self.acc.x = PLAYER_ACC

        self.acc.x += self.vel.x*PLAYER_FRICTION #마찰추가
        self.vel += self #v = v0 + at 공식
        self.pos += self.vel + 0.5*self.acc #x = x0 + 1/2a^2 공식

        #캐릭터가 화면 밖으로 나가지 않게 하기
        if self.pos.x > GAME_WINDOW_WIDTH:
            self.pos.x = GAME_WINDOW_WIDTH
        elif self.pos.x < 0:
            self.pos.x = 0

        self.rect.midbottom = self.pos

class Block(Sprite):
    def __init__(self, x, y):
        Sprite.__init__(self)
        self.image = pg.image.load('네모모.png')
        self.image = pg.transform.scale(self.image,(50,50))
        self.rect = self.image.get.rect()
        self.rect.x = x
        self.rect.y = y
        
        

        
    
