package flaviofernandes.albumfigurinhas.dao

import android.content.ContentValues
import android.database.Cursor
import flaviofernandes.albumfigurinhas.data.*
import flaviofernandes.albumfigurinhas.model.Figurinha
import flaviofernandes.albumfigurinhas.utils.extensions.toBoolean

class FigurinhaDao(private val banco: Banco) {

    private val lista = """
    SELECT
        $FIGURINHA_COLUNA_ID,
        $FIGURINHA_COLUNA_NUMERO,
        $FIGURINHA_COLUNA_TEM
     FROM $FIGURINHA_NOME_TABELA
    """

    fun lista(): List<Figurinha> {
        val figurinhas = mutableListOf<Figurinha>()
        with(banco.readableDatabase.rawQuery(lista, emptyArray())) {
            while (moveToNext()) {
                criaFigurinha(figurinhas)
            }
            close()
        }
        return figurinhas
    }

    fun atualiza(figurinha: Figurinha) {
        with(ContentValues()) {
            criaFigurinha(figurinha)
            banco.writableDatabase.update(FIGURINHA_NOME_TABELA, this, "id = ?", arrayOf(figurinha.id.toString()))
        }
    }

    private fun ContentValues.criaFigurinha(figurinha: Figurinha) {
        put(FIGURINHA_COLUNA_NUMERO, figurinha.numero)
        put(FIGURINHA_COLUNA_TEM, figurinha.tem)
    }

    private fun Cursor.criaFigurinha(figurinhas: MutableList<Figurinha>) {
        val id = getInt(getColumnIndex(FIGURINHA_COLUNA_ID))
        val numero = getInt(getColumnIndex(FIGURINHA_COLUNA_NUMERO))
        val tem = getInt(getColumnIndex(FIGURINHA_COLUNA_TEM)).toBoolean()
        val figurinha = Figurinha(id, numero, tem)
        figurinhas.add(figurinha)
    }
}
