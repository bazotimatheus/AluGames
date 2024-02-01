package br.com.alura.alugames.modelo

data class Jogo(val titulo:String?, val capa:String?) {
    var preco = 0.0
    var descricao: String? = null

    constructor(titulo: String, capa: String, preco: Double, descricao: String):
            this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
    }

    override fun toString(): String {
        return "Meu Jogo:\n" +
                "Titulo: $titulo \n" +
                "Capa: $capa \n" +
                "Preço: $preco \n" +
                "Descricao: $descricao \n"
    }


}