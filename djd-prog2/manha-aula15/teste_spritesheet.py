import pygame

tela = pygame.display.set_mode((800, 600), 0)
PRETO = (0, 0, 0)


class Heroi(pygame.sprite.Sprite):
    def __init__(self):
        pygame.sprite.Sprite.__init__(self)
        self.spritesheet = pygame.image.load("EpicArmor.png").convert_alpha()
        self.width = 64
        self.height = 64
        self.colunas = 9
        self.animacao = [28, 29, 30, 31, 32, 33, 34]
        self.image = pygame.Surface((self.width, self.height), 0)
        self.frame_index = 0
        self.gId = self.animacao[self.frame_index]
        self.rect = pygame.Rect((100, 100), (self.width, self.height))

    def update(self):
        self.gId = self.animacao[self.frame_index]
        col = self.gId % self.colunas
        lin = self.gId // self.colunas
        x = col * self.width
        y = lin * self.height
        self.frame_index += 1
        if self.frame_index >= len(self.animacao):
            self.frame_index = 0
        self.image = self.spritesheet.subsurface(x, y, self.width, self.height)

    def processar_eventos(self, eventos):
        for e in eventos:
            if e.type == pygame.KEYDOWN:
                if e.key == pygame.K_RIGHT:
                    self.rect.move_ip(2, 0)
                if e.key == pygame.K_LEFT:
                    self.rect.move_ip(-2, 0)


h1 = Heroi()
grp_herois = pygame.sprite.Group()
grp_herois.add(h1)

while True:
    # calcular regras
    grp_herois.update()

    # pintar
    tela.fill(PRETO)
    grp_herois.draw(tela)
    pygame.display.update()

    pygame.time.delay(120)

    # capturar eventos
    eventos = pygame.event.get()
    h1.processar_eventos(eventos)
    for e in eventos:
        if e.type == pygame.QUIT:
            exit()