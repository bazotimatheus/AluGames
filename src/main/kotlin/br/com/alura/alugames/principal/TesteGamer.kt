package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Gamer

fun main() {
    val gamer1 = Gamer("Jacque", "jacque@email.com")
    val gamer2 = Gamer("Jeni", "jeni@email.com", "19/09/1992", "jeniblo")

    println(gamer1)
    println(gamer2)

    gamer1.let {
        it.dataNascimento = "18/02/2000"
        it.usuario = "jacqueskywalker"
    }

    println(gamer1)
}