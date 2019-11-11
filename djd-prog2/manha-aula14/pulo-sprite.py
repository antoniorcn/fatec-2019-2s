import pygame
import random


class Personagem(pygame.sprite.Sprite):
    def __init__(self):
        pygame.sprite.Sprite.__init__(self)
        img = pygame.image.load("capitao_nasc.png").convert_alpha()
        size = (122, 297)
        self.hp = 100
        self.y_vel = 0
        self.x_vel = 0
        self.image = pygame.transform.scale(img, size)
        self.rect = pygame.Rect((0, 0), size)

    def update(self, *args):
        self.y_vel += args[0]
        self.rect.y += (self.y_vel / args[1])
        self.rect.x += self.x_vel

    def processa_eventos(self, eventos):
        global tiros
        for e in eventos:
            if e.type == pygame.KEYDOWN:
                if e.key == pygame.K_SPACE:
                    self.y_vel = -300
                if e.key == pygame.K_RETURN:
                    tiro = Tiro()
                    tiro.rect.topleft = self.rect.midright
                    tiros.add(tiro)
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
        self.rect = pygame.Rect((0, 0), size)
        self.rect.y = 500


class Inimigo(pygame.sprite.Sprite):
    def __init__(self):
        pygame.sprite.Sprite.__init__(self)
        img = pygame.image.load("coelho.png").convert_alpha()
        size = (51, 110)
        self.y_vel = 0
        self.x_vel = 0
        self.atualizar = 5
        self.atualizar_count = 0
        self.image = pygame.transform.scale(img, size)
        self.rect = pygame.Rect((0, 0), size)

    def update(self, *args):
        self.atualizar_count += 1
        if self.atualizar_count >= self.atualizar:
            self.y_vel += args[0]
            self.rect.y += (self.y_vel / args[1])
            self.rect.x += self.x_vel
            self.atualizar_count = 0


class Tiro(pygame.sprite.Sprite):
    def __init__(self):
        pygame.sprite.Sprite.__init__(self)
        img = pygame.image.load("projetil.png").convert_alpha()
        size = (32, 14)
        img_scaled = pygame.transform.scale(img, size)
        self.image = pygame.transform.flip(img_scaled, True, False)
        self.rect = pygame.Rect((0, 0), size)
        self.x_vel = 20

    def update(self, *args):
        self.rect.x += self.x_vel


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

inimigos = pygame.sprite.Group()

tiros = pygame.sprite.Group()

def criar_coelho():
    inimigo = Inimigo()
    inimigo.rect.x = random.randint(400, 800)
    inimigo.rect.y = random.randint(-200, 0)
    inimigos.add(inimigo)

criar_coelho()
criar_coelho()

while True:
    # Calcular Regras
    herois.update(gravidade, fator)
    inimigos.update(gravidade, fator)
    tiros.update(gravidade, fator)
    barra_x = 200 * capitao.hp / 100

    if pygame.sprite.spritecollide(capitao, plataformas, False):
        capitao.y_vel = 0
        # for p in plataformas:
        #    if pygame.sprite.collide_mask(capitao, p):
        #        capitao.y_vel = 0

    if pygame.sprite.groupcollide(inimigos, plataformas, True, False):
        capitao.hp -= 1
        criar_coelho()

    if pygame.sprite.groupcollide(tiros, inimigos, True, True):
        capitao.hp += 1
        criar_coelho()

    for t in tiros:
        if t.rect.x > 800:
            t.kill()

    # Desenhar
    tela.fill(PRETO)
    herois.draw(tela)
    tiros.draw(tela)
    plataformas.draw(tela)
    pygame.draw.rect(tela, VERMELHO, piso.rect, 5)
    inimigos.draw(tela)
    pygame.draw.rect(tela, VERMELHO, pygame.Rect((20, 20), (barra_x, 20)), 0)
    pygame.draw.rect(tela, AMARELO, pygame.Rect((20, 20), (200, 20)), 5)
    pygame.display.update()

    pygame.time.delay(10)

    # Eventos
    eventos = pygame.event.get()
    capitao.processa_eventos(eventos)
    for e in eventos:
        if e.type == pygame.QUIT:
            exit()
