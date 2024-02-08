package br.com.alura.alugames.modelo

import java.math.BigDecimal
import java.math.RoundingMode

class PlanoAssinatura(tipo: String,
                      val mensalidade: Double,
                      val jogosIncluidos: Int,
                      val percentualDescontoReputacao: Double,
                      id: Int = 0): Plano(tipo, id) {

    override fun obterValor(aluguel: Aluguel): Double {
        val totalJogosNoMes = aluguel.gamer.jogosDoMes(aluguel.periodo.dataInicial.monthValue).size

        return if (totalJogosNoMes <= jogosIncluidos) {
            0.0
        } else {
            var valorOriginal = super.obterValor(aluguel)
            if (aluguel.gamer.media > 8) {
                valorOriginal -= valorOriginal * percentualDescontoReputacao
            }
            BigDecimal(valorOriginal).setScale(2, RoundingMode.HALF_EVEN).toDouble()
        }
    }

    override fun toString(): String {
        return "Plano Assinatura: \n" +
                "Tipo: $tipo \n" +
                "Id: $id \n" +
                "Mensalidade: $mensalidade \n" +
                "Jogos incluídos: $jogosIncluidos \n" +
                "Percentual de desconto por reputação: $percentualDescontoReputacao \n"
    }
}
