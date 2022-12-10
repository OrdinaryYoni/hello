import pygame
import sys
from pygame.color import Color
from pygame.sprite import Sprite
from pygame.surface import Surface
from runner import Runner


FPS = 28
velocity = 7
mass = 2
class Bullet(Sprite):
    def __init__(self):
        Sprite.__init__(self)
        self.image = pygame.image.load('cookie.png')
        self.image = pygame.transform.scale(self.image,(34,34))
        self.rect = self.image.get_rect()
    def update(self):
        self.rect.x -= 5
        
class Player(Sprite):
    def __init__(self):
        Sprite.__init__(self)
        self.image = pygame.image.load('runner.png')
        self.rect = self.image.get_rect()
        self.jump = 0
        self.v = velocity
        self.m = mass
    def update(self):
        if self.jump == 2:
            self.v = velocity
            

        if self.v > 0:
            F = (0.5 * self.m * (self.v * self.v))
        else:
            F = -(0.5 * self.m * (self.v * self.v))

        self.rect.y -= round(F)

        self.v -= 1
        
        if self.rect.bottom > 205:
            self.rect.bottom = 205
            self.jump = 0
            self.v = velocity

    def jumping(self,j):
        self.jump = j

    def check_screen(self):
        if self.rect.right > screen.get_width or self.rect.x < 0:
            self.rect.x -= 5
        if self.rect.y > 205  or self.rect.y < 0:
            self.rect.y -= 5
if __name__ == '__main__':
    pygame.init()

    size = (400,300)
    screen = pygame.display.set_mode(size)
    pygame.display.set_caption('Runner Animation')

    run = True
    clock = pygame.time.Clock()
    coincount = 0
    key_status = ''
    key = None

    background_img = pygame.image.load('background.png')

    runner = Player()
    runner.rect.x = 0
    runner.rect.y = 205
    runner_group = pygame.sprite.Group()
    runner_group.add(runner)

    bullet1 = Bullet()
    bullet1.rect.x = screen.get_width()
    bullet1.rect.y = 250

    bullet2 = Bullet()
    bullet2.rect.x = screen.get_width()+40
    bullet2.rect.y = 250

    bullet3 = Bullet()
    bullet3.rect.x = screen.get_width()+100
    bullet3.rect.y = 160
    
    bullet_group = pygame.sprite.Group()
    bullet_group.add(bullet1)
    bullet_group.add(bullet2)
    bullet_group.add(bullet3)

    #게임 루프
    while run:
        #1)사용자 입력 처리
        keys = pygame.key.get_pressed()

        if(keys[pygame.K_SPACE]):
            if runner.jump == 2:
                runner.jump(1)
                
        if keys[pygame.K_LEFT]:
            runner.rect.x -= 5
        elif keys[pygame.K_RIGHT]:
            runner.rect.x += 5
                
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                run = False
        


        if keys[pygame.K_SPACE]:
            if runner.jump == 0:
                runner.jump(1)
            elif runner.jump == 1:
                runner.jump(2)
        
        #2)게임 상태 업데이트
        runner.update()
        runner_group.update()
        bullet_group.update()
        collided = pygame.sprite.groupcollide(bullet_group, runner_group, False, False)
        
        if len(collided.items()) > 0:
            list(collided.keys())[0].rect.x = screen.get_width()+40
            coincount += 1
            print('먹은 동전 수 :',coincount)
    
            
        #3)게임 상태 그리기
        
        screen.blit(background_img, screen.get_rect())
        runner_group.draw(screen)
        bullet_group.draw(screen)
        pygame.display.flip()

        clock.tick(FPS)

    pygame.quit()
    
    
