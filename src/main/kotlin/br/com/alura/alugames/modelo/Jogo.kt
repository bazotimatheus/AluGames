package br.com.alura.alugames.modelo

import com.google.gson.annotations.Expose

data class Jogo(@Expose val titulo:String?,
                @Expose val capa:String?):Recomendavel {
    var preco = 0.0
    var descricao: String? = null
    var id = 0
    private val listaNotas = mutableListOf<Int>()

    constructor(titulo: String, capa: String, preco: Double, descricao: String, id: Int = 0):
            this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
        this.id = id
    }


    override val media: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        listaNotas.add(nota)
    }

    override fun toString(): String {
        return "\nMeu Jogo: \n" +
                "Titulo: $titulo \n" +
                "Capa: $capa \n" +
                "Preço: $preco \n" +
                "Descricao: $descricao \n" +
                "Id: $id \n"
    }


}