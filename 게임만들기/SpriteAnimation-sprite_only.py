import pygame
from pygame.color import Color
from runner import Runner

FPS = 28

if __name__ == '__main__':
    pygame.init()

    size = (400,300)
    screen = pygame.display.set_mode(size)
    pygame.display.set_caption('Runner Animation')

    run = True
    clock = pygame.time.Clock()

    background_img = pygame.image.load('background.png')

    runner1 = Runner()
    runner1.rect.x = 0
    runner1.rect.y = 190

    #게임루프
    while run:
        #1)사용자 입력처리
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                run = False
            
        #2)게임 상태 업데이트
        runner1.update()
        #3)게임 상태 그리기
        screen.blit(background_img, screen.get_rect())
        screen.blit(runner1.image, runner1.rect)
        pygame.display.flip()

        clock.tick(FPS)
pygame.quit()
