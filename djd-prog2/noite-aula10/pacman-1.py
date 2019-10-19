import pygame
from random import randint

PRETO = (0, 0, 0)
AMARELO = (255, 255, 0)
tela = pygame.display.set_mode((800, 600), 0)

cenario = [
    [2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2],
    [2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2],
    [2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2],
    [2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2],
    [2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2],
    [2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2],
    [2, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2],
    [2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2],
    [2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2],
    [2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2],
    [2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2],
    [2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2],
    [2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2],
    [2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2],
    [2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2],
    [2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2]

]


def cenario_pintar():
    tamanho = 40
    for lin_idx in range(0, 16):
        for col_idx in range(0, 16):
            cor = PRETO
            if cenario[lin_idx][col_idx] == 2:
                cor = AMARELO
            # tela.set_at((col_idx, lin_idx), cor)
            x = col_idx * tamanho
            y = lin_idx * tamanho
            pygame.draw.rect(tela, cor, ((x, y), (tamanho, tamanho)), 0)
            # print(cenario[lin_idx][col_idx], " ", end="")
        # print()


def pacman_pintar(px, py, tamanho):
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
                       p_raio // 5, 0)


while True:
    # Calcular Regras

    # Pintar
    tela.fill(PRETO)
    pacman_pintar(400, 300, 100)
    cenario_pintar()
    pygame.display.update()

    # Captura Eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
