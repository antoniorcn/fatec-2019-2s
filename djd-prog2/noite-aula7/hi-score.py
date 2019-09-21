lista_pontos = [200, 150, 80, 400, 1020, 10]
lista_nomes = ["Alfredo", "Marcio", "Maycon",
               "Bianca", "Carlos", "Darci"]
x = 0
while x < 6:
    nome = lista_nomes[x]
    pontos = lista_pontos[x]
    texto = "{0:<12} ........... {1:>5}".format(nome, pontos)
    print(texto)
    x = x + 1


