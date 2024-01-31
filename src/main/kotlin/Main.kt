package org.example

import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.*
import kotlin.system.exitProcess


fun main() {
    val leitura = Scanner(System.`in`)
    println("Digite um código de jogo para buscar: ")
    val busca = leitura.nextLine()

    val endereco = "https://www.cheapshark.com/api/1.0/games?id=$busca"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(endereco))
        .build()
    val response = client
        .send(request, BodyHandlers.ofString())

    val json = response.body()
//    println(json)

//    meuJogo.titulo = "Batman: Arkham Asylum Game of the Year Edition"
//    meuJogo.capa = "https:\\\\/\\\\/cdn.cloudflare.steamstatic.com\\\\/steam\\\\/apps\\\\/35140\\\\/capsule_sm_120.jpg?t=1681938587"
//    meuJogo.descricao = "Jogo do Batman"

//    println(meuJogo)

//    val meuJogo = Jogo(
//        "Batman: Arkham Asylum Game of the Year Edition",
//        "https:\\\\/\\\\/cdn.cloudflare.steamstatic.com\\\\/steam\\\\/apps\\\\/35140\\\\/capsule_sm_120.jpg?t=1681938587"
//    )
//
//    println(meuJogo)
//
//    val novoJogo = Jogo (
//        capa = "https:\\\\/\\\\/cdn.cloudflare.steamstatic.com\\\\/steam\\\\/apps\\\\/35140\\\\/capsule_sm_120.jpg?t=1681938587",
//        titulo = "Batman: Arkham Asylum Game of the Year Edition"
//    )
//
//    println(novoJogo)

    val gson = Gson()
//    val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)
//    val meuJogo = Jogo(
//        meuInfoJogo.info.title,
//        meuInfoJogo.info.thumb
//    )
//    println(meuJogo)

//    try {
//        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)
//        val meuJogo = Jogo(
//            meuInfoJogo.info.title,
//            meuInfoJogo.info.thumb
//        )
//
//        println(meuJogo)
//    } catch (ex: JsonSyntaxException) {
//        println("Retorno vazio. Tente outro id.")
//    } catch (ex : NullPointerException) {
//        println("Jogo inexistente. Tente outro id.")
//    }

    var meuInfoJogo:InfoJogo? = null

    val resultadoIJ = runCatching {
        meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)
    }

    resultadoIJ.onFailure {
        println("Id informado inexistente. Tente outro Id.")
        exitProcess(1)
    }

    var meuJogo:Jogo? = null

    val resultado = runCatching {
        meuJogo = Jogo(
            meuInfoJogo!!.info.title,
            meuInfoJogo!!.info.thumb
        )
    }

    resultado.onFailure {
        println("Jogo inexistente. Tente outro id.")
    }

    resultado.onSuccess {
        println("Deseja inserir uma descrição personalizada? S/N")
        val opcao = leitura.nextLine()

        if (opcao.equals("s", true)) {
            println("Insira a descrição personalizada para o jogo: ")
            val descricaoPersonalizada = leitura.nextLine()

            meuJogo?.descricao = descricaoPersonalizada
        } else {
            meuJogo?.descricao = meuJogo?.titulo
        }

        println(meuJogo)
    }

    resultado.onSuccess {
        println("Busca finalizada com sucesso!")
    }


}