import pygame

PRETO = (0, 0, 0)
AMARELO = (255, 255, 0)
tela = pygame.display.set_mode((800, 600), 0)

while True:
    # Calcular Regras

    # Pintar
    tela.fill(PRETO)
    tamanho = 100
    px = 400
    py = 300
    p_raio = tamanho // 2
    centro = (px, py)
    labio_superior = (px + tamanho, py - p_raio)
    labio_inferior = (px + tamanho, py + p_raio)
    pygame.draw.circle(tela, AMARELO, (px, py), p_raio, 0)
    lista = [centro, labio_superior, labio_inferior]
    pygame.draw.polygon(tela, PRETO, lista, 0)

    olho_x = px + p_raio // 3
    olho_y = py - p_raio // 2
    pygame.draw.circle(tela, PRETO, (olho_x, olho_y),
                       p_raio // 5,  0)

    pygame.display.update()

    # Captura Eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
