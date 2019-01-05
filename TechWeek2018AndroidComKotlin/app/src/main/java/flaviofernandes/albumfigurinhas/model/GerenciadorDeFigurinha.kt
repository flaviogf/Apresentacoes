package flaviofernandes.albumfigurinhas.model

class GerenciadorDeFigurinha(private vararg val comandos: (Figurinha) -> Unit) {

    private lateinit var figurinha: Figurinha

    fun marcaQueNaoTem(figurinha: Figurinha) {
        this.figurinha = figurinha
        this.figurinha.tem = false
        executa()
    }

    fun marcaQueTem(figurinha: Figurinha) {
        this.figurinha = figurinha
        this.figurinha.tem = true
        executa()
    }

    private fun executa() {
        comandos.forEach {
            it.invoke(figurinha)
        }
    }
}
