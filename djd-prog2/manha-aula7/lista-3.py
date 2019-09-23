lista = [10, 11, 12, 13, 14, 15, 14]

print(lista)

lista.pop(1)
print(lista)

try:
    r = lista.index(18)
    print(r)
except:
    print("Numero nao existe na lista")

print(lista.count(14))

lista2 = lista
lista3 = lista.copy()

lista.pop()

print(lista2)
print(lista3)
lista4 = lista.copy()
lista4.reverse()
print(lista4)