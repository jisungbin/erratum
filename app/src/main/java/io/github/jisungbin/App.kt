package io.github.jisungbin

import android.app.Application
import io.github.jisungbin.erratum.Erratum

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Erratum.setup(this)
    }
}
