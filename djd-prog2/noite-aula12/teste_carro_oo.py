from carro_oo import Carro

c1 = Carro()
c2 = Carro()

print("Instancia 1")
c1.abrir_porta()
c1.ligar()
c1.fechar_porta()
c1.acelerar()
c1.acelerar()
c1.acelerar()
c1.frear()
c1.frear()
c1.frear()
c1.frear()

print("Instancia 2")
c2.ligar()
c2.acelerar()
c2.frear()

print("Instancia 1")
c1.acelerar()