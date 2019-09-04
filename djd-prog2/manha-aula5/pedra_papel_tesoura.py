from random import choice
print("Jogo de Pedra, Papel e Tesoura")
print("Por favor escolha sua jogada "
      "(S)cissor, (P)aper ou (R)ock")

letra = input("Escolha S, P ou R:").upper()[0]
escolha_comp = choice(['S', 'P', 'R'])

print("Minha escolha: " + letra)
print("Computador escolha: " + escolha_comp)

if letra == escolha_comp:
    print("Deu empate")
elif letra == 'S' and escolha_comp == 'P':
    print("Você ganhou")
elif letra == 'P' and escolha_comp == 'R':
    print("Você ganhou")
elif letra == 'R' and escolha_comp == 'S':
    print("Você ganhou")
else:
    print("Você perdeu")
