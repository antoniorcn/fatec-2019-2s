import pygame

AMARELO = (255, 255, 0)
PRETO = (0, 0, 0)
AZUL = (0, 0, 255)

cenario = [
    [2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2],
    [2, 1, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 2],
    [2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 0, 0, 0, 0, 0, 2],
    [2, 2, 2, 2, 2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 2],
    [2, 0, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 2],
    [2, 0, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 2],
    [2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 2],
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

pygame.init()
screen = pygame.display.set_mode((800, 600), 0)
corpo_linha = 2
corpo_coluna = 5
tamanho = int(600 / 16)


def desenhar_pacman(tela):
    raio = int(tamanho / 2)
    corpo_x = corpo_coluna * tamanho + raio
    corpo_y = corpo_linha * tamanho + raio
    fundo_boca = (corpo_x, corpo_y)
    labio_inferior = (corpo_x + raio, corpo_y)
    labio_superior = (corpo_x + raio, corpo_y - raio)
    olho_raio = int(raio / 10)
    olho_x = corpo_x + int(raio / 6)
    olho_y = corpo_y - int(2 * raio / 3)
    pygame.draw.circle(tela, AMARELO, (corpo_x, corpo_y), raio, 0)
    pontos_boca = [fundo_boca, labio_inferior, labio_superior]
    pygame.draw.polygon(tela, PRETO, pontos_boca, 0)
    pygame.draw.circle(tela, PRETO, (olho_x, olho_y), olho_raio, 0)


def desenhar_cenario(tela, cena, tamanho):
    for linha, linha_conteudo in enumerate(cena):
        for coluna, coluna_conteudo in enumerate(linha_conteudo):
            x = coluna * tamanho
            y = linha * tamanho
            cor = PRETO
            if coluna_conteudo == 2:
                cor = AZUL
            r = pygame.Rect((x, y), (tamanho, tamanho))
            pygame.draw.rect(tela, cor, r, 0)
            if coluna_conteudo == 1:
                ponto_x = int(x + tamanho / 2)
                ponto_y = int(y + tamanho / 2)
                ponto_raio = int(tamanho / 10)
                pygame.draw.circle(tela, AMARELO, (ponto_x, ponto_y), ponto_raio, 0)


while True:
    # Desenha tela
    screen.fill(PRETO)
    desenhar_cenario(screen, cenario, tamanho)
    desenhar_pacman(screen)
    pygame.display.update()

    # Captura eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
        if e.type == pygame.KEYDOWN:
            if e.key == pygame.K_RIGHT:
                corpo_coluna += 1
