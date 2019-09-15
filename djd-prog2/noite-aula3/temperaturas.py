print("Programa que mostra como esta o clima")
temp = int(input("Digite a temperatura"))

if temp < 0:
    print("Esta muito frio")
elif temp < 10:
    print("Frio")
elif temp < 20:
    print("Agradavel")
elif temp < 30:
    print("Calor")
else:
    print("Muito Calor")
    
print("Fim do programa")