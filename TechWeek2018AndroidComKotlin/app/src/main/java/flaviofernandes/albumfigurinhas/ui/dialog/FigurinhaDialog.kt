package flaviofernandes.albumfigurinhas.ui.dialog

import android.content.Context
import android.support.v7.app.AlertDialog
import flaviofernandes.albumfigurinhas.model.Figurinha

class FigurinhaDialog(context: Context) {

    private val dialog = AlertDialog.Builder(context)

    private lateinit var figurinha: Figurinha

    fun exibe(figurinha: Figurinha) {
        this.figurinha = figurinha
        configuraExibicao()
    }

    fun confirmou(callback: (Figurinha) -> Unit): FigurinhaDialog {
        dialog.setPositiveButton("Sim") { _, _ ->
            callback.invoke(figurinha)
        }
        return this
    }

    fun negou(callback: ((Figurinha) -> Unit)?): FigurinhaDialog {
        dialog.setNegativeButton("Não") { _, _ ->
            callback?.invoke(figurinha)
        }
        return this
    }

    private fun configuraExibicao() {
        with(dialog) {
            setMessage("Numero da figurinha: ${figurinha.numero}")
            setTitle("Você tem essa?")
            show()
        }
    }
}
