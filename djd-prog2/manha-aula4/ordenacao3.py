print("Ordenação de 3 números")
n1 = int(input("Digite o 1º numero"))
n2 = int(input("Digite o 2º numero"))
n3 = int(input("Digite o 3º numero"))

if n1 <= n2 <= n3:
    print(n1, n2, n3)
elif n1 <= n3 <= n2:
    print(n1, n3, n2)
elif n2 <= n1 <= n3:
    print(n2, n1, n3)
elif n2 <= n3 <= n1:
    print(n2, n3, n1)
elif n3 <= n1 and n1 <= n2:
    print(n3, n1, n2)
else:
    print(n3, n2, n1)
