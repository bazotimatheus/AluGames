package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Periodo
import br.com.alura.alugames.modelo.PlanoAssinatura
import br.com.alura.alugames.servicos.ConsumoApi
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDate

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
//    val jogoApi = consumo.buscaJogo("612")
    val listaJogoJson = consumo.buscaJogosJson()

//    println(listaGamer)
//    println(jogoApi)
//    println(listaJogoJson)

//    val gamerCaroline = listaGamer.get(3)
//    val jogoResidentVillage = listaJogoJson.get(10)
//    val jogoSpider = listaJogoJson.get(13)
//    val jogoTheLastOfUs = listaJogoJson.get(2)

//    println(gamerCaroline)
//    println(jogoResidentVillage)

    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10))

//    gamerCaroline.alugaJogo(jogoResidentVillage, periodo1)
//    gamerCaroline.alugaJogo(jogoSpider, periodo2)
//    gamerCaroline.alugaJogo(jogoTheLastOfUs, periodo3)
//    println(gamerCaroline.jogosAlugados)

//    val gamerCamila = listaGamer.get(5)
//    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3, 0.15)
//    gamerCamila.alugaJogo(jogoResidentVillage, periodo1)
//    gamerCamila.alugaJogo(jogoSpider, periodo2)
//    gamerCamila.alugaJogo(jogoTheLastOfUs, periodo3)
//    gamerCamila.alugaJogo(jogoTheLastOfUs, periodo3)
//    println(gamerCamila.jogosAlugados)

//    gamerCamila.recomendar(7)
//    gamerCamila.recomendar(10)
//    gamerCamila.recomendar(8)
//    println(gamerCamila)

//    gamerCamila.alugaJogo(jogoResidentVillage, periodo1)
////    println(gamerCamila.jogosAlugados)
//
//    gamerCamila.recomendarJogo(jogoResidentVillage, 7)
//    gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)
//
//    gamerCaroline.recomendarJogo(jogoResidentVillage, 8)
//    gamerCaroline.recomendarJogo(jogoTheLastOfUs, 9)

//    println("\nRecomendações da Camila")
//    println(gamerCamila.jogosRecomendados)
//    println("\nRecomendações da Caroline")
//    println(gamerCaroline.jogosRecomendados)

//    val gamerCaroline = listaGamers.get(3)

    val gamerCamila = listaGamers.get(5)
    val jogoResidentVillage = listaJogoJson.get(10)
    val jogoSpider = listaJogoJson.get(13)
    val jogoTheLastOfUs = listaJogoJson.get(2)
    val jogoDandara = listaJogoJson.get(5)
    val jogoAssassins = listaJogoJson.get(4)
    val jogoCyber = listaJogoJson.get(6)
    val jogoGod = listaJogoJson.get(7)
    val jogoSkyrim = listaJogoJson.get(18)

    gamerCamila.recomendarJogo(jogoResidentVillage, 7)
    gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)
    gamerCamila.recomendarJogo(jogoAssassins, 8)
    gamerCamila.recomendarJogo(jogoCyber, 7)
    gamerCamila.recomendarJogo(jogoGod, 10)
    gamerCamila.recomendarJogo(jogoDandara, 8)
    gamerCamila.recomendarJogo(jogoSkyrim, 8)
    gamerCamila.recomendarJogo(jogoSpider, 6)

    val gson = GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .create()

    val serializacao = gson.toJson(gamerCamila.jogosRecomendados)

    val arquivo = File("jogosRecomendados.json")

    arquivo.writeText(serializacao)
    println(arquivo.absolutePath)

}