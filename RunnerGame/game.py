import pygame as pg
from pygame.sprite import Sprite
from pygame.color import Color
from pygame.surface import Surface
from settings import *
from sprites import *

if __name__ == '__main__':

    #게임요소들
    pg.init()
    screen = pg.display.set_mode((GAME_WINDOW_WIDTH, GAME_WINDOW_HEIGHT))
    pg.display.set_caprion(TITLE)
    background = pg.image.load('background.png')
    run = True
    clock = pygame.time.Clock()
    CoinCount = 0

    runner = Runner()

    block1 = Block()
    block1.rect.x = 300
    block1.rect.y = 230

    runner_group = pygame.sprite.Group()
    runner_group.add(runner)
    
    block_group = pygame.sprite.Group()
    block_group.add(block1)

    while run:
        #사용자 입력 처리
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                run = False
            if event.type == pg.KEYDOWN:
                if event.key == pg.K_SPACE:
                    runner.jump()

        #게임 상태 업데이트
        runner_group.update()
        block_group.update()

        if runner.vel.y > 0:
            hits = pg.sprite.spritecollide(runner, block, False)
            if hits:
                runner.pos.y = hits[0].rect.top + 0.1
                runner.vel.y = 0

        #게임 상태 그리기
        screen.blit(background, screen.get_rect())
        runner_group.draw(screen)
        block_group.draw(screen)
        pygame.display.flip()

        clock.tick(FPS)
pygame.quit()
                    
    
        
