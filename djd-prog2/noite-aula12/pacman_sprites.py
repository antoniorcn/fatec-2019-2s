import pygame
from random import randint

PRETO = (0, 0, 0)
AMARELO = (255, 255, 0)
VERMELHO = (255, 0, 0)
AZUL = (0, 0, 255)
tela = pygame.display.set_mode((800, 600), 0)


class Pacman(pygame.sprite.Sprite):
    def __init__(self, tamanho, c):
        pygame.sprite.Sprite.__init__(self)
        self.tamanho = tamanho
        self.cor = c
        self.raio = self.tamanho // 2
        self.abertura_boca = 1
        self.coluna = 1
        self.linha = 1
        self.coluna_intencao = self.coluna
        self.linha_intencao = self.linha
        self.image = pygame.Surface((tamanho, tamanho), 0)
        self.rect = pygame.Rect((0, 0), (tamanho, tamanho))
        self.criar_imagem()

    def criar_imagem(self):
        # px = self.coluna * self.tamanho + self.raio
        # py = self.linha * self.tamanho + self.raio
        px = self.tamanho // 2
        py = self.tamanho // 2
        centro = (px, py)
        labio_superior = (px + self.raio, py - self.abertura_boca)
        labio_inferior = (px + self.raio, py + self.abertura_boca)
        pygame.draw.circle(self.image, self.cor, (px, py), self.raio, 0)
        lista = [centro, labio_superior, labio_inferior]
        pygame.draw.polygon(self.image, PRETO, lista, 0)

        olho_x = px + self.raio // 5
        olho_y = py - self.raio // 2
        pygame.draw.circle(self.image, PRETO, (olho_x, olho_y),
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

    def autorizar_movimento(self):
        self.coluna = self.coluna_intencao
        self.linha = self.linha_intencao

    def negar_movimento(self):
        self.coluna_intencao = self.coluna
        self.linha_intencao = self.linha

    def update(self):
        self.rect.x = self.coluna * self.tamanho
        self.rect.y = self.linha * self.tamanho
        self.abertura_boca += 1
        if self.abertura_boca > self.raio:
            self.abertura_boca = 0
        self.criar_imagem()

class Cenario:
    def __init__(self, tamanho, pac):
        self.tamanho = tamanho
        self.pacman = pac
        self.personagens = []
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

    def pintar(self, tela):
        raio = self.tamanho // 2
        for lin_idx in range(len(self.cenario)):
            for col_idx in range(len(self.cenario[0])):
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
        for persona in self.personagens:
            if 0 < persona.coluna_intencao < len(self.cenario[0]) and \
                    0 < persona.linha_intencao < len(self.cenario) and \
                    self.cenario[persona.linha_intencao][persona.coluna_intencao] != 2:
                persona.autorizar_movimento()
            else:
                persona.negar_movimento()

            if self.cenario[self.pacman.linha][self.pacman.coluna] == 1:
                self.cenario[self.pacman.linha][self.pacman.coluna] = 0


class Fantasma(pygame.sprite.Sprite):
    ACIMA = 0
    ABAIXO = 2
    ESQUERDA = 3
    DIREITA = 1

    def __init__(self, tamanho, imagem):
        pygame.sprite.Sprite.__init__(self)
        self.coluna = 5
        self.linha = 4
        self.tamanho = tamanho
        self.coluna = 12
        self.linha = 14
        self.coluna_intencao = self.coluna
        self.linha_intencao = self.linha
        self.direcao = self.ACIMA
        self.distancia = 10
        self.percorrido = 0
        self.lerdeza = 5
        self.contador_lerdeza = 0
        imagem_fantasma = pygame.image.load(imagem)
        self.image = pygame.transform.scale(imagem_fantasma, (self.tamanho, self.tamanho))
        self.rect = pygame.Rect((0, 0), (tamanho, tamanho))

    def escolher_destino(self):
        self.direcao = randint(0, 3)
        self.distancia = randint(0, 10)
        self.percorrido = 0

    def autorizar_movimento(self):
        self.coluna = self.coluna_intencao
        self.linha = self.linha_intencao

    def negar_movimento(self):
        self.coluna_intencao = self.coluna
        self.linha_intencao = self.linha
        self.escolher_destino()

    def update(self):
        self.rect.x = self.coluna * self.tamanho
        self.rect.y = self.linha * self.tamanho
        self.contador_lerdeza += 1
        if self.contador_lerdeza >= self.lerdeza:
            if self.direcao == self.ACIMA:
                self.linha_intencao -= 1
            elif self.direcao == self.DIREITA:
                self.coluna_intencao += 1
            elif self.direcao == self.ABAIXO:
                self.linha_intencao += 1
            else:
                self.coluna_intencao -= 1
            self.percorrido += 1
            if self.percorrido >= self.distancia:
                self.escolher_destino()
            self.contador_lerdeza = 0


grupo_pac = pygame.sprite.Group()
p = Pacman(20, AMARELO)

p.add(grupo_pac)

cen = Cenario(20, p)
blinky = Fantasma(20, "./blinky.png")
blinky.lerdeza = 2
inky = Fantasma(20, "./inky.png")
inky.coluna_intencao = 13
inky.lerdeza = 5
clyde = Fantasma(20, "./clyde.png")
clyde.lerdeza = 1
clyde.coluna_intencao = 14
pinky = Fantasma(20, "./pinky.png")
pinky.coluna_intencao = 15
pinky.lerdeza = 3
cen.personagens.append(blinky)
cen.personagens.append(inky)
cen.personagens.append(clyde)
cen.personagens.append(pinky)
cen.personagens.append(p)

grupo_fantasmas = pygame.sprite.Group()
grupo_fantasmas.add(clyde)
grupo_fantasmas.add(pinky)
grupo_fantasmas.add(inky)
grupo_fantasmas.add(blinky)

FPS = 30
# pinky = Fantasma(20, "./pinky.png")
# red = Fantasma(20, "./red.png")

# p2 = Pacman(60, VERMELHO)
# p2.coluna = 5
# contador = 0
clk = pygame.time.Clock()
while True:
    # Calcular Regras
    cen.calcular_regras()
    grupo_fantasmas.update()
    grupo_pac.update()

    pygame.sprite.spritecollide(p, grupo_fantasmas, True)

    # Pintar
    tela.fill(PRETO)
    cen.pintar(tela)
    grupo_fantasmas.draw(tela)
    grupo_pac.draw(tela)
    pygame.display.update()

    clk.tick(FPS)

    # Captura Eventos
    eventos = pygame.event.get()
    p.processar_eventos(eventos)
    cen.processar_eventos(eventos)

