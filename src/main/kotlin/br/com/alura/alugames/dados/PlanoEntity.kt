package br.com.alura.alugames.dados

sealed class PlanoEntity(val tipo:String)

class PlanoAvulsoEntity(tipo: String): PlanoEntity(tipo)

class PlanoAssinaturaEntity(
    tipo: String,
    val mensalidade: Double,
    val jogosIncluido: Int,
    val percentualDescontoReputacao: Double
): PlanoEntity(tipo)