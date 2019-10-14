import pygame

AMARELO = (255, 255, 0)
PRETO = (0, 0, 0)
AZUL = (0, 0, 255)
pygame.init()
screen = pygame.display.set_mode((800, 600), 0)
corpo_x = 400
corpo_y = 300
tamanho = 100
while True:
    raio = int(tamanho / 2)
    fundo_boca = (corpo_x, corpo_y)
    labio_inferior = (corpo_x + raio, corpo_y)
    labio_superior = (corpo_x + raio, corpo_y - raio)
    olho_raio = int(raio / 10)
    olho_x = corpo_x + int(raio / 6)
    olho_y = corpo_y - int(2 * raio / 3)

    # Desenha tela
    screen.fill(PRETO)
    pygame.draw.circle(screen, AMARELO, (corpo_x, corpo_y), raio, 0)
    pontos_boca = [fundo_boca, labio_inferior, labio_superior]
    pygame.draw.polygon(screen, PRETO, pontos_boca, 0)
    pygame.draw.circle(screen, PRETO, (olho_x, olho_y), olho_raio, 0)
    pygame.display.update()

    # Captura eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()