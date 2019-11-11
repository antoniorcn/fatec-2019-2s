import pygame

PRETO = (0, 0, 0)
AMARELO = (255, 255, 0)
VERMELHO = (255, 0, 0)
pygame.init()
tela = pygame.display.set_mode((800, 600), 0)
fator = 10.0
gravidade = 9.8
piso = pygame.Rect((0, 500), (800, 100))
x = 100
y = 0
y_vel = 0
corte = 0
img_fundo = pygame.image.load("parallax-2-800x120.png").convert_alpha()

def parallax(surf, initial_pos, img, pos_x):
    pos_x %= img.get_width()
    rect1 = pygame.Rect((0, 0), (pos_x, img.get_height()))
    temp_img1 = img.subsurface(rect1)
    rect2 = pygame.Rect((pos_x, 0), (img.get_width() - pos_x, img.get_height()))
    temp_img2 = img.subsurface(rect2)
    surf.blit(temp_img1, (img.get_width() - pos_x, initial_pos[1]))
    surf.blit(temp_img2, initial_pos)


while True:
    # Calcular Regras
    y_vel += gravidade
    y += (y_vel / fator)
    personagem = pygame.Rect((x, y), (50, 50))

    if piso.contains(personagem):
        y_vel *= -1

    corte += 3
    # if corte > 100:
    #    corte = 100

    # Desenhar
    tela.fill(PRETO)
    pygame.draw.rect(tela, AMARELO, piso)
    pygame.draw.rect(tela, VERMELHO, personagem)
    parallax(tela, (0, 500), img_fundo, corte)
    pygame.display.update()

    pygame.time.delay(50)

    # Eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
