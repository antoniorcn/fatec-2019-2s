import pygame
import math
pygame.init()
tela = pygame.display.set_mode((800, 600), 0)
x = 10.0
y = 100.0
velx = 0.0
while True:
    # Calcular regras
    x = x + velx
    if x > 800:
        velx = -1.0

    if x < 0:
        velx = 1.0

    # teste de colisao
    dx = abs(x - 300)
    dy = abs(y - 100)
    h = math.sqrt(dx*dx + dy*dy)
    if h < (50 + 10):
        print("Colidiu")

    # Pintar tela
    tela.fill((0, 0, 0))
    pygame.draw.circle(tela, (255, 255, 0), (int(x), int(y)), 50, 0)
    pygame.draw.circle(tela, (255, 0, 0), (300, 100), 10, 0)
    pygame.display.update()

    # Capturando eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
        elif e.type == pygame.KEYDOWN:
            if e.key == pygame.K_RIGHT:
                velx = 0.1
            elif e.key == pygame.K_LEFT:
                velx = -0.1
        elif e.type == pygame.KEYUP:
            if e.key == pygame.K_RIGHT:
                velx = 0
