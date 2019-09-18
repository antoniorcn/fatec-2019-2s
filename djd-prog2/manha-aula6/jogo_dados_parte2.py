from random import randint
print("Jogo de dados")
quererJogar = True
while quererJogar == True:
    numero = int(input("Digite um numero entre 1 e 6"))
    dado = randint(1, 6)
    print("O numero sorteado no dado foi", dado)
    if numero == dado:
        print("PARABÉNS VOCÊ VENCEU")
    else:
        print("QUE PENA VOCÊ PERDEU")
    jogar = input("Você deseja jogar novamente (S)im ou (N)ão ?").upper()[0:1]
    if jogar == "S":
        quererJogar = True
    else:
        quererJogar = False
print("Fim de Jogo")