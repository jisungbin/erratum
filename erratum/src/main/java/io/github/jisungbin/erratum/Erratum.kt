/**
 * erratum is licensed under MIT
 * Please see: https://github.com/jisungbin/erratum/blob/master/LICENSE
 */

package io.github.jisungbin.erratum

import android.app.Activity
import android.app.Application
import android.content.Intent

object Erratum {
    fun setup(
        application: Application,
        registerExceptionActivityIntent: ((thread: Thread, throwable: Throwable, lastActivity: Activity) -> Intent)? = null
    ) {
        val defaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler(null) // 기존 핸들러 제거
        Thread.setDefaultUncaughtExceptionHandler(
            ErratumExceptionHandler(
                application = application,
                defaultExceptionHandler = defaultExceptionHandler,
                registerExceptionActivityIntent = registerExceptionActivityIntent
            )
        )
    }
}
