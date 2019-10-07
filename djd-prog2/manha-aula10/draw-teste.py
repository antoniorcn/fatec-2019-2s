import pygame
pygame.init()
tela = pygame.display.set_mode((800, 600), 0)
AMARELO = (255, 255, 0)
while True:
    # Calcular regras

    # Pintar tela
    # pygame.draw.line(tela, AMARELO, (100, 100), (200, 0), 3)
    # pygame.draw.line(tela, AMARELO, (200, 0), (300, 100), 3)
    lista = [(100, 100), (200, 0), (300, 100), (100, 100)]
    pygame.draw.polygon(tela, AMARELO, lista, 0)

    pygame.draw.rect(tela, AMARELO, ((100, 100), (200, 200)), 3)
    pygame.display.update()

    # Capturando eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
