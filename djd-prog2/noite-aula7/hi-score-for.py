lista_pontos = [200, 150, 80, 400, 1020, 10]
lista_nomes = ["Alfredo", "Marcio", "Maycon",
               "Bianca", "Carlos", "Darci"]
for i, nome in enumerate(lista_nomes):
    pontos = lista_pontos[i]
    texto = "{0:<12} ........... {1:>5}".format(nome, pontos)
    print(texto)
