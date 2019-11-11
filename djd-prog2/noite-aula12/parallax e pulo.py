import pygame

pygame.init()
tela = pygame.display.set_mode((800, 600), 0)

img1 = pygame.image.load("clouds_BG.png").convert_alpha()
nuvem_fundo = pygame.transform.scale(img1, (800, 600))

img2 = pygame.image.load("clouds_MG_1.png").convert_alpha()
nuvem_meio = pygame.transform.scale(img2, (800, 600))


def parallax(surf, initial_pos, img, pos_x):
    pos_x %= img.get_width()
    rect1 = pygame.Rect((0, 0), (pos_x, img.get_height()))
    temp_img1 = img.subsurface(rect1)
    rect2 = pygame.Rect((pos_x, 0), (img.get_width() - pos_x, img.get_height()))
    temp_img2 = img.subsurface(rect2)
    surf.blit(temp_img1, (img.get_width() - pos_x, initial_pos[1]))
    surf.blit(temp_img2, initial_pos)


fundo_x = 0
meio_x = 0
x = 100
y = 0.0
gravidade = 0.98
acc_y = 0.0
piso = pygame.Rect((0, 500), (800, 50))

while True:
    # Calcular regras
    fundo_x += 1
    meio_x += 3
    r = pygame.Rect((x, y), (50, 50))
    # segundos = pygame.time.get_ticks() / 1000

    acc_y += gravidade
    y += acc_y

    if piso.colliderect(r):
        acc_y = abs(acc_y) * -1

    # Pintar
    tela.fill((0, 0, 0))
    parallax(tela, (0, 0), nuvem_fundo, fundo_x)
    parallax(tela, (0, 0), nuvem_meio, meio_x)
    pygame.draw.rect(tela, (255, 0, 0), r, 0)
    pygame.draw.rect(tela, (255, 255, 0), piso, 0)
    pygame.display.update()

    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()

