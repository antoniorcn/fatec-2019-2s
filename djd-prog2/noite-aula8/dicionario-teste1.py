alucard = {
            "vida":5, "magias":["virar-morcego"], "arma":"espada",
            "defesa": "escudo de madeira", "items":["agua-benta"]
          }
mapa_jogo = ["escudo-bronze", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "vida", 0, 0, "lobo"]
pos = 8
sair = False
while not sair:
    print("Jogo Castlevania")
    print("Você está na sala {} do corredor principal".format(pos))
    if mapa_jogo[pos] != 0:
        print("Você encontrou alguma coisa: {}".format(mapa_jogo[pos]))
    print ("Dados do Alucard: ", alucard)
    tecla = input("Tecle (a) para ir a esquerda e (d) para a direita e (x) para sair")
    letra = tecla[0].lower()
    if letra == "a":
        pos = pos - 1
    elif letra == "d":
        pos = pos + 1
    elif letra == "x":
        sair = True

