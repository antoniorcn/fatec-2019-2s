import pygame
from random import randint

PRETO = (0, 0, 0)
AMARELO = (255, 255, 0)
VERMELHO = (255, 0, 0)
AZUL = (0, 0, 255)
tela = pygame.display.set_mode((800, 600), 0)


class Pacman:
    def __init__(self, tamanho, c):
        self.tamanho = tamanho
        self.cor = c
        self.raio = self.tamanho // 2
        self.abertura_boca = 1
        self.coluna = 1
        self.linha = 1
        self.coluna_intencao = self.coluna
        self.linha_intencao = self.linha

    def pintar(self, tela):
        px = self.coluna * self.tamanho + self.raio
        py = self.linha * self.tamanho + self.raio
        centro = (px, py)
        labio_superior = (px + self.raio, py - self.raio)
        labio_inferior = (px + self.raio, py + self.raio)
        pygame.draw.circle(tela, self.cor, (px, py), self.raio, 0)
        lista = [centro, labio_superior, labio_inferior]
        pygame.draw.polygon(tela, PRETO, lista, 0)

        olho_x = px + self.raio // 5
        olho_y = py - self.raio // 2
        pygame.draw.circle(tela, PRETO, (olho_x, olho_y),
                           self.raio // 5, 0)

    def processar_eventos(self, eventos):
        for e in eventos:
            if e.type == pygame.KEYDOWN:
                if e.key == pygame.K_RIGHT:
                    self.coluna_intencao += 1
                elif e.key == pygame.K_LEFT:
                    self.coluna_intencao -= 1
                elif e.key == pygame.K_DOWN:
                    self.linha_intencao += 1
                elif e.key == pygame.K_UP:
                    self.linha_intencao -= 1


class Cenario:
    def __init__(self, tamanho, pac):
        self.tamanho = tamanho
        self.pacman = pac
        self.cenario = [
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

    def pintar(self, tela):
        raio = self.tamanho // 2
        for lin_idx in range(0, 16):
            for col_idx in range(0, 16):
                cor = PRETO
                if self.cenario[lin_idx][col_idx] == 2:
                    cor = AZUL
                # tela.set_at((col_idx, lin_idx), cor)
                x = col_idx * self.tamanho
                y = lin_idx * self.tamanho
                pygame.draw.rect(tela, cor, ((x, y), (self.tamanho, self.tamanho)), 0)
                # print(cenario[lin_idx][col_idx], " ", end="")
                if self.cenario[lin_idx][col_idx] == 1:
                    pygame.draw.circle(tela, AMARELO, (x + raio, y + raio), raio // 5, 0)

    def processar_eventos(self, eventos):
        for e in eventos:
            if e.type == pygame.QUIT:
                exit()

    def calcular_regras(self):
        # Calcular Regras
        if 0 < self.pacman.coluna_intencao < 16 and 0 < self.pacman.linha_intencao < 16 and \
                self.cenario[self.pacman.linha_intencao][self.pacman.coluna_intencao] != 2:
            self.pacman.coluna = self.pacman.coluna_intencao
            self.pacman.linha = self.pacman.linha_intencao
        else:
            self.pacman.coluna_intencao = self.pacman.coluna
            self.pacman.linha_intencao = self.pacman.linha

        if self.cenario[self.pacman.linha][self.pacman.coluna] == 1:
            self.cenario[self.pacman.linha][self.pacman.coluna] = 0


class Fantasma:
    def __init__(self, tamanho, imagem):
        self.coluna = 5
        self.linha = 4
        self.tamanho = tamanho
        imagem_fantasma = pygame.image.load(imagem)
        self.img = pygame.transform.scale(imagem_fantasma, (self.tamanho, self.tamanho))
        # imagem_fantasma_rot = pygame.transform.rotate(imagem_fantasma, 45)
        #self.img = pygame.transform.scale(imagem_fantasma_rot, (self.tamanho, self.tamanho))

    def pintar(self, tela):
        px = self.coluna * self.tamanho
        py = self.linha * self.tamanho
        tela.blit(self.img, (px, py))


class Jogo:
    def __init__(self):
        self.lista_objetos = []

    def adicionar(self, obj):
        self.lista_objetos.append(obj)

    def remover(self, obj):
        self.lista_objetos.remove(obj)

    def pintar(self, tela):
        for obj in self.lista_objetos:
            obj.pintar(tela)


p = Pacman(20, AMARELO)
cen = Cenario(20, p)
blink = Fantasma(20, "./blinky.png")
inky = Fantasma(20, "./inky.png")
inky.coluna = 8
inky.linha = 7

jogo = Jogo()
jogo.adicionar(cen)
jogo.adicionar(p)
jogo.adicionar(blink)
jogo.adicionar(inky)
# pinky = Fantasma(20, "./pinky.png")
# red = Fantasma(20, "./red.png")

# p2 = Pacman(60, VERMELHO)
# p2.coluna = 5
while True:
    # Calcular Regras
    cen.calcular_regras()

    # Pintar
    tela.fill(PRETO)
    jogo.pintar(tela)
    pygame.display.update()

    # Captura Eventos
    eventos = pygame.event.get()
    p.processar_eventos(eventos)
    cen.processar_eventos(eventos)

