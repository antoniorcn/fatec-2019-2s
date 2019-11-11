import pygame


class Personagem(pygame.sprite.Sprite):
    def __init__(self):
        pygame.sprite.Sprite.__init__(self)
        img = pygame.image.load("capitao_nasc.png").convert_alpha()
        size = (122, 297)
        self.y_vel = 0
        self.x_vel = 0
        self.image = pygame.transform.scale(img, size)
        self.rect = pygame.Rect((0, 0), size)

    def update(self, *args):
        capitao.y_vel += args[0]
        capitao.rect.y += (capitao.y_vel / args[1])
        capitao.rect.x += self.x_vel

    def processa_eventos(self, eventos):
        for e in eventos:
            if e.type == pygame.KEYDOWN:
                if e.key == pygame.K_SPACE:
                    self.y_vel = -300
                elif e.key == pygame.K_RIGHT:
                    self.x_vel = 5
                elif e.key == pygame.K_LEFT:
                    self.x_vel = -5


class Piso(pygame.sprite.Sprite):
    def __init__(self):
        pygame.sprite.Sprite.__init__(self)
        img = pygame.image.load("piso.png").convert_alpha()
        size = (800, 131)
        self.image = pygame.transform.scale(img, size)
        self.rect = img.get_rect()
        self.rect.y = 500


PRETO = (0, 0, 0)
AMARELO = (255, 255, 0)
VERMELHO = (255, 0, 0)
pygame.init()
tela = pygame.display.set_mode((800, 600), 0)
fator = 10.0
gravidade = 9.8


capitao = Personagem()
piso = Piso()

herois = pygame.sprite.Group()
herois.add(capitao)

plataformas = pygame.sprite.Group()
plataformas.add(piso)


while True:
    # Calcular Regras
    herois.update(gravidade, fator)

    if pygame.sprite.spritecollide(capitao, plataformas, False):
        capitao.y_vel = 0
        # for p in plataformas:
        #    if pygame.sprite.collide_mask(capitao, p):
        #        capitao.y_vel = 0

    # Desenhar
    tela.fill(PRETO)
    herois.draw(tela)
    plataformas.draw(tela)
    pygame.display.update()

    pygame.time.delay(50)

    # Eventos
    eventos = pygame.event.get()
    capitao.processa_eventos(eventos)
    for e in eventos:
        if e.type == pygame.QUIT:
            exit()
