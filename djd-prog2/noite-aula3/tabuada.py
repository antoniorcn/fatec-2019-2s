n = 1
while n <= 10:
    indice = 0
    while indice <= 10:
        resultado = n * indice
        # print(n, " X ", indice, " = ", resultado)
        print("{} X {} = {}".format(n, indice, resultado))
        indice = indice + 1
    n = n + 1
    print("")
