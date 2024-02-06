package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Periodo
import br.com.alura.alugames.servicos.ConsumoApi
import java.time.LocalDate

fun main() {
    val consumo = ConsumoApi()
    val listaGamer = consumo.buscaGamers()
//    val jogoApi = consumo.buscaJogo("612")
    val listaJogoJson = consumo.buscaJogosJson()

//    println(listaGamer)
//    println(jogoApi)
//    println(listaJogoJson)

    val gamerCaroline = listaGamer.get(3)
    val jogoResidentVillage = listaJogoJson.get(10)

    println(gamerCaroline)
    println(jogoResidentVillage)

    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))

    val aluguel = gamerCaroline.alugaJogo(jogoResidentVillage, periodo)
    println(aluguel)
}