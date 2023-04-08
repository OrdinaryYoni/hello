#게임 설정
TITLE = "Jumping On The Block!"
GAME_WINDOW_WIDTH = 500
GAME_WINDOW_HEIGHT = 800
FPS = 40
FONT_NAME = 'arial'

#플레이어 설정
PLAYER_ACC = 1.5
PLAYER_FRICTION = -0.2
PLAYER_GRAVITY = 0.7

#블록 설정
BLOCK_LIST = [(0, GAME_WINDOW_HEIGHT - 40, GAME_WINDOW_WIDTH, 40),
              (100,600,80,80),
              (350,GAME_WINDOW_HEIGHT / 2,80,80),
              (300,140,80,80),
              (150,300,80,80)]

#아이템 설정
JUMPBOOSTER_LIST = [(0,0,0,0)]
#CLOUD_LIST = [(0,0,0,0)]

#색
LIGHTBLUE = (0, 155, 155)
BGCOLOR = LIGHTBLUE
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
RED = (255, 0, 0)
GREEN = (0, 255, 0)
BLUE = (0, 0, 255)
MAGENTA = (255, 0, 255)
