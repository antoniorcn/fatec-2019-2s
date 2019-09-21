lista_unica = [ ["Alfredo", 200], ["Marcio", 150],
                ["Maycon", 80], ["Bianca", 400],
                ["Carlos", 1020], ["Darci", 10]
            ]
for item in lista_unica:
    nome = item[0]
    pontos = item[1]
    texto = "{0:<12} ........... {1:>5}".format(nome, pontos)
    print(texto)
