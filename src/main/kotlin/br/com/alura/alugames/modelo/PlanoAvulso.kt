package br.com.alura.alugames.modelo

data class PlanoAvulso(val tipo: String) {
    fun obterValor(aluguel: Aluguel): Double {
        return aluguel.jogo.preco * aluguel.periodo.emDias
    }
}
