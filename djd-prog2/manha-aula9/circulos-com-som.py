import pygame as pg
from random import randint
pg.init()

pg.mixer.init()
snd = pg.mixer.Sound(file="door.wav")

tela = pg.display.set_mode((640, 480), 0, 32)
# Loop Jogo
while True:
    # Calcular as Regras
    x = randint(0, 640)
    y = randint(0, 480)
    r = randint(0, 255)
    g = randint(0, 255)
    b = randint(0, 255)

    # Pintar a tela
    # tela.fill((0, 0, 0))
    tela.set_at((100, 150), (255, 255, 0))
    pg.draw.circle(tela, (r, g, b), (x, y), 50, 0)
    pg.display.update()
    snd.play()

    pg.time.delay(1000)

    # Capturar os eventos
    for e in pg.event.get():
        if e.type == pg.QUIT:
            exit()
