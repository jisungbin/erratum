package io.github.jisungbin.erratum

import android.os.Bundle

class DefaultErratumExceptionActivity : ErratumExceptionActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.erratum_activity_exception)
    }
}
