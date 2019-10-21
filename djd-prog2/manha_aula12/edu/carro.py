class CarroFusca:
    def __init__(self):
        self.porta_aberta = False
        self.velocidade = 0
        self.potencia = 1.3
        self.ligado = False
        self.cor = "Branca"

    def acelerar(self):
        if self.ligado:
            if not self.porta_aberta:
                self.velocidade += 10
            else:
                print("Você não pode andar no carro com a porta aberta")
        else:
            print("O carro está desligado")

    def abrir_porta(self):
        self.porta_aberta = True

    def fechar_porta(self):
        self.porta_aberta = False

    def ligar(self):
        self.ligado = True

    def desligar(self):
        self.ligado = False

    def frear(self):
        self.velocidade -= 10
        if self.velocidade < 0:
            self.velocidade = 0
