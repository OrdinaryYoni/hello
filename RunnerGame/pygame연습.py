import pygame

pygame.init()
screen = pygame.display.set_mode((300, 100))
pygame.display.set_caption('Play sound')

clock = pygame.time.Clock()
run = True

#사운드 로딩
fire_sound = pygame.mixer.Sound('fire.ogg')

#게임 루프
while run:
    #1)사용자 입력 처리
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            run = False
        elif event.type == pygame.KEYDOWN:
            fire_sound.stop()
            fire_sound.play()
    #2)게임 상태 업데이트

    #3)게임 상태 그리기
    screen.fill(pygame.color.Color(255,255,255))
    pygame.display.flip()

    clock.tick(60)

pygame.quit()
