# import carro as car
from carro import CarroFusca


carro1 = CarroFusca()
carro1.ligar()
carro1.acelerar()
carro1.abrir_porta()
carro1.fechar_porta()
carro1.acelerar()
carro1.acelerar()
carro1.acelerar()
print("Velocidade atual do Fusca {}".format(carro1.velocidade))
carro1.frear()
print("Velocidade atual do Fusca {}".format(carro1.velocidade))

