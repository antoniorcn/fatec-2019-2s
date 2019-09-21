linha = 0
contador = 0
while linha < 6:
    a = 0
    while a < 6:
        print(contador, end="\t")
        a = a + 1
        contador = contador + 1
    print()
    linha = linha + 1   # linha += 1