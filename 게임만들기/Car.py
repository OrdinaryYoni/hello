import sys
import pygame

# 게임 화면 크기
WINDOW_WIDTH = 800
WINDOW_HEIGHT = 500

# 색상
WHITE = (255,255,255)

# 속도와 질량 기본 값
VELOCITY = 7
MASS = 2

class Car:
    
    def __init__(self):
        self.image = ""
        self.dx = 0
        self.dy = 0
        self.rect = ""
        self.isJump = 0
        self.v = VELOCITY # 속도
        self.m = MASS  # 질량

        
            
import pygame

# 게임 화면 크기
WINDOW_WIDTH = 800
WINDOW_HEIGHT = 500

# 색상
WHITE = (255,255,255)

# 속도와 질량 기본 값
VELOCITY = 7
MASS = 2

class Car:
    
    def __init__(self):
        self.image = ""
        self.dx = 0
        self.dy = 0
        self.rect = ""
        self.isJump = 0
        self.v = VELOCITY # 속도
        self.m = MASS  # 질량

    def update(self):
        # isJump 값이 0보다 큰지 확인
        if self.isJump > 0:
            # isJump 값이 2일 경우 속도를 리셋
            # 점프 한 상태에서 다시 점프를 위한 값

            # 이 코드를 주석처리하면 이중점프를 못한다.
            if self.isJump == 2:
                self.v = VELOCITY

 

            # 역학공식 계산 (F). F = 0.5 * mass * velocity^2.
            if self.v > 0:
                # 속도가 0보다 클때는 위로 올라감
                F = (0.5 * self.m * (self.v * self.v))
            else:
                # 속도가 0보다 작을때는 아래로 내려감
                F = -(0.5 * self.m * (self.v * self.v))

 

            # 좌표 수정 : 위로 올라가기 위해서는 y 좌표를 줄여준다.
            self.rect.y -= round(F)

 

            # 속도 줄여줌> WINDOW_HEIGHT:
            self.rect.bottom = WINDOW_HEIGHT
            self.isJump = 0
            self.v = VELOCITY

    
    def jump(self, j):
        self.isJump = j

    def load_car(self):
        # 플레이어 차량
        self.image = pygame.image.load("runner.png")
        # 크기 조정
        self.image = pygame.transform.scale(self.image, (150, 57))
        self.rect = self.image.get_rect()
        self.rect.centerx = round(WINDOW_WIDTH / 2)
        self.rect.bottom = WINDOW_HEIGHT

    # 자동차를 스크린에 그리기
    def draw_car(self):
        SCREEN.blit(self.image, [self.rect.x, self.rect.y])
        
    # x 좌표 이동 - 플레이어 자동차의 움직임 제어할 때 필요
    def move_x(self):
        self.rect.x += self.dx

    # 화면 밖으로 못 나가게 방지
    def check_screen(self):
        if self.rect.right > WINDOW_WIDTH or self.rect.x < 0:
            self.rect.x -= self.dx
        if self.rect.bottom > WINDOW_HEIGHT or self.rect.y < 0:
            self.rect.y -= self.dy

def main():
    global SCREEN, WINDOW_WIDTH, WINDOW_HEIGHT

    # pygame 초기화 및 스크린 생성
    pygame.init()
    SCREEN = pygame.display.set_mode((WINDOW_WIDTH, WINDOW_HEIGHT))
    pygame.display.set_caption("Jump Test")

    clock = pygame.time.Clock()

    # 플레이어 자동차 생성
    player = Car()
    player.load_car()

    playing = True

    while playing:

        # 키가 눌린 상태 체크
        keys = pygame.key.get_pressed()
        # 스페이스키가 눌려있고, isJump가 2라면 1로 변경한다.
        # 이 작업을 해주지 않으면 스페이스가 눌려있는 상태면 플레이어가 계속 위로 올라가게 된다.
        if (keys[pygame.K_SPACE]):
            if player.isJump == 2:
                player.jump(1)


        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                playing = False
                pygame.quit()
                sys.exit()

 

            # 화살표 키를 이용해서 플레이어의 움직임 거리를 조정해준다.
            # 키를 떼면 움직임 거리를 0으로 한다.
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_RIGHT:
                    player.dx = 5
                elif event.key == pygame.K_LEFT:
                    player.dx = -5


                # 스페이스키를 눌렀을 때,
                # 0이면 바닥인 상태 : 1로 변경
                # 1이면 점프를 한 상태 : 2로 변경, 점프한 위치에서 다시 점프를 하게 된다. 즉, 이중점프
                if event.key == pygame.K_SPACE:
                    if player.isJump == 0:
                        player.jump(1)
                    elif player.isJump == 1:
                        player.jump(2)

 

            if event.type == pygame.KEYUP:
                if event.key == pygame.K_RIGHT:
                    player.dx = 0
                elif event.key == pygame.K_LEFT:
                    player.dx = 0

 

        # 배경색을 흰색으로
        SCREEN.fill(WHITE)

 

        ''' 게임 코드 작성 '''

 

        # 플레이어를 스크린에 표시 및 화면 밖으로 못 벗어나게 하기
        player.draw_car()
        player.move_x()

        # 플레이어의 y 좌표를 움직여주는 메서드 추가, 점프하는 것

        player.update()
        player.check_screen()

        ''' 게임 코드 끝 '''

        pygame.display.flip()

        # 초당 프레임 설정
        clock.tick(60)

if __name__ == '__main__':
    main()
