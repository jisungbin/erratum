package io.github.jisungbin.erratum

import androidx.activity.ComponentActivity

abstract class ErratumExceptionActivity : ComponentActivity() {
    companion object {
        const val EXTRA_LAST_ACTIVITY_INTENT = "EXTRA_LAST_ACTIVITY_INTENT"
        const val EXTRA_EXCEPTION_STRING = "EXTRA_EXCEPTION_STRING"
    }
}
