class Jogador:
    def __init__(self, nome):
        self.x = 10
        self.y = 20
        self.altura = 20
        self.peso = 80
        self.numero_camisa = 10
        self.nome = nome
        # 0 - Esquerda  1 - Direita
        self.perna_dominante = 0
        self.velocidade = 10

        # 0 - nenhum  1 - amarelo   2 - vermelho
        self.cartao_tomado = 0

        # 0 - goleiro  1 - zagueiro  2 - lateral   3 - meio    4 - atacante
        self.posicao_campo = 4

    def chutar(self, perna):
        """ Faz o chute com a perna informada
        0 - esquerda
        1 - direita """
        vel = self.peso * self.velocidade
        if self.perna_dominante == perna:
            vel = vel * 1.8
        print("Chutou com a velocidade {}".format(vel))
        return vel


neymar = Jogador("Neymar Jr.")
imperador = Jogador("Adriano")
neymar.perna_dominante = 1
neymar.chutar(1)