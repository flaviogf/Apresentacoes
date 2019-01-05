package flaviofernandes.albumfigurinhas.ui.recyclerview.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import flaviofernandes.albumfigurinhas.model.Figurinha
import kotlinx.android.synthetic.main.item_lista.view.*

class FigurinhaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var cliqueItem: ((Figurinha) -> Unit)? = null

    fun atribuiDados(figurinha: Figurinha) {
        configuraListeners(figurinha)
        configuraCampos(figurinha)
    }

    private fun configuraListeners(figurinha: Figurinha) {
        itemView.setOnClickListener {
            cliqueItem?.invoke(figurinha)
        }
    }

    private fun configuraCampos(figurinha: Figurinha) {
        with(itemView) {
            item_lista_icone_tem_figurinha.visibility = if (figurinha.tem) {
                View.VISIBLE
            } else {
                View.GONE
            }
            item_lista_numero.text = figurinha.numero.toString()
        }
    }
}
