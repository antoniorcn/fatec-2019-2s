import pygame
from random import randint

PRETO = (0, 0, 0)
AMARELO = (255, 255, 0)
AZUL = (0, 0, 255)
tela = pygame.display.set_mode((800, 600), 0)

cenario = [
    [2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2],
    [2, 0, 0, 2, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [2, 0, 0, 2, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2],
    [2, 0, 0, 2, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2],
    [2, 0, 0, 2, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2],
    [2, 0, 0, 2, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2],
    [2, 2, 0, 2, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2],
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
    raio = tamanho // 2
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
            if cenario[lin_idx][col_idx] == 1:
                pygame.draw.circle(tela, AMARELO, (x + raio, y + raio), raio // 5, 0)
        # print()


def pacman_pintar(coluna, linha, tamanho):
    p_raio = tamanho // 2
    px = coluna * tamanho + p_raio
    py = linha * tamanho + p_raio
    centro = (px, py)
    labio_superior = (px + p_raio, py - p_raio)
    labio_inferior = (px + p_raio, py + p_raio)
    pygame.draw.circle(tela, AMARELO, (px, py), p_raio, 0)
    lista = [centro, labio_superior, labio_inferior]
    pygame.draw.polygon(tela, PRETO, lista, 0)

    olho_x = px + p_raio // 5
    olho_y = py - p_raio // 2
    pygame.draw.circle(tela, PRETO, (olho_x, olho_y),
                       p_raio // 5, 0)

tamanho = 40
pacman_coluna = 1
pacman_linha = 1
pacman_intencao_coluna = pacman_coluna
pacman_intencao_linha = pacman_linha
while True:
    # Calcular Regras
    if 0 < pacman_intencao_coluna < 16 and 0 < pacman_intencao_linha < 16 and \
            cenario[pacman_intencao_linha][pacman_intencao_coluna] != 2:
        pacman_coluna = pacman_intencao_coluna
        pacman_linha = pacman_intencao_linha
    else:
        pacman_intencao_coluna = pacman_coluna
        pacman_intencao_linha = pacman_linha

    if cenario[pacman_linha][pacman_coluna] == 1:
        cenario[pacman_linha][pacman_coluna] = 0

    # Pintar
    tela.fill(PRETO)
    cenario_pintar(tamanho)
    pacman_pintar(pacman_coluna, pacman_linha, tamanho)
    pygame.display.update()

    # Captura Eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()

