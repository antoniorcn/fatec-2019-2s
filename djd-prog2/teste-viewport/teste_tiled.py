import pygame
from pytmx import load_pygame

pygame.init()
screen = pygame.display.set_mode((800, 600), 0)


class Heroi(pygame.sprite.Sprite):
    def __init__(self):
        self.estado = "PARADO_DIREITA"
        pygame.sprite.Sprite.__init__(self)
        self.spritesheet = pygame.image.load("EpicArmor.png").convert_alpha()
        self.width = 64
        self.height = 64
        self.colunas = 9
        self.animacoes = {
            "PARADO_DIREITA": [27],
            "CAMINHANDO_DIREITA": [28, 29, 30, 31, 32, 33, 34],
            "PARADO_ESQUERDA": [9],
            "CAMINHANDO_ESQUERDA": [10, 11, 12, 13, 14, 15, 16, 17],
            "PARADO_CIMA": [0],
            "CAMINHANDO_CIMA": [1, 2, 3, 4, 5, 6, 7, 8],
            "PARADO_BAIXO": [18],
            "CAMINHANDO_BAIXO": [19, 20, 21, 22, 23, 24, 25, 26],
            "VOLTINHA": [27, 18, 9, 0, 9, 18, 27]
        }
        self.image = pygame.Surface((self.width, self.height), 0)
        self.frame_index = 0
        self.gId = 0
        self.rect = pygame.Rect((0, 0), (self.width, self.height))
        self.vel_x = 0
        self.vel_y = 0

    def update(self):
        self.rect.move_ip(self.vel_x, self.vel_y)
        movimentos = self.animacoes[self.estado]
        self.frame_index += 1
        if self.frame_index >= len(movimentos):
            self.frame_index = 0
        self.gId = movimentos[self.frame_index]
        col = self.gId % self.colunas
        lin = self.gId // self.colunas
        x = col * self.width
        y = lin * self.height
        self.image = self.spritesheet.subsurface(x, y, self.width, self.height)

    def processar_eventos(self, eventos):
        for e in eventos:
            if e.type == pygame.KEYDOWN:
                if e.key == pygame.K_RIGHT:
                    self.vel_x = 1
                    self.estado = "CAMINHANDO_DIREITA"
                elif e.key == pygame.K_LEFT:
                    self.vel_x = -1
                    self.estado = "CAMINHANDO_ESQUERDA"
                elif e.key == pygame.K_UP:
                    self.vel_y = -1
                    self.estado = "CAMINHANDO_CIMA"
                elif e.key == pygame.K_DOWN:
                    self.vel_y = 1
                    self.estado = "CAMINHANDO_BAIXO"
                elif e.key == pygame.K_SPACE:
                    self.estado = "VOLTINHA"
            elif e.type == pygame.KEYUP:
                if e.key == pygame.K_RIGHT:
                    self.vel_x = 0
                    self.estado = "PARADO_DIREITA"
                elif e.key == pygame.K_LEFT:
                    self.vel_x = 0
                    self.estado = "PARADO_ESQUERDA"
                elif e.key == pygame.K_UP:
                    self.vel_y = 0
                    self.estado = "PARADO_CIMA"
                elif e.key == pygame.K_DOWN:
                    self.vel_y = 0
                    self.estado = "PARADO_BAIXO"


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


h1 = Heroi()
grp_herois = pygame.sprite.Group()
grp_herois.add(h1)
tmxdata = load_pygame("mapa2.tmx")
cam = Camera((0, 0), (800, 600))
while True:
    # Calcular regras
    grp_herois.update()
    cam.move(h1.rect.center)

    # Desenhar
    screen.fill((0, 0, 0))
    cam.draw_tiles(screen, tmxdata)
    cam.draw_group(screen, grp_herois)
    pygame.display.update()

    # Capturar eventos
    eventos = pygame.event.get()
    h1.processar_eventos(eventos)
    for e in eventos:
        if e.type == pygame.QUIT:
            exit()