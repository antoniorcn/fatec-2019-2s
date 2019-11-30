from math import cos, pi, sin
from random import randint
import pygame

tela = pygame.display.set_mode((800, 600), 0)
PRETO = (0, 0, 0)


def get_frame_by_gid(spritesheet, gid):
    colunas = spritesheet["rect"].w // spritesheet["w"]
    col = gid % colunas
    lin = gid // colunas
    x = col * (spritesheet["w"] + spritesheet["gap_x"])
    y = lin * (spritesheet["h"] + spritesheet["gap_y"])
    return spritesheet["image"].subsurface(x, y, spritesheet["w"], spritesheet["h"])


class RotateList:
    def __init__(self, elementos=None, loop=False, delay=1):
        self.lista = list(elementos)
        self.rotate_index = 0
        self.rotate_loop = loop
        self.rotate_delay = delay
        self.rotate_delay_count = 0

    def append(self, elemento):
        self.lista.append(elemento)

    def update(self):
        self.rotate_delay_count += 1
        if self.rotate_delay_count > self.rotate_delay:
            self.rotate_delay_count = 0
            self.rotate_index += 1
            if self.rotate_index >= len(self.lista):
                if self.rotate_loop:
                    self.rotate_index = 0
                else:
                    self.rotate_index = len(self.lista) - 1
        return self.lista[self.rotate_index]


class MoveBehavior:
    def __init__(self, initial_position=(0, 0), velocity=1):
        self.position = initial_position
        self.velocity = velocity
        self.finished = False

    def move(self, pos):
        self.position = pos

    def set_velocity(self, vel):
        self.velocity = vel

    def is_finished(self):
        return self.finished

    def next_position(self):
        self.position = (self.position[0] + self.velocity, self.position[1] + self.velocity)
        return self.position

    def get_angle(self):
        return 0


class LinearXMoveBehavior(MoveBehavior):
    def __init__(self, initial_position=(0, 0), velocity=1):
        MoveBehavior.__init__(self, initial_position, velocity)

    def next_position(self):
        self.position = (self.position[0] + self.velocity, self.position[1])
        return self.position


class LinearYMoveBehavior(MoveBehavior):
    def __init__(self, initial_position=(0, 0), velocity = 1):
        MoveBehavior.__init__(self, initial_position, velocity)

    def next_position(self):
        self.position = (self.position[0], self.position[1] + self.velocity)
        return self.position


class DestinyMoveBehavior(MoveBehavior):
    def __init__(self, initial_position=(0, 0), final_position=(50, 50), velocity=1):
        MoveBehavior.__init__(self, initial_position, velocity)
        self.final_position = final_position
        self.finished_x = False
        self.finished_y = False

    def next_position(self):
        x, y = self.position
        if self.final_position[0] != self.position[0]:
            x_gap = self.final_position[0] - self.position[0]
            x_gap /= abs(x_gap) * self.velocity
            x = self.position[0] + x_gap
            self.finished_x = False
        else:
            self.finished_x = True
        if self.final_position[1] != self.position[1]:
            y_gap = self.final_position[1] - self.position[1]
            y_gap /= abs(y_gap) * self.velocity
            y = self.position[1] + y_gap
            self.finished_y = False
        else:
            self.finished_y = True
        self.position = (x, y)
        return self.position

    def is_finished(self):
        return self.finished_x and self.finished_y


class RadialMoveBehavior(MoveBehavior):
    def __init__(self, radius=50, velocity=1.0, initial_position=(0, 0), start_angle=1, finish_angle=359):
        MoveBehavior.__init__(self, initial_position, velocity)
        self.finished = False
        self.position = initial_position
        self.radius = radius
        self.velocity = velocity
        self.angle = start_angle
        self.start_angle = start_angle
        self.finish_angle = finish_angle
        angle_rad = self.angle / 180 * pi
        x = initial_position[0] - (cos(angle_rad) * self.radius)
        y = initial_position[1] - (sin(angle_rad) * self.radius)
        self.center_position = (x, y)

    def next_position(self):
        self.angle += self.velocity
        self.angle %= 360
        if round(self.angle) == self.finish_angle:
            self.finished = True
        angle_rad = self.angle / 180 * pi
        x = self.center_position[0] + (cos(angle_rad) * self.radius)
        y = self.center_position[1] + (sin(angle_rad) * self.radius)
        return x, y

    def get_angle(self):
        return self.angle


class ImageFactory:
    def __init__(self):
        self.spritesheet = pygame.image.load("galaga.png").convert_alpha()
        self.sprites = {"nave1": {"rect": pygame.Rect((160, 55), (40, 16)), "w": 16, "h": 16, "gap_x": 0, "gap_y": 0},
                        "nave2": {"rect": pygame.Rect((160, 79), (40, 16)), "w": 16, "h": 16, "gap_x": 0, "gap_y": 0},
                        "inimigo1": {"rect": pygame.Rect((160, 104), (40, 16)), "w": 16, "h": 16, "gap_x": 8, "gap_y": 0},
                        "inimigo2": {"rect": pygame.Rect((160, 128), (40, 16)), "w": 16, "h": 16, "gap_x": 8, "gap_y": 0},
                        "inimigo3": {"rect": pygame.Rect((160, 150), (40, 16)), "w": 16, "h": 16, "gap_x": 8, "gap_y": 0},
                        "inimigo4": {"rect": pygame.Rect((160, 175), (40, 16)), "w": 16, "h": 16, "gap_x": 8, "gap_y": 0},
                        "inimigo5": {"rect": pygame.Rect((160, 200), (16, 16)), "w": 16, "h": 16, "gap_x": 0, "gap_y": 0},
                        "inimigo6": {"rect": pygame.Rect((160, 225), (16, 16)), "w": 16, "h": 16, "gap_x": 0, "gap_y": 0},
                        "inimigo7": {"rect": pygame.Rect((160, 248), (16, 16)), "w": 16, "h": 16, "gap_x": 0, "gap_y": 0},
                        "inimigo8": {"rect": pygame.Rect((160, 270), (16, 16)), "w": 16, "h": 16, "gap_x": 0, "gap_y": 0},
                        "inimigo9": {"rect": pygame.Rect((160, 296), (16, 16)), "w": 16, "h": 16, "gap_x": 0, "gap_y": 0},
                        "inimigoA": {"rect": pygame.Rect((160, 319), (16, 16)), "w": 16, "h": 16, "gap_x": 0, "gap_y": 0},
                        "tiro": {"rect": pygame.Rect((365, 195), (3, 8)), "w": 3, "h": 8, "gap_x": 0, "gap_y": 0}
                        }
        self.populate_sprite_images()

    def populate_sprite_images(self):
        for s in self.sprites.keys():
            r = self.sprites[s]["rect"]
            self.sprites[s]["image"] = self.spritesheet.subsurface(r)

    def get_sprite_image(self, nome):
        if nome in self.sprites:
            sprite = self.sprites[nome]
            if sprite is not None:
                return sprite["image"]
        return None

    def get_sprite_complete(self, nome):
        self.get_sprite_image(nome)
        return self.get_sprite_info(nome)

    def get_sprite_info(self, nome):
        if nome in self.sprites:
            sprite = self.sprites[nome]
            return sprite


class Nave(pygame.sprite.Sprite):
    def __init__(self):
        pygame.sprite.Sprite.__init__(self)
        self.spritesheet = ImageFactory().get_sprite_complete("nave1")
        self.estado = "UNICO"
        self.animacoes = {
            "UNICO": RotateList([0], loop=False, delay=10)}
        self.image = get_frame_by_gid(self.spritesheet, 0)
        self.rect = self.image.get_rect()
        self.vel_x = 0
        self.vel_y = 0

    def update(self):
        self.rect.move_ip(self.vel_x, self.vel_y)
        movimentos = self.animacoes[self.estado]
        gId = movimentos.update()
        self.image = get_frame_by_gid(self.spritesheet, gId)

    def processar_eventos(self, eventos):
        for e in eventos:
            if e.type == pygame.KEYDOWN:
                if e.key == pygame.K_RIGHT:
                    self.vel_x = 1
                elif e.key == pygame.K_LEFT:
                    self.vel_x = -1
                elif e.key == pygame.K_UP:
                    self.vel_y = -1


class Enemy(pygame.sprite.Sprite):
    def __init__(self, name):
        pygame.sprite.Sprite.__init__(self)
        self.move_behaviors = RotateList([
                               DestinyMoveBehavior(initial_position=(800, 0), final_position=(500, 550)),
                               DestinyMoveBehavior(initial_position=(500, 550), final_position=(0, 550)),
                               DestinyMoveBehavior(initial_position=(0, 550), final_position=(400, 300)),
                               RadialMoveBehavior(initial_position=(400, 300), start_angle=359, finish_angle=1,
                                                  radius=200, velocity=-0.3)
        ])
        self.spritesheet = ImageFactory().get_sprite_complete(name)
        self.estado = "UNICO"
        self.move_behavior = self.move_behaviors.update()
        self.vel_x = 0
        self.vel_y = 0
        lista = [0, 1]
        if self.spritesheet["gap_x"] == 0:
            lista = [0]
        self.animacoes = {
            "UNICO": RotateList(lista, loop=True, delay=50)}
        self.image_original = get_frame_by_gid(self.spritesheet, 0)
        self.image = self.image_original.copy()
        self.rect = self.image.get_rect()

    def update(self):
        self.rect.center = self.move_behavior.next_position()
        if self.move_behavior.is_finished():
            self.move_behavior = self.move_behaviors.update()
        movimentos = self.animacoes[self.estado]
        gId = movimentos.update()
        self.image_original = get_frame_by_gid(self.spritesheet, gId)
        self.image = pygame.transform.rotate(self.image_original, -self.move_behavior.get_angle())


nave = Nave()
nave.rect.center = (350, 500)
grp_nave = pygame.sprite.Group()
grp_tiros = pygame.sprite.Group()
grp_inimigos = pygame.sprite.Group()
grp_nave.add(nave)
ciclo = -1

while True:
    # calcular regras
    grp_nave.update()
    grp_inimigos.update()
    grp_tiros.update()
    ciclo += 1
    if ciclo % 50 == 0 and ciclo < 1000:
        indice = randint(1, 10)
        if indice == 10:
            indice = "A"
        inimigo = "inimigo" + str(indice)
        print(inimigo)
        enemy = Enemy(inimigo)
        grp_inimigos.add(enemy)
        dest_y = (ciclo // 500) * 100 + 100
        dest_x = (ciclo % 500) + 100
        enemy.move_behaviors.append(DestinyMoveBehavior(initial_position=(400, 300), final_position=(dest_x, dest_y)))

    # pintar
    tela.fill(PRETO)
    grp_nave.draw(tela)
    grp_inimigos.draw(tela)
    grp_tiros.draw(tela)
    pygame.display.update()
    pygame.time.delay(2)

    # capturar eventos
    evts = pygame.event.get()
    nave.processar_eventos(evts)
    for e in evts:
        if e.type == pygame.QUIT:
            exit()
