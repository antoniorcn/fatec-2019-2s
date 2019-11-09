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

    def autorizar_movimento(self):
        self.coluna = self.coluna_intencao
        self.linha = self.linha_intencao

    def negar_movimento(self):
        self.coluna_intencao = self.coluna
        self.linha_intencao = self.linha

    def calcular_regras(self):
        pass

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
        print("Matrix Linhas:{}  Colunas: {}".format(len(self.cenario), len(self.cenario[0])))

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


class Fantasma:
    ACIMA = 0
    ABAIXO = 2
    ESQUERDA = 3
    DIREITA = 1
    def __init__(self, tamanho, imagem):
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
        self.img = pygame.transform.scale(imagem_fantasma, (self.tamanho, self.tamanho))
        # imagem_fantasma_rot = pygame.transform.rotate(imagem_fantasma, 45)
        #self.img = pygame.transform.scale(imagem_fantasma_rot, (self.tamanho, self.tamanho))

    def pintar(self, tela):
        px = self.coluna * self.tamanho
        py = self.linha * self.tamanho
        tela.blit(self.img, (px, py))

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

    def calcular_regras(self):
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

    def calcular_regras(self):
        for objeto in self.lista_objetos:
            objeto.calcular_regras()


p = Pacman(20, AMARELO)
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

jogo = Jogo()
jogo.adicionar(cen)
jogo.adicionar(p)
jogo.adicionar(blinky)
jogo.adicionar(inky)
jogo.adicionar(clyde)
jogo.adicionar(pinky)

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
    jogo.calcular_regras()

    # Pintar
    tela.fill(PRETO)
    jogo.pintar(tela)
    pygame.display.update()

    # pygame.time.delay(1000 // FPS)
    # print(pygame.time.get_ticks())
    # contador += 1
    clk.tick(FPS)
    # segundos = pygame.time.get_ticks() / 1000
    # if int(segundos) % 2 == 0:
    #    print(int(segundos))
    # if contador * FPS > 1000:
    #    print("Passou 1 segundo")
    #    contador = 0


    # Captura Eventos
    eventos = pygame.event.get()
    p.processar_eventos(eventos)
    cen.processar_eventos(eventos)

