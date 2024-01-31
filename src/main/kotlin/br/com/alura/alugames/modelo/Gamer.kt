package br.com.alura.alugames.modelo

data class Gamer(var nome:String, var email:String) {
    var dataNascimento:String? = null
    var usuario:String? = null
    var idInterno:String? = null

    constructor(nome: String,
                email: String,
                dataNascimento: String,
                usuario: String):
                this(nome, email) {
                    this.dataNascimento = dataNascimento
                    this.usuario = usuario
                }

    override fun toString(): String {
        return "Gamer:" +
                "Nome: " + nome + "\n" +
                "email: " + email + "\n" +
                "data de nascimento: " + dataNascimento + "\n" +
                "usuario: " + usuario + "\n" +
                "idInterno: " + idInterno + "\n"
    }
}