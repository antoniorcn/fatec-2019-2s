from random import randint
print("Jogo de Dados")
print("Vamos jogar 6 dados, por favor adivinhe a soma total")
j1 = int(input("Jogador 1: Informe a soma total um número entre 6 e 36"))
j2 = int(input("Jogador 2: Informe a soma total um número entre 6 e 36"))
print("Sorteando os dados")
d1 = randint(1, 6)
d2 = randint(1, 6)
d3 = randint(1, 6)
d4 = randint(1, 6)
d5 = randint(1, 6)
d6 = randint(1, 6)
soma = d1 + d2 + d3 + d4 + d5 + d6
print("Os dados lançados foram: ")
print(d1, d2, d3, d4, d5, d6)
print("Soma dos dados =", soma)
d1 = abs(soma - j1)
d2 = abs(soma - j2)
if j1 == j2 or d1 == d2:
    print("Houve empate")
elif soma == j1 or d1 < d2:
    print("Jogador 1 venceu")
elif soma == j2 or d2 < d1:
    # else:
    print("Jogador 2 venceu")


