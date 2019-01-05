package flaviofernandes.albumfigurinhas.ui.recyclerview.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import flaviofernandes.albumfigurinhas.R
import flaviofernandes.albumfigurinhas.model.Figurinha
import flaviofernandes.albumfigurinhas.ui.recyclerview.viewholder.FigurinhaViewHolder

class FigurinhaAdapter(private val figurinhas: List<Figurinha>) : RecyclerView.Adapter<FigurinhaViewHolder>() {

    var cliqueItem: ((Figurinha) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FigurinhaViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)
        return FigurinhaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FigurinhaViewHolder, position: Int) {
        holder.atribuiDados(figurinhas[position])
        holder.cliqueItem = cliqueItem
    }

    override fun getItemCount() = figurinhas.count()

    fun atualiza(figurinha: Figurinha) {
        notifyDataSetChanged()
    }
}
