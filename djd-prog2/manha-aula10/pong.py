import pygame
pygame.init()
tela = pygame.display.set_mode((800, 600), 0)
x = 10.0
velx = 1.0
while True:
    # Calcular regras
    x = x + velx
    if x > 800:
        velx = -1.0

    if x < 0:
        velx = 1.0

    # Pintar tela
    tela.fill((0, 0, 0))
    pygame.draw.circle(tela, (255, 255, 0), (int(x), 100), 50, 0)
    pygame.display.update()

    # Capturando eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()