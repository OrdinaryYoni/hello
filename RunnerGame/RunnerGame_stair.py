import pygame
from pygame.sprite import Sprite
from pygame.color import Color
from pygame.surface import Surface
from settings import *
vec = pygame.math.Vector2

#장애물
class BLOCK(Sprite):
    def __init__(self):
        Sprite.__init__(self)
        self.image = pygame.image.load('네모모.png')
        self.image = pygame.transform.scale(self.image,(50,50))
        self.rect = self.image.get_rect()    
        
#쿠키
class BULLET(Sprite):
    def __init__(self):
        Sprite.__init__(self)
        self.image = pygame.image.load('cookie.png')
        self.image = pygame.transform.scale(self.image,(34,34))
        self.rect = self.image.get_rect()
    def update(self):
        self.rect.x -= 5
#------------------------------------------------------------------
#플레이어
class RUNNER(Sprite):

    def __init__(self):
        Sprite.__init__(self)
        #러너 설정
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
        self.isJump = 0
        self.on = 0
        self.left_going = 0
        self.right_going = 0
        self.v = velocity #속도
        self.m = mass #질량
#======================================#
    def jump(self, j):
        self.isJump = j
    def On(self, o):
        self.on = o
        print(o)
#======================================#
    def update(self):
        #스프라이트
        if self.current_frame == self.sprite_columns - 1:
            self.current_frame = 0
        else:
            self.current_frame += 1

        rect = (self.sprite_width*self.current_frame,0,
                self.sprite_width, self.sprite_height)
        self.image.blit(self.sprite_sheet,(0,0),rect)
#======================================#
        # isJump 값이 0보다 큰지 확인
        if self.isJump > 0:
    
            # 역학공식 계산 (F). F = 0.5 * mass * velocity^2.
            if self.v > 0:
                # 속도가 0보다 클때는 위로 올라감
                F = (0.5 * self.m * (self.v * self.v))
            else:
                # 속도가 0보다 작을때는 아래로 내려감
                F = -(0.5 * self.m * (self.v * self.v))

            # 좌표 수정 : 위로 올라가기 위해서는 y 좌표를 줄여준다.
            self.rect.y -= round(F)

            # 속도 줄여줌
            self.v -= 1

            # 바닥에 닿았을때, 변수 리셋
            if self.rect.bottom > GAME_WINDOW_HEIGHT:
                self.rect.bottom = 290
                self.isJump = 0
                self.v = velocity

            elif self.on == 1 and self.v <= 0:
                self.rect.bottom = block1.rect.top +1
                self.isJump = 0
                self.v = velocity

if __name__ == '__main__':

    #게임요소들
    pygame.init()
    screen = pygame.display.set_mode((GAME_WINDOW_WIDTH,GAME_WINDOW_HEIGHT))
    pygame.display.set_caption(TITLE)
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

    block1 = BLOCK()
    block1.rect.x = 300
    block1.rect.y = 230

    block_group = pygame.sprite.Group()
    block_group.add(block1)

    #------------------------------------------------------------------
    while run:
        #사용자 입력 처리
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                run = False

        #키가 눌린 상태 체크
        keys = pygame.key.get_pressed()

        #점프키
        #스페이스키가 눌려있고, jump가 2라면 1로 변경한다.
        #이 작업을 해주지 않으면 스페이스가 눌려있는 상태면 플레이어가 계속 위로 올라가게 된다.
        if keys[pygame.K_SPACE]:
            if runner.isJump == 2:
                runner.jump(1)

        #스페이스키를 눌렀을 때,
        #0이면 바닥인 상태:1로 변경
        #1이면 점프를 한상태 : 2로 변경, 점프한 위치에서 다시 점프를 하게 된다. 즉, 이중점프
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_SPACE:
                if runner.isJump ==0:
                    runner.jump(1)
                elif runner.isJump == 1:
                    runner.jump(2)

        #이동키
        if keys[pygame.K_LEFT]:
            runner.rect.x -= 5
        elif keys[pygame.K_RIGHT]:
            runner.rect.x += 5
        if runner.rect.right >= GAME_WINDOW_WIDTH:
            runner.rect.x -= 5
        elif runner.rect.x <= 0:
            runner.rect.left += 5
            
#============================================#
        #게임 상태 업데이트
        runner_group.update()
        bullet_group.update()
        block_group.update()

        collided = pygame.sprite.groupcollide(bullet_group,runner_group,False,False)

        block_collided = pygame.sprite.groupcollide(block_group,runner_group,False,False)

        if len(block_collided.items()) > 0:
            runner.On(1)
        if len(block_collided.items()) == 0:
            runner.On(0)
            
        if len(collided.items()) > 0:
            list(collided.keys())[0].rect.x = screen.get_width()+ 100
            CoinCount += 1
            print('먹은 쿠키 수 :',CoinCount)

        #게임 상태 그리기
        screen.blit(background, screen.get_rect())
        runner_group.draw(screen)
        bullet_group.draw(screen)
        block_group.draw(screen)
        pygame.display.flip()

        clock.tick(FPS)

pygame.quit()
