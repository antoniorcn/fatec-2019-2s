print("Programa de Hiscore")
lista_nomes = []
lista_pontos = []
for i in range(3):
    nome = input("Informe o nome do jogador")
    pontos = int(input("Informe os pontos do jogador " + nome))
    lista_nomes.append(nome)
    lista_pontos.append(pontos)
for i, nome in enumerate(lista_nomes):
    pontos = lista_pontos[i]
    texto = "{0:<12} ........... {1:>5}".format(nome, pontos)
    print(texto)
