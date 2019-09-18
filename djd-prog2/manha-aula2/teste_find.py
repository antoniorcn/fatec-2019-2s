# texto = "Os alunos da Fatec, gostam de criar jogos digitais"
# pos = texto.find("jogos")
# print("Achado a palavra jogos na posicao: ", pos)

texto2 = "Os alunos da Fatec, gostam de criar jogos digitais e " \
         "também gostam de criar personagens"
pos2 = texto2.find("criar")
print("Achado a palavra criar na posicao: ", pos2)

pos2 = texto2.find("criar", pos2 + 1)
print("Achado a palavra criar na posicao: ", pos2)

pos2 = texto2.find("criar", pos2 + 1)
print("Achado a palavra criar na posicao: ", pos2)