class Carro:
    def __init__(self):
        self.cor = "yellow"
        self.porta_aberta = False
        self.velocidade_atual = 0
        self.potencia = 65
        self.ligado = False

    def ligar(self):
        self.ligado = True
        print("Carro esta ligado")

    def desligar(self):
        self.ligado = False
        print("Carro esta desligado")

    def abrir_porta(self):
        self.porta_aberta = True
        print("Porta do carro esta aberta")

    def fechar_porta(self):
        self.porta_aberta = False
        print("Porta do carro esta fechada")

    def acelerar(self):
        if self.ligado:
            if not self.porta_aberta:
                self.velocidade_atual += 10
                print("Carro esta em {} km/h".format(self.velocidade_atual))
            else:
                print("Você não pode acelerar com a porta aberta")
        else:
            print("O carro não esta ligado")

    def frear(self):
        if self.velocidade_atual > 0:
            self.velocidade_atual -= 10
            print("Carro esta em {} km/h".format(self.velocidade_atual))
        else:
            print("O carro já esta parado")



