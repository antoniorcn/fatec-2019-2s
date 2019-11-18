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
tamanho = int(600 / 30) * 2

font_big = pygame.font.SysFont("arial", 48, True, False)
font_small = pygame.font.SysFont("arial", 18, True, False)


class Camera:
    def __init__(self, tamanho):
        self.window = pygame.Rect((0, 0), (800, 600))
        self.offset_x = 0
        self.offset_y = 0
        self.w_blocks = 800 // tamanho
        self.h_blocks = 600 // tamanho
        self.map_window = pygame.Rect((0, 0), (self.w_blocks, self.h_blocks))

    def in_viewport(self, r):
        return self.window.colliderect(r)

    def draw(self, tela, group):
        for s in group:
            if self.in_viewport(s.rect):
                tela.blit(s.image, (s.rect.x + self.offset_x, s.rect.y + self.offset_y))


class Cenario:
    def __init__(self, camera):
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
        self.camera = camera

    def desenhar(self, tela):
        for linha, linha_conteudo in enumerate(self.cenario):
            for coluna, coluna_conteudo in enumerate(linha_conteudo):
                x = (coluna * tamanho) + self.camera.offset_x
                y = (linha * tamanho) + self.camera.offset_y
                r = pygame.Rect(x, y, tamanho, tamanho)
                if self.camera.in_viewport(r):
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
                else:
                    print(linha, coluna)


class Fantasma(pygame.sprite.Sprite):
    def __init__(self, image_file, linha=14, coluna=13):
        pygame.sprite.Sprite.__init__(self)
        self.image = pygame.image.load(image_file).convert_alpha()
        self.rect = pygame.Rect((0, 0), (tamanho, tamanho))
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


clyde = Fantasma("clyde.png")
inky = Fantasma("inky.png")
pinky = Fantasma("pinky.png")
blinky = Fantasma("blinky.png")

cam = Camera(tamanho)
cenario = Cenario(cam)

group = pygame.sprite.Group()
group.add(clyde)
group.add(inky)
group.add(pinky)
group.add(blinky)

while True:
    # Calcular Regras
    #pinky.mover()
    #inky.mover()
    #blinky.mover()
    #clyde.mover()

    # Desenha tela
    screen.fill(PRETO)
    cam.draw(screen, group)
    cenario.desenhar(screen)
    #pacman.desenhar(screen, tamanho)
    #clyde.desenhar(screen, tamanho)
    #pinky.desenhar(screen, tamanho)
    #inky.desenhar(screen, tamanho)
    #blinky.desenhar(screen, tamanho)
    pygame.display.update()

    # Captura eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
        if e.type == pygame.KEYDOWN:
            if e.key == pygame.K_RIGHT:
                cam.offset_x -= 10
            if e.key == pygame.K_LEFT:
                cam.offset_x += 10
            if e.key == pygame.K_UP:
                cam.offset_y -= 10
            if e.key == pygame.K_DOWN:
                cam.offset_y += 10
