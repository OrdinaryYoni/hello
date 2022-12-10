import sys
import pygame
from runner import Runner
from pygame.sprite import Sprite
from pygame.surface import Surface
from pygame.color import Color

FPS = 28

#화면 크기
screen_width = 800
screen_height = 500

#속도와 질량 기본 값
speed = 7
mass = 2

class Bullet(Sprite):
    def __init__(self):
        Sprite.__init__(self)
        self.image = pygame.image.load('cookie.png')
        self.image = pygame.transform.scale(self.image,(34,34))
        self.rect = self.image.get_rect()
    def update(self):
        self.rect.x -= 5

class Player:

    def __init__(self):
        self.image = ''
        self.dx = 0
        self.dy = 0
        self.rect = ''
        self.jumping = 0
        self.sp = speed #속도
        self.m = mass #질량

    def runner(self):
        #플레이어
        self.image = pygame.image.load('runner.png')
        
        #위치
        self.rect = self.image.get_rect()
        self.rect.x = 0
        self.rect.y = 205

    #x 좌표 이동 - 플레이어 러너의 움직임 제어할 때 필요
        def move_x(self):
            self.rect.x += self.dx

    #화면 밖으로 못 나가게 방지
    def check_screen(self):
        if self.rect.right > screen_width or self.rect.x < 0:
            self.rect.x -= self.dx

    #점프 상태 체크
    def jump(self,j):
        self.jumping = j

    #점프
    def update(self):
        #jumping 값이 0보다 큰지 확인
        if self.jumping > 0:
            #jumping 값이 2일 경우 속도를 리셋
            #점프 한 상태에서 다시 점프를 위한 값
            #이 코드를 주석처리하면 이중점프를 못함
            if self.jumping == 2:
                self.sp = speed
            #역학공식 계산 (F). F = 0.5 * mass * speed^2.
            if self.sp > 0:
                #속도가 0보다 클땐 위로 올라감
                F = (0.5 * self.m * (self.sp * self.sp))
            else:
                #속도가 0보다 작을 땐 아래로 내려감
                F = -(0.5 * self.m * (self.sp * self.v))

            #좌표 수정: 위로 올라가기 위해서는 y좌표를 줄여준다.
            self.rect.y -= round(F)

            #속도 줄여줌
            self.sp -= 1

            #바닥에 닿았을 때 변수 리셋
            if self.rect.y > 205:
                self.rect.bottom = 205
                self.jumping = 0
                self.sp = speed
          
def main():
    global screen, screen_width, screen_height

    #pygame 초기화 및 스크린 생성
    pygame.init()
    screen = pygame.display.set_mode((screen_width, screen_height))
    pygame.display.set_caption("Let's eat cookies!")

    clock = pygame.time.Clock()
    coincount = 0
    
    #배경
    background_img = pygame.image.load('background.png')

    #플레이어 러너 생성
    player = Player()
    player.runner()
    runner_group = pygame.sprite.Group()
    runner_group.add(player)

    bullet1 = Bullet()
    bullet1.rect.x = screen.get_width()
    bullet1.rect.y = 250

    bullet2 = Bullet()
    bullet2.rect.x = screen.get_width()+40
    bullet2.rect.y = 160

    bullet3 = Bullet()
    bullet3.rect.x = screen.get_width() + 100
    bullet3.rect.y = 250

    bullet_group = pygame.sprite.Group()
    bullet_group.add(bullet1)
    bullet_group.add(bullet2)
    bullet_group.add(bullet3)

    playing = True
    while playing:
        #1) 사용자 입력처리

        #키가 눌린 상태 체크
        keys = pygame.key.get_pressed()
        #스페이스 키가 눌려있고, jumping이 2라면 1로 변경한다.
        #이 작업을 해주지 않으면 스페이스가 눌려있는 상태면 플레이어가
        #계속 위로 올라가게 된다.
        if(keys[pygame.K_space]):
            if player.jumping == 2:
                player.jump(1)
                
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                playing = False
                pygame.quit()
                sys.exit()

        #화살표 키를 이용해서 플레이어의 움직임 거리를 조정해준다.
        #키를 떼면 움직임 거리를 0으로 한다.
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_RIGHT:
                player.dx = 5
            elif evnet.key == pygame.K_LEFT:
                player.dx = -5
            #스페이스키를 눌렀을 때,
            #0이면 바닥인 상태: 1로 변경
            #1이면 점프를 한 상태: 2로 변경, 점프한 위치에서 다시 점프를
            #하게 된다. 즉, 이중 점프
            if event.key == pygame.K_SPACE:
                if player.jumping == 0:
                    player.jump(1)
                elif player.jumping == 1:
                    player.jump(2)
                    
        if event.type == pygame.KEYUP:
            if event.key == pygame.K_RIGHT:
                player.dx = 0
            elif event.key == pygame.K_LEFT:
                player.dx = 0

        #배경 생성
        screen.blit(background_img, screen.get_rect())

        '''게임 코드 작성'''

        #플레이어를 스크린에 표시 및 화면 밖으로 못 벗어나게 하기
        player.draw_runner()
        player.move_x()
        #플레이어의 y좌표를 움직여주는 메서드 추가, 점프하는 것
        player.update()
        player.check_screen()

        '''게임 코드 끝'''

        pygame.display.flip()

        #초당 프레임 설정
        clock.tick(60)
if __name__ == '__main__':
    
    main()
        
