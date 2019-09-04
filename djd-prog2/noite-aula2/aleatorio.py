from random import random, seed
seed(1004)
print("Jogo do Dado")
n = int(input("Digite um numero entre 1 e 6:"))
numero = round(random() * 5) + 1
print("Numero escolhido pelo usuario: " + str(n))
print("Numero sorteado no dado: " + str(numero))
ganhou = n == numero
print("Ganhou: " + str(ganhou))

