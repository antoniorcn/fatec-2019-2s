console.log("Pacman.js carregado")
var canvas = document.getElementById("canvas")
var ctx = canvas.getContext("2d")

console.log(canvas)
console.log(ctx)

class Cenario {

  constructor(largura, altura) {
    this.largura = largura
    this.altura = altura
    this.cenario = [
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
  }

  pintar() {
    for (var linha = 0; linha < 16; linha++) {
      for (var coluna = 0; coluna < 16; coluna++) {
        var celula = this.cenario[linha][coluna]
        var x = coluna * this.largura
        var y = linha * this.altura
        var cor = "black"
        if (celula == 2) {
          cor = "blue"
        }
        ctx.fillStyle = cor
        ctx.fillRect(x, y, this.largura, this.altura)
      }
    }
  }

  capturarEventos( e ) {
  }
}

class Pacman {
  constructor(largura, altura) {
    this.pac_linha = 1
    this.pac_coluna = 6
    this.largura = largura
    this.altura = altura
  }

  pintar() {
    ctx.fillStyle = "Yellow"
    // ctx.fillRect(50, 100, 300, 200)
    ctx.beginPath()
    var raio = this.largura / 2
    var pac_x = this.pac_coluna * this.largura + raio
    var pac_y = this.pac_linha * this.altura + raio
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
    ctx.fillStyle="black"
    ctx.beginPath()
    // ctx.arc(top + raio / 2, rigth - raio / 2, raio / 4, 0, Math.PI * 2)
    ctx.arc(olho_x, olho_y, (raio / 6), 0, Math.PI * 2)
    ctx.fill()
    ctx.stroke()
  }

  capturarEventos( e ) {
    if (e.key == "w"){
      this.pac_linha -= 1
    } else if (e.key == "s"){
      this.pac_linha += 1
    }
  }
}

class Fantasma {
  constructor(largura, altura, corFundo) {
    this.linha = 1
    this.coluna = 6
    this.corFundo = corFundo
    this.largura = largura
    this.altura = altura
  }

  pintar() {
    var w = this.largura / 8
    var h = this.altura / 6
    var px = this.coluna * this.largura
    var py = this.linha * this.altura
    ctx.fillStyle = this.corFundo
    // ctx.fillRect(50, 100, 300, 200)
    ctx.beginPath()
    ctx.moveTo(px, py + this.altura)
    ctx.lineTo(px + w, py + h * 2)
    ctx.lineTo(px + 2 * w, py + h / 2)
    ctx.lineTo(px + 3 * w, py)
    ctx.lineTo(px + 5 * w, py)
    ctx.lineTo(px + 6 * w, py + h / 2)
    ctx.lineTo(px + 7 * w, py + 3 * h)
    ctx.lineTo(px + this.largura, py + this.altura)
    ctx.moveTo(px + 4 * w, py + 3 * h)
    ctx.fill()
    ctx.stroke()

    var px_olho_e = px + 2.5 * w
    var py_olho_e = py + 1.5 * h

    var px_olho_d = px + 5.5 * w
    var py_olho_d = py + 1.5 * h

    ctx.fillStyle="White"
    ctx.beginPath()
    ctx.arc(px_olho_e, py_olho_e, w / 2, 0, Math.PI * 2)
    ctx.moveTo(px_olho_d, py_olho_d)
    ctx.arc(px_olho_d, py_olho_d, w / 2, 0, Math.PI * 2)
    ctx.fill()
    ctx.stroke()

    ctx.fillStyle="Black"
    ctx.beginPath()
    ctx.arc(px_olho_e, py_olho_e, w / 4, 0, Math.PI * 2)
    ctx.moveTo(px_olho_d, py_olho_d)
    ctx.arc(px_olho_d, py_olho_d, w / 4, 0, Math.PI * 2)
    ctx.fill()
    ctx.stroke()
  }

  capturarEventos( e ) {
  }
}

var largura = 800/16
var altura = 600/16
let pacman = new Pacman(largura, altura)
let cenario = new Cenario(largura, altura)
let blink = new Fantasma(largura, altura, "Red")
let ink = new Fantasma(largura, altura, "LightBlue")
let clyde = new Fantasma(largura, altura, "Orange")
let pink = new Fantasma(largura, altura, "Pink")
blink.coluna = 6
blink.linha = 4

ink.coluna = 8
ink.linha = 7

clyde.coluna = 10
clyde.linha = 5

pink.coluna = 14
pink.linha = 2



function loop_jogo() {
  // Calcular Regras

  // Pintar os objetos
  cenario.pintar()
  pacman.pintar()
  blink.pintar()
  ink.pintar()
  pink.pintar()
  clyde.pintar()

  // Capturar Eventos
}

function capturar_eventos(e) {
  cenario.capturarEventos(e)
  pacman.capturarEventos(e)
}

window.setInterval(loop_jogo, 20)
window.addEventListener("keydown", capturar_eventos)
