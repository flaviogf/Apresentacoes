package flaviofernandes.albumfigurinhas.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import flaviofernandes.albumfigurinhas.FigurinhasApplication
import flaviofernandes.albumfigurinhas.R
import flaviofernandes.albumfigurinhas.dao.FigurinhaDao
import flaviofernandes.albumfigurinhas.model.GerenciadorDeFigurinha
import flaviofernandes.albumfigurinhas.ui.dialog.FigurinhaDialog
import flaviofernandes.albumfigurinhas.ui.recyclerview.adapter.FigurinhaAdapter
import kotlinx.android.synthetic.main.activity_lista_figurinhas.*

class ListaFigurinhasActivity : AppCompatActivity() {

    private val figurinhaDao = FigurinhaDao(FigurinhasApplication.banco)

    private val figurinhas = figurinhaDao.lista()

    private val adapter = FigurinhaAdapter(figurinhas)

    private val gerenciador = GerenciadorDeFigurinha(adapter::atualiza, figurinhaDao::atualiza)

    private val figurinhaDialog by lazy {
        FigurinhaDialog(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_figurinhas)
        inicializa()
    }

    private fun inicializa() {
        configuraAdapter()
        configuraDialog()
        configuraFab()
    }

    private fun configuraAdapter() {
        lista_figurinhas_recyclerview.adapter = adapter
        adapter.cliqueItem = figurinhaDialog::exibe
    }

    private fun configuraDialog() {
        figurinhaDialog.confirmou {
            gerenciador.marcaQueTem(it)
        }
        figurinhaDialog.negou {
            gerenciador.marcaQueNaoTem(it)
        }
    }

    private fun configuraFab() {
        lista_figurinhas_fab.setOnClickListener {
            iniciaResumoActivity()
        }
    }

    private fun iniciaResumoActivity() {
        val intent = Intent(this, ResumoActivity::class.java)
        startActivity(intent)
    }
}
