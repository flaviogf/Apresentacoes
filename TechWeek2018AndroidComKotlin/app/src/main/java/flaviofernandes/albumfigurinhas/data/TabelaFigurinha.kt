package flaviofernandes.albumfigurinhas.data

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase

class TabelaFigurinha(private val banco: SQLiteDatabase?) {

    private val cria = """
    CREATE TABLE IF NOT EXISTS $FIGURINHA_NOME_TABELA(
        $FIGURINHA_COLUNA_ID INTEGER PRIMARY KEY AUTOINCREMENT,
        $FIGURINHA_COLUNA_NUMERO INTEGER,
        $FIGURINHA_COLUNA_TEM INTEGER
    )
    """

    private val deleta = """
    DROP TABLE IF EXISTS $FIGURINHA_NOME_TABELA
    """

    fun cria() {
        banco?.execSQL(cria)
    }

    fun deleta() {
        banco?.execSQL(deleta)
    }

    fun inicia() {
        for (numero in 1..680) {
            with(ContentValues()) {
                criaFigurinha(numero)
                banco?.insert(FIGURINHA_NOME_TABELA, null, this)
            }
        }
    }

    private fun ContentValues.criaFigurinha(numero: Int) {
        put(FIGURINHA_COLUNA_NUMERO, numero)
        put(FIGURINHA_COLUNA_TEM, 0)
    }
}
