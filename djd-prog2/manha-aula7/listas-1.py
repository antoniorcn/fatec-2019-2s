link = [7, 20, 5, 200, "madeira", "ferro", 4, ["comum", "azul"] ]

link[0] = 9

print(link)

print("Link possui escudo de:")
print(link[4])

print("Encontrou 5 moedas, agora sua bolsa tem")
link[3] = link[3] + 5
print(" {} rupias".format(link[3]))

link[4] = "bronze"
print("Link possui escudo de: {}".format(link[4]))

link.append("hipona")

print(link)
