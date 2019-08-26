temperatura = int(input("Informe a temperatura"))

if temperatura < 10:
    print("Frio")
elif temperatura < 20:
    print("Agradável")
elif temperatura < 25:
    print("Esquentando")
else:
    print("Muito quente")
