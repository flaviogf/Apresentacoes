package flaviofernandes.albumfigurinhas.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Banco(context: Context) : SQLiteOpenHelper(context, BANCO_NOME, null, BANCO_VERSAO) {

    private lateinit var tabelaFigurinha: TabelaFigurinha

    override fun onCreate(db: SQLiteDatabase?) {
        tabelaFigurinha = TabelaFigurinha(db)
        tabelaFigurinha.cria()
        tabelaFigurinha.inicia()
    }

    override fun onUpgrade(db: SQLiteDatabase?, versaoAntiga: Int, versaoNova: Int) {
        tabelaFigurinha = TabelaFigurinha(db)
        tabelaFigurinha.deleta()
        tabelaFigurinha.cria()
        tabelaFigurinha.inicia()
    }
}
