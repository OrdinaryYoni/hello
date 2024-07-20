import pygame

pygame.init()
screen = pygame.display.set_mode((300,100))
pygame.display.set_caption('Keyboard Test')

clock = pygame.time.Clock()
run = True
key_status = ''
key = None

while run:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            run = False
        elif event.type == pygame.KEYDOWN:
            key_status = 'Key Down'
            key = event.key
        elif event.type == pygame.KEYUP:
            key_status = 'Key Up'
            key = event.key

        screen.fill(pygame.color.Color(255, 255, 255))

        if key:
            sf = pygame.font.SysFont('Monospace', 20, bold = True)
            text_str = pygame.key.name(key) + ' ' + key_status
            text = sf.render(text_str, True,(255,0,0))
            screen.blit(text,(50,40))

            pygame.display.flip()
            clock.tick(60)
pygame.quit()
