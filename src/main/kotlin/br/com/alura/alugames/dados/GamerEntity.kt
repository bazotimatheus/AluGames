package br.com.alura.alugames.dados

import javax.persistence.*

@Entity
@Table(name = "gamers")
class GamerEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val nome: String = "Nome do gamer",
    val email: String = "gamer@email.com",
    val dataNascimento: String? = null,
    val usuario: String? = null,
    var id: Int = 0) {

}
