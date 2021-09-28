package io.github.jisungbin.erratum

import androidx.appcompat.app.AppCompatActivity

abstract class ErratumExceptionActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_INTENT = "EXTRA_INTENT"
        const val EXTRA_ERROR_TEXT = "EXTRA_ERROR_TEXT"
    }
}
