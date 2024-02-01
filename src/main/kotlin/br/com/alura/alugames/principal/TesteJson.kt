package br.com.alura.alugames.principal

import br.com.alura.alugames.servicos.ConsumoApi

fun main() {
    val consumo = ConsumoApi()
    val listaGamer = consumo.buscaGamers()
    val jogoApi = consumo.buscaJogo("612")

    println(listaGamer)
    println(jogoApi)
}