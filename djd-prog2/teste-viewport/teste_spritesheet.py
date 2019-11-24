import pygame

tela = pygame.display.set_mode((800, 600), 0)
PRETO = (0, 0, 0)


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
        self.rect = pygame.Rect((100, 100), (self.width, self.height))
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



h1 = Heroi()
h2 = Heroi()
h2.rect.move_ip(200, 200)
grp_herois = pygame.sprite.Group()
grp_herois.add(h1)
grp_herois.add(h2)

while True:
    # calcular regras
    grp_herois.update()

    # pintar
    tela.fill(PRETO)
    grp_herois.draw(tela)
    pygame.display.update()

    pygame.time.delay(100)

    # capturar eventos
    eventos = pygame.event.get()
    h1.processar_eventos(eventos)
    for e in eventos:
        if e.type == pygame.QUIT:
            exit()