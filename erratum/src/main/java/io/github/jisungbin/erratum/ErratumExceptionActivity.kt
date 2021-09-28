package io.github.jisungbin.erratum

import androidx.appcompat.app.AppCompatActivity

abstract class ErratumExceptionActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_LAST_ACTIVITY_INTENT = "EXTRA_LAST_ACTIVITY_INTENT"
        const val EXTRA_EXCEPTION_STRING = "EXTRA_EXCEPTION_STRING"
    }
}
