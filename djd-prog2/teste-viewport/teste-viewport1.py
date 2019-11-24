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

VELOCIDADE_CAMERA = 5

class Camera:
    def __init__(self, position, tamanho):
        self.window = pygame.Rect(position, tamanho)
        self.position = position
        self.offset_x = 0
        self.offset_y = 0

    def in_viewport(self, r):
        return self.window.colliderect(r)

    def move(self, pos):
        self.window.center = pos
        self.offset_x = self.window.x
        self.offset_y = self.window.y

    def draw_group(self, tela, group):
        for s in group:
            if self.in_viewport(s.rect):
                tela.blit(s.image, (self.position[0] + s.rect.x - self.offset_x, self.position[1] + s.rect.y - self.offset_y))
                # print('Offset:(', self.offset_x, ',', self.offset_y, ')', '\tPos:( ', s.rect.x, ',', s.rect.y, ')')

    def draw_tiles(self, tela, tmx_data):
        # Calcula quais colunas dos tiles serão processadas
        start_col = self.window.x // tmx_data.tilewidth
        end_col = (self.window.x + self.window.width) // tmx_data.tilewidth + 1
        start_row = self.window.y // tmx_data.tileheight
        end_row = (self.window.y + self.window.height) // tmx_data.tileheight + 1
        # print('Offset(', self.offset_x, ',', self.offset_y, ')', '\tLinhas: ', start_row,
        #      ' - ', end_row, '\tColunas: ', start_col, ' - ', end_col)
        start_col = min(max(start_col, 0), tmx_data.width)
        start_row = min(max(start_row, 0), tmx_data.height)
        end_col = min(max(end_col, 0), tmx_data.width)
        end_row = min(max(end_row, 0), tmx_data.height)

        for linha in range(start_row, end_row):
            for coluna in range(start_col, end_col):
                image = tmx_data.get_tile_image(coluna, linha, 0)
                x = coluna * tmx_data.tilewidth
                y = linha * tmx_data.tileheight
                r = pygame.Rect((x, y), (tmx_data.tilewidth, tmx_data.tileheight))
                if self.in_viewport(r):
                    tela.blit(image, (self.position[0] + r.x - self.offset_x, self.position[1] + r.y - self.offset_y))

    def draw_cenario(self, tela, cenario):
        # Calcula quais colunas dos tiles serão processadas
        start_col = self.window.x // tamanho
        end_col = (self.window.x + self.window.width) // tamanho + 1
        start_row = self.window.y // tamanho
        end_row = (self.window.y + self.window.height) // tamanho + 1
        start_col = min(max(start_col, 0), len(cenario.cenario[0]))
        start_row = min(max(start_row, 0), len(cenario.cenario))
        end_col = min(max(end_col, 0), len(cenario.cenario[0]))
        end_row = min(max(end_row, 0), len(cenario.cenario))
        print(start_row, start_col, end_row, end_col)
        for linha in range(start_row, end_row):
            for coluna in range(start_col, end_col):
                image = cenario.get_image(linha, coluna)
                x = coluna * tamanho
                y = linha * tamanho
                r = pygame.Rect((x, y), (tamanho, tamanho))
                if self.in_viewport(r):
                    tela.blit(image, (self.position[0] + r.x - self.offset_x, self.position[1] + r.y - self.offset_y))



class Cenario:
    def __init__(self):
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

    def get_image(self, lin, col):
        coluna_conteudo = self.cenario[lin][col]
        img = pygame.Surface((tamanho, tamanho), 0)
        cor = PRETO
        if coluna_conteudo == 2:
            cor = AZUL
        r = pygame.Rect((0, 0), (tamanho, tamanho))
        pygame.draw.rect(img, cor, r, 0)
        if coluna_conteudo == 1:
            ponto_x = int(tamanho / 2)
            ponto_y = int(tamanho / 2)
            ponto_raio = int(tamanho / 10)
            pygame.draw.circle(img, AMARELO, (ponto_x, ponto_y), ponto_raio, 0)
        return img

    def desenhar(self, tela):
        for linha, linha_conteudo in enumerate(self.cenario):
            for coluna, coluna_conteudo in enumerate(linha_conteudo):
                x = (coluna * tamanho)
                y = (linha * tamanho)
                tela.blit(self.get_image(linha, coluna), (x, y))


class Fantasma(pygame.sprite.Sprite):
    def __init__(self, image_file, linha=14, coluna=13):
        pygame.sprite.Sprite.__init__(self)
        tmp_img = pygame.image.load(image_file).convert_alpha()
        self.image = pygame.transform.scale(tmp_img, (tamanho, tamanho))
        self.rect = pygame.Rect((coluna * tamanho, linha * tamanho), (tamanho, tamanho))
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


clyde = Fantasma("clyde.png")
inky = Fantasma("inky.png", 14, 14)
pinky = Fantasma("pinky.png", 14, 15)
blinky = Fantasma("blinky.png", 14, 16)

cam = Camera((0, 0), (800, 600))
cenario = Cenario()
group = pygame.sprite.Group()
group.add(clyde)
group.add(inky)
group.add(pinky)
group.add(blinky)
velx = 0
vely = 0
while True:
    # Calcular Regras
    x = cam.window.center[0] + velx
    y = cam.window.center[1] + vely
    cam.move((x, y))

    # Desenha tela
    screen.fill(PRETO)
    cam.draw_cenario(screen, cenario)
    cam.draw_group(screen, group)
    pygame.display.update()

    # Captura eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
        if e.type == pygame.KEYDOWN:
            if e.key == pygame.K_RIGHT:
                velx = -VELOCIDADE_CAMERA
            if e.key == pygame.K_LEFT:
                velx = VELOCIDADE_CAMERA
            if e.key == pygame.K_UP:
                vely = VELOCIDADE_CAMERA
            if e.key == pygame.K_DOWN:
                vely = -VELOCIDADE_CAMERA
        if e.type == pygame.KEYUP:
            if e.key == pygame.K_RIGHT:
                velx = 0
            if e.key == pygame.K_LEFT:
                velx = 0
            if e.key == pygame.K_UP:
                vely = 0
            if e.key == pygame.K_DOWN:
                vely = 0
