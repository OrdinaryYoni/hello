import pygame
from pygame.sprite import Sprite
from pygame.color import Color
from pygame.surface import Surface

#게임 화면 크기
GAME_WINDOW_WIDTH = 1200
GAME_WINDOW_HEIGHT = 300
FPS = 28
velocity = 7
mass = 2

class BULLET(Sprite):
    def __init__(self):
        Sprite.__init__(self)
        self.image = pygame.image.load('cookie.png')
        self.image = pygame.transform.scale(self.image,(34,34))
        self.rect = self.image.get_rect()
    def update(self):
        self.rect.x -= 5

class Runner(Sprite):
    def __init__(self):
        Sprite.__init__(self)

class RUNNER(Sprite):
    def __init__(self):
        Sprite.__init__(self)

        self.sprite_image = 'runnersprite_crop.png'
        self.sprite_width = 70
        self.sprite_height = 77
        self.sprite_sheet = pygame.image.load(self.sprite_image).convert()

        self.sprite_columns = 14
        self.current_frame = 0
        self.image = Surface((self.sprite_width, self.sprite_height))

        rect = (self.sprite_width*self.current_frame,0,
                self.sprite_width, self.sprite_height)
        self.image.blit(self.sprite_sheet,(0,0),rect)
        self.image.set_colorkey(Color(255,0,255))
        self.rect = self.image.get_rect()

    def update(self):
        if self.current_frame == self.sprite_columns - 1:
            self.current_frame = 0
        else:
            self.current_frame += 1

        rect = (self.sprite_width*self.current_frame,0,
                self.sprite_width, self.sprite_height)
        self.image.blit(self.sprite_sheet,(0,0),rect)
        
        
if __name__ == '__main__':
    
    #게임요소들
    pygame.init()
    screen = pygame.display.set_mode((GAME_WINDOW_WIDTH,GAME_WINDOW_HEIGHT))
    pygame.display.set_caption('TEST')
    background = pygame.image.load('background.png')
    run = True
    clock = pygame.time.Clock()
    CoinCount = 0

    runner = RUNNER()
    runner.rect.x = 0
    runner.rect.y = 210
    runner_group = pygame.sprite.Group()
    runner_group.add(runner)
    
    bullet1 = BULLET()
    bullet1.rect.x = screen.get_width()
    bullet1.rect.y = 250
    
    bullet2 = BULLET()
    bullet2.rect.x = screen.get_width()+100
    bullet2.rect.y = 150
    
    bullet3 = BULLET()
    bullet3.rect.x = screen.get_width()+200
    bullet3.rect.y = 250

    bullet4 = BULLET()
    bullet4.rect.x = screen.get_width()+350
    bullet4.rect.y = 250

    bullet5 = BULLET()
    bullet5.rect.x = screen.get_width()+450
    bullet5.rect.y = 150

    bullet_group = pygame.sprite.Group()
    bullet_group.add(bullet1)
    bullet_group.add(bullet2)
    bullet_group.add(bullet3)
    bullet_group.add(bullet4)
    bullet_group.add(bullet5)
    #------------------------------------------------------------------
    while run:
        #사용자 입력 처리
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                run = False

        keys = pygame.key.get_pressed()

        if keys[pygame.K_LEFT]:
            runner.rect.x -= 10
        elif keys[pygame.K_RIGHT]:
            runner.rect.x += 10
        elif keys[pygame.K_UP]:
            runner.rect.y -= 5
        elif keys[pygame.K_DOWN]:
            runner.rect.y += 5

        if runner.rect.right >= GAME_WINDOW_WIDTH:
            runner.rect.x -= 10
        elif runner.rect.x <= 0:
            runner.rect.left += 10

        #게임 상태 업데이트
        runner_group.update()
        bullet_group.update()

        collided = pygame.sprite.groupcollide(bullet_group,runner_group,False,False)

        if len(collided.items()) > 0:
            list(collided.keys())[0].rect.x = screen.get_width()+ 100
            CoinCount += 1
            print('먹은 동전 수 :',CoinCount)
            print(collided.keys())
            
        #게임 상태 그리기
        screen.blit(background,screen.get_rect())
        runner_group.draw(screen)
        bullet_group.draw(screen)
        pygame.display.flip()

        clock.tick(FPS)
        
    pygame.quit()
    
