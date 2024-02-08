package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Jogo
import javax.persistence.EntityManager

class JogosDAO(manager: EntityManager): DAO<Jogo, JogoEntity> (manager, JogoEntity::class.java) {

    override fun toEntity(objeto: Jogo): JogoEntity {
        return JogoEntity(
            objeto.titulo.toString(),
            objeto.capa.toString(),
            objeto.preco,
            objeto.descricao.toString(),
            objeto.id
        )
    }

    override fun toModel(entity: JogoEntity): Jogo {
        return Jogo(
            entity.titulo,
            entity.capa,
            entity.preco,
            entity.descricao,
            entity.id
        )
    }

}