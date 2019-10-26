import pygame
from random import randint

PRETO = (0, 0, 0)
AMARELO = (255, 255, 0)
AZUL = (0, 0, 255)
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


def cenario_pintar(tamanho):
    for lin_idx in range(0, 16):
        for col_idx in range(0, 16):
            cor = PRETO
            if cenario[lin_idx][col_idx] == 2:
                cor = AZUL
            # tela.set_at((col_idx, lin_idx), cor)
            x = col_idx * tamanho
            y = lin_idx * tamanho
            pygame.draw.rect(tela, cor, ((x, y), (tamanho, tamanho)), 0)
            # print(cenario[lin_idx][col_idx], " ", end="")
        # print()


def pacman_pintar(coluna, linha, tamanho):
    p_raio = tamanho // 2
    px = coluna * tamanho + p_raio
    py = linha * tamanho + p_raio
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

tamanho = 40
pacman_coluna = 1
pacman_linha = 1
while True:
    # Calcular Regras

    # Pintar
    tela.fill(PRETO)
    cenario_pintar(tamanho)
    pacman_pintar(pacman_coluna, pacman_linha, tamanho)
    pygame.display.update()

    # Captura Eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
