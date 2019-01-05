package flaviofernandes.albumfigurinhas

import android.app.Application
import flaviofernandes.albumfigurinhas.data.Banco

class FigurinhasApplication : Application() {

    companion object {

        @JvmStatic
        lateinit var banco: Banco
            private set
    }

    override fun onCreate() {
        super.onCreate()
        FigurinhasApplication.banco = Banco(this)
    }
}
