console.log("Pacman.js carregado")

var canvas = document.getElementById("canvas")
var ctx = canvas.getContext("2d")

console.log(canvas)
console.log(ctx)


var largura = 800 / 16
var altura = 600 /16

var cenario = [
  [2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 ],
  [2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2 ],
  [2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2 ],
  [2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2 ],
  [2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2 ],
  [2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 ],
  [2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 ],
  [2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 ],
  [2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 ],
  [2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 ],
  [2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 ],
  [2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 ],
  [2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 ],
  [2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 ],
  [2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 ],
  [2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 ]
]


for (var linha = 0; linha < 16; linha++) {
  for (var coluna = 0; coluna < 16; coluna++) {
    var celula = cenario[linha][coluna]
    var x = coluna * largura
    var y = linha * altura
    cor = "black"
    if (celula == 2) {
      cor = "blue"
    }
    ctx.fillStyle = cor
    ctx.fillRect(x, y, largura, altura)
  }
}


ctx.fillStyle = "yellow"
// ctx.fillRect(50, 100, 300, 200)
ctx.beginPath()
var pac_linha = 1
var pac_coluna = 6
var raio = largura / 2
var pac_x = pac_coluna * largura + raio
var pac_y = pac_linha * altura + raio
var t = pac_y - raio
var l = pac_x - raio
var r = pac_x + raio
var b = pac_y + raio
var olho_x = r - (raio / 1.2)
var olho_y = t + raio / 2
ctx.arc(pac_x, pac_y, raio, 0, Math.PI * 1.8)
ctx.lineTo(pac_x, pac_y)
ctx.lineTo(pac_x + raio, pac_y)
ctx.moveTo(pac_x, pac_y + raio / 2)
ctx.fill()
ctx.stroke()
console.log(olho_x)
console.log(olho_y)

ctx.fillStyle="black"
ctx.beginPath()
// ctx.arc(top + raio / 2, rigth - raio / 2, raio / 4, 0, Math.PI * 2)
ctx.arc(olho_x, olho_y, (raio / 6), 0, Math.PI * 2)
ctx.fill()
ctx.stroke()
