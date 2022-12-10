import pygame
from pygame.color import Color
from pygame.sprite import Sprite
from pygame.surface import Surface

class Runner(Sprite):
    def __init__(self):
        Sprite.__init__(self)

        self.sprite_image = 'runnersprite.png'
        self.sprite_width = 70
        self.sprite_height = 100
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

        rect = (self.sprite_width*self.current_frame, 0,
                self.sprite_width, self.sprite_height)
        self.image.blit(self.sprite_sheet,(0,0),rect)
