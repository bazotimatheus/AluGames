package br.com.alura.alugames.modelo

import java.math.BigDecimal
import java.math.RoundingMode

class PlanoAvulso(tipo: String, id: Int = 0): Plano(tipo, id) {

    override fun obterValor(aluguel: Aluguel): Double {
        var valorOriginal = super.obterValor(aluguel)

        if(aluguel.gamer.media > 8) {
            valorOriginal -= valorOriginal * 0.1 // .multiply(BigDecimal("0.1"))
        }
        return BigDecimal(valorOriginal).setScale(2, RoundingMode.HALF_EVEN).toDouble()
    }

    override fun toString(): String {
        return "\nPlano Avulso: \n" +
                "Tipo: $tipo \n" +
                "Id: $id \n"
    }
}
