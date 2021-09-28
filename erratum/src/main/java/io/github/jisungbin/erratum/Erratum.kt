/**
 * erratum is licensed under MIT
 * Please see: https://github.com/jisungbin/erratum/blob/master/LICENSE
 */

package io.github.jisungbin.erratum

import android.app.Application

object Erratum {
    fun setup(application: Application) {
        val defaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler(null) // 기존 핸들러 제거
        Thread.setDefaultUncaughtExceptionHandler(
            ErratumExceptionHandler(
                application = application,
                defaultExceptionHandler = defaultExceptionHandler
            )
        )
    }
}
