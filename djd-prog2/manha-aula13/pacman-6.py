import pygame
import random

AMARELO = (255, 255, 0)
PRETO = (0, 0, 0)
AZUL = (0, 0, 255)
VERMELHO = (255, 0, 0)
ROSA = (238, 174, 238)
LARANJA = (255, 147, 51)
VELOCIDADE_BOCA = 0.3

ACIMA = 0
ABAIXO = 2
ESQUERDA = 3
DIREITA = 1

pygame.init()
screen = pygame.display.set_mode((800, 600), 0)
tamanho = int(600 / 30)

class Cenario:
    def __init__(self, pac):
        self.cenario = [
            [2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2],
            [2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
            [2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2],
            [2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2],
            [2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2],
            [2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
            [2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2],
            [2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2],
            [2, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 2],
            [2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2],
            [2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2],
            [2, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2],
            [2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 0, 0, 0, 0, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2],
            [2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 0, 0, 0, 0, 0, 0, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2],
            [2, 1, 1, 1, 1, 1, 1, 2, 2, 1, 2, 0, 0, 0, 0, 0, 0, 2, 1, 2, 2, 1, 1, 1, 1, 1, 1, 2],
            [2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 0, 0, 0, 0, 0, 0, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2],
            [2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2],
            [2, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2],
            [2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2],
            [2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2],
            [2, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 2],
            [2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2],
            [2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2],
            [2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
            [2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2],
            [2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2],
            [2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2],
            [2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
            [2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2]
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

    def aprovar_movimento(self, personagem):
        aprovado = False
        if 0 <= personagem.intencao_linha < len(self.cenario) \
                and 0 <= personagem.intencao_coluna < len(self.cenario[0]) \
                and self.cenario[personagem.intencao_linha][personagem.intencao_coluna] != 2:
            personagem.linha = personagem.intencao_linha
            personagem.coluna = personagem.intencao_coluna
            aprovado = True
        else:
            personagem.intencao_linha = personagem.linha
            personagem.intencao_coluna = personagem.coluna
        return aprovado

    def calcular_regras(self):
        if self.aprovar_movimento(self.pac):
            if self.cenario[self.pac.linha][self.pac.coluna] == 1:
                self.pontos += 1
                print(self.pontos)
                self.cenario[self.pac.linha][self.pac.coluna] = 0



class Pacman:
    def __init__(self):
        self.linha = 17
        self.coluna = 15
        self.intencao_linha = self.linha
        self.intencao_coluna = self.coluna
        self.abertura = 0
        self.vel_abertura = VELOCIDADE_BOCA

    def desenhar(self, tela, tamanho):
        raio = int(tamanho / 2)
        corpo_x = self.coluna * tamanho + raio
        corpo_y = self.linha * tamanho + raio
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
    def __init__(self, cor, linha=14, coluna=13):
        self.cor = cor
        self.coluna = coluna
        self.linha = linha
        self.intencao_linha = self.linha
        self.intencao_coluna = self.coluna
        self.delay = 20
        self.ciclos = 0
        self.passo = 0
        self.direcao = 0
        self.distancia = 5

    def escolher_direcao(self):
        self.direcao = random.randint(0, 4)
        self.distancia = random.randint(0, 10)
        self.passo = 0

    def mover(self):
        self.ciclos += 1
        if self.ciclos >= self.delay:
            if self.direcao == ACIMA:
                self.intencao_linha -= 1
            elif self.direcao == ABAIXO:
                self.intencao_linha += 1
            elif self.direcao == DIREITA:
                self.intencao_coluna += 1
            elif self.direcao == ESQUERDA:
                self.intencao_coluna -= 1
            self.passo += 1
            if self.passo >= self.distancia:
                self.escolher_direcao()
            self.ciclos = 0

    def desenhar(self, tela, tamanho):
        px = self.coluna * tamanho
        py = self.linha * tamanho
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
inky = Fantasma(VERMELHO)
pinky = Fantasma(ROSA)
blinky = Fantasma(AZUL)
pacman = Pacman()
cenario = Cenario(pacman)

while True:
    # Calcular Regras
    cenario.calcular_regras()
    pinky.mover()
    inky.mover()
    blinky.mover()
    clyde.mover()
    cenario.aprovar_movimento(pinky)
    cenario.aprovar_movimento(inky)
    cenario.aprovar_movimento(blinky)
    cenario.aprovar_movimento(clyde)

    # clyde.fantasma_coluna += random() - 0.4

    # Desenha tela
    screen.fill(PRETO)
    cenario.desenhar(screen, tamanho)
    pacman.desenhar(screen, tamanho)
    clyde.desenhar(screen, tamanho)
    pinky.desenhar(screen, tamanho)
    inky.desenhar(screen, tamanho)
    blinky.desenhar(screen, tamanho)
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
