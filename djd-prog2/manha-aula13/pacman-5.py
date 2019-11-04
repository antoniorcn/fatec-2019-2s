import pygame
from random import random

AMARELO = (255, 255, 0)
PRETO = (0, 0, 0)
AZUL = (0, 0, 255)
VERMELHO = (255, 0, 0)
ROSA = (238, 174, 238)
LARANJA = (255, 147, 51)
VELOCIDADE_BOCA = 0.3

pygame.init()
screen = pygame.display.set_mode((800, 600), 0)
tamanho = int(600 / 16)

class Cenario:
    def __init__(self, pac):
        self.cenario = [
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
        self.pontos = 0
        self.pac = pac

    def desenhar(self, tela, tamanho):
        for linha, linha_conteudo in enumerate(self.cenario):
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

    def calcular_regras(self):
        if 0 <= self.pac.intencao_linha < 16 and 0 <= self.pac.intencao_coluna < 16 \
                and self.cenario[self.pac.intencao_linha][self.pac.intencao_coluna] != 2:
            self.pac.corpo_linha = self.pac.intencao_linha
            self.pac.corpo_coluna = self.pac.intencao_coluna
            if self.cenario[self.pac.corpo_linha][self.pac.corpo_coluna] == 1:
                self.pontos += 1
                print(self.pontos)
                self.cenario[self.pac.corpo_linha][self.pac.corpo_coluna] = 0
        else:
            self.pac.intencao_linha = self.pac.corpo_linha
            self.pac.intencao_coluna = self.pac.corpo_coluna


class Pacman:
    def __init__(self):
        self.corpo_linha = 2
        self.corpo_coluna = 5
        self.intencao_linha = self.corpo_linha
        self.intencao_coluna = self.corpo_coluna
        self.abertura = 0
        self.vel_abertura = VELOCIDADE_BOCA

    def desenhar(self, tela, tamanho):
        raio = int(tamanho / 2)
        corpo_x = self.corpo_coluna * tamanho + raio
        corpo_y = self.corpo_linha * tamanho + raio
        fundo_boca = (corpo_x, corpo_y)
        labio_inferior = (corpo_x + raio, corpo_y + self.abertura)
        labio_superior = (corpo_x + raio, corpo_y - self.abertura)
        self.abertura = self.abertura + self.vel_abertura
        if self.abertura > raio:
            self.vel_abertura = - VELOCIDADE_BOCA
        if self.abertura <= 0:
            self.vel_abertura = VELOCIDADE_BOCA
        olho_raio = int(raio / 10)
        olho_x = corpo_x + int(raio / 6)
        olho_y = corpo_y - int(2 * raio / 3)
        pygame.draw.circle(tela, AMARELO, (corpo_x, corpo_y), raio, 0)
        pontos_boca = [fundo_boca, labio_inferior, labio_superior]
        pygame.draw.polygon(tela, PRETO, pontos_boca, 0)
        pygame.draw.circle(tela, PRETO, (olho_x, olho_y), olho_raio, 0)


class Fantasma:
    def __init__(self, cor):
        self.cor = cor
        self.fantasma_coluna = 6
        self.fantasma_linha = 4

    def desenhar(self, tela, tamanho):
        px = self.fantasma_coluna * tamanho
        py = self.fantasma_linha * tamanho
        w = tamanho // 8
        h = tamanho // 6

        lista = [(px, py + tamanho),
                 (px + w, py + 2 * h),
                 (px + 2 * w, py + h // 2),
                 (px + 3 * w, py),
                 (px + 5 * w, py),
                 (px + 6 * w, py + h // 2),
                 (px + 7 * w, py + 2 * h),
                 (px + tamanho, py + tamanho)
                 ]
        pygame.draw.polygon(tela, self.cor, lista, 0)

clyde = Fantasma(LARANJA)
ink = Fantasma(VERMELHO)
pinky = Fantasma(ROSA)
pinky.fantasma_coluna = 2
pinky.fantasma_linha = 3
blink = Fantasma(AZUL)
pacman = Pacman()
cenario = Cenario(pacman)

while True:
    # Calcular Regras
    cenario.calcular_regras()

    # clyde.fantasma_coluna += random() - 0.4

    # Desenha tela
    screen.fill(PRETO)
    cenario.desenhar(screen, tamanho)
    pacman.desenhar(screen, tamanho)
    clyde.desenhar(screen, tamanho)
    pinky.desenhar(screen, tamanho)
    pygame.display.update()

    # Captura eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
        if e.type == pygame.KEYDOWN:
            if e.key == pygame.K_RIGHT:
                pacman.intencao_coluna += 1
            if e.key == pygame.K_LEFT:
                pacman.intencao_coluna -= 1
            if e.key == pygame.K_UP:
                pacman.intencao_linha -= 1
            if e.key == pygame.K_DOWN:
                pacman.intencao_linha += 1
