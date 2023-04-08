import pygame
from pygame.color import Color
from pygame.sprite import Sprite
from pygame.surface import Surface
from runner import Runner


FPS = 28

class Bullet(Sprite):
    def __init__(self):
        Sprite.__init__(self)
        self.image = pygame.image.load('cookie.png')
        self.image = pygame.transform.scale(self.image,(34,34))
        self.rect = self.image.get_rect()
    def update(self):
        self.rect.x -= 5

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

    runner1 = Runner()
    runner1.rect.x = 0
    runner1.rect.y = 205
    runner_group = pygame.sprite.Group()
    runner_group.add(runner1)

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
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                run = False
        keys = pygame.key.get_pressed()
        if keys[pygame.K_LEFT]:
            runner1.rect.x -= 5
        elif keys[pygame.K_RIGHT]:
            runner1.rect.x += 5
        elif event.type == pygame.KEYDOWN:
            key_status = 'KEYDOWN'
            key = event.key
            if pygame.key.name(key) == 'space': 
                runner1.rect.y = 140
        elif event.type == pygame.KEYUP:
            key_status = 'KEYUP'
            key = event.key
            runner1.rect.y = 205

        if runner1.rect.right > screen.get_width() or runner1.rect.x < 0:
            runner1.rect.x -= 1
        if runner1.rect.y > screen.get_height() or runner1.rect.y < 0:
            runner1.rect.y -= 1
        
        #2)게임 상태 업데이트
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
