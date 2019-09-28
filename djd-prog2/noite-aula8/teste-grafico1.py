import pygame
from random import randint
pygame.init()
tela = pygame.display.set_mode((800, 600), 0, 32)
while True:
    # Calcular as regras
    x = randint(0, 800)
    y = randint(0, 600)
    raio = randint(0, 200)
    r = randint(0, 255)
    g = randint(0, 255)
    b = randint(0, 255)
    # Desenha Tela
    tela.set_at((400, 300), (255, 255, 0))
    pygame.display.update()
    pygame.draw.circle(tela, (r, g, b), (x, y), raio, 0)
    # Capturar eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()

