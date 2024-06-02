import pygame as pg
import random
from pygame.sprite import Sprite
from pygame.color import Color
from pygame.surface import Surface
from settings import *
from sprites import *

class Game:
    def __init__(self):
        pg.init()
        self.screen = pg.display.set_mode((GAME_WINDOW_WIDTH, GAME_WINDOW_HEIGHT))
        pg.display.set_caption(TITLE)
        self.background = pg.image.load('background.png')
        self.running = True
        self.clock = pg.time.Clock()
        self.score = 0
        self.font_name = pg.font.match_font(FONT_NAME)

    def new(self):
        self.all_sprites = pg.sprite.Group()
        self.blocks = pg.sprite.Group()
        self.items = pg.sprite.Group()
        #self.clouds = pg.sprite.Group()

        self.runner = Runner(self)
        self.all_sprites.add(self.runner)

        for blox in BLOCK_LIST:
            b = Block(*blox)
            self.all_sprites.add(b)
            self.blocks.add(b)

        for item in JUMPBOOSTER_LIST:
            i = Jumpbooster(*item)
            self.all_sprites.add(i)
            self.items.add(i)

      #  for cloud in CLOUD_LIST:
       #     c = Cloud(*cloud)
        #    self.all_sprites.add(c)
         #   self.clouds.add(c) 

        self.run()

    def run (self):
        #게임 루프
        self.playing = True
        while self.playing:
            self.clock.tick(FPS)
            self.events()
            self.update()
            self.draw()

    def update(self):
        #게임루프 - 업데이트
        self.all_sprites.update()
        
        #블록을 밟았는지 확인하는 코드
        if self.runner.vel.y > 0:
            hits =pg.sprite.spritecollide(self.runner, self.blocks, False)
            if hits:
                self.runner.pos.y = hits[0].rect.top + 0.1
                self.runner.vel.y = 0
                
        #아이템을 먹었는지 확인하는 코드
        print(self.runner.vel.y)
        if self.runner.vel.y > 5:
            hits = pg.sprite.spritecollide(self.runner, self.items, False)
            if hits:
                self.runner.vel.y = -50
                
        #구름에 닿았는지 확인하는 코드
       # if self.runner.vel.y > 5:
        #    hits = pg.sprite.spritecollide(self.runner, self.clouds, True)
         #   if hits:
          #      self.runner.pos.y = hits[0].rect.top + 0.1
           #     self.runner.vel.y = -23

        if self.runner.rect.top <= GAME_WINDOW_HEIGHT/4:
            self.runner.pos.y += abs(self.runner.vel.y)
            for blox in self.blocks:
                blox.rect.y += abs(self.runner.vel.y)
                if blox.rect.top >= GAME_WINDOW_HEIGHT:
                    blox.kill()
                    self.score += 10
                    print(self.score)
            for item in self.items:
                item.rect.y += abs(self.runner.vel.y)
                if item.rect.top >= GAME_WINDOW_HEIGHT:
                    item.kill()
                    self.score += 10
         #   for clod in self.clouds:
          #      clod.rect.y += abs(self.runner.vel.y)
           #     if clod.rect.top >= GAME_WINDOW_HEIGHT:
            #        clod.kill()
             #       self.score += 10


        #죽음
        if self.runner.rect.bottom > GAME_WINDOW_HEIGHT:
            for sprite in self.all_sprites:
                sprite.rect.y -= max(self.runner.vel.y, 10)
                if sprite.rect.bottom <0:
                    sprite.kill()
                    self.score = 0
        if len(self.blocks) == 0:
            self.playing = False
            
        #블록 설치
        while len(self.blocks) < 5:
            width = random.randrange(1, 200)
            b = Block(random.randrange(0,GAME_WINDOW_WIDTH - width),
                         random.randrange(-75,-30), 80, 80)
            self.blocks.add(b)
            self.all_sprites.add(b)
        #아이템 설치
        while len(self.items) < 1:
            width = random.randrange(10, 300)
            i = Jumpbooster(random.randrange(0, GAME_WINDOW_WIDTH - width),
                            random.randrange(-75, -30), 80, 80)
            self.items.add(i)
            self.all_sprites.add(i)
        #구름 설치
     #   while len(self.clouds) < 1:
      #      width = random.randrange(10, 300)
       #     c = Cloud(random.randrange(0, GAME_WINDOW_WIDTH - width),
        #               random.randrange(-75, -30), 80, 80)

    def draw_text(self, text, size, color, x, y):
        font = pg.font.Font(self.font_name, size, bold=True)
        text_surface = font.render(text, True, color)
        text_rect = text_surface.get_rect()
        text_rect.midtop = (x, y)
        self.screen.blit(text_surface, text_rect.midtop)
        
        
    def wait_for_key(self):
        waiting = True
        while waiting:
            self.clock.tick(FPS)
            for event in pg.event.get():
                if event.type == pg.QUIT:
                    waiting = False
                    self.running = False
                if event.type == pg.KEYUP:
                    waiting = False
                    
    def events(self):
        #게임루프 - 이벤트
        for event in pg.event.get():
            if event.type == pg.QUIT:
                if self.playing:
                    self.playing = False
                self.running = False
            if event.type == pg.KEYDOWN:
                if event.key == pg.K_SPACE:
                    self.runner.jump()

    def draw(self):
        #게임루프 - 그리기
        self.screen.fill(BGCOLOR)
        self.all_sprites.draw(self.screen)
        self.draw_text(str(self.score), 50, WHITE, 228, 15)
        pg.display.flip()

    def show_start_screen(self):
        pass

    def show_go_screen(self):
        pass
g = Game()
g.show_start_screen()
while g.running:
    g.new()
    g.show_go_screen()

pg.quit()
