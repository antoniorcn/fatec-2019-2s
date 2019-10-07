import pygame
pygame.init()
tela = pygame.display.set_mode((800, 600), 0)
while True:
    # Calcular regras

    # Pintar tela
    pygame.display.update()

    # Capturando eventos
    for e in pygame.event.get():
        print(e)
        if e.type == pygame.QUIT:
            exit()
        elif e.type == pygame.MOUSEBUTTONDOWN:
            pygame.draw.circle(tela, (255, 255, 0), e.pos, 10, 0)
