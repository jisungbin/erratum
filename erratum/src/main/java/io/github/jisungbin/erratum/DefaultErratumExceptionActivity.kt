package io.github.jisungbin.erratum

import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DefaultErratumExceptionActivity : ErratumExceptionActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.erratum_activity_exception)

        findViewById<TextView>(R.id.tv_exception).text = exceptionString

        findViewById<Button>(R.id.btn_reload).setOnClickListener {
            openLastActivity()
        }
    }
}
