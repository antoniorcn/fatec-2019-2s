import pygame as pg

pg.init()
tela = pg.display.set_mode((800, 600), 0, 32)

img = pg.image.load("imagem1.png")

matrix = []

for y in range(20):
    linha = []
    for x in range(20):
        pixel_vector = img.get_at((x, y))
        pixel = (pixel_vector[0] + pixel_vector[1] + pixel_vector[2]) // 3
        print("\t {}".format(pixel), end="")
        linha.append(pixel)
    matrix.append(linha)
    print()
personagem = [1, 1]
cor_personagem = (255, 255, 255)
escala = 16
matrix[0][1] = 0
matrix[0][2] = 0
matrix[0][3] = 0
matrix[0][4] = 0
while True:
    #tela.blit(img, (100, 100))
    for y in range(20):
        for x in range(20):
            cor = (255, 255, 0)
            if matrix[y][x] == 0:
                cor = (0, 0, 0)
            pg.draw.rect(tela, cor, pg.Rect((x * escala, y * escala),
                                         (escala, escala)), 0)

    pg.draw.circle(tela, cor_personagem, (personagem[0] * escala,
                                           personagem[1] * escala), escala //2, 0)

    pg.display.update()

    for e in pg.event.get():
        if e.type == pg.KEYDOWN:
            if e.key == pg.K_RIGHT:
                personagem[0] += 1
                coluna = personagem[0]
                linha = personagem[1]
                if matrix[linha][coluna] > 0:
                    cor_personagem = (255, 0, 0)
                else:
                    cor_personagem = (255, 255, 255)
        if e.type == pg.QUIT:
            exit()

