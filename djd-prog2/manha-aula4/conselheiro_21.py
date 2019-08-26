pontuacao = int(input("Digite o total de pontos obtidos ate o momento"))

if pontuacao == 21:
    print("Parabéns Você G A N H O U !!!")
elif pontuacao > 21:
    print("Parabéns Você P E R D E U !!!")
elif pontuacao <= 10:
    print("Sem duvida compre mais uma carta")
elif pontuacao <= 15:
    print("Há um risco, mas aconselho a comprar mais uma carta")
else:
    print("Pare de comprar")
