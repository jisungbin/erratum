package io.github.jisungbin.erratum

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.os.Process
import java.io.PrintWriter
import java.io.StringWriter
import kotlin.system.exitProcess

class ErratumExceptionHandler(
    application: Application,
    private val defaultExceptionHandler: Thread.UncaughtExceptionHandler?,
    private val registerExceptionActivityIntent: ((thread: Thread, throwable: Throwable, lastActivity: Activity) -> Intent)? = null
) : Thread.UncaughtExceptionHandler {

    private var activityCount = 0
    private var lastActivity: Activity? = null

    init {
        application.registerActivityLifecycleCallbacks(object :
                Application.ActivityLifecycleCallbacks {

                private fun Activity.isExceptionActivity() = this is ErratumExceptionActivity

                private fun registerActivity(activity: Activity) {
                    if (!activity.isExceptionActivity()) {
                        activityCount++
                        lastActivity = activity
                    }
                }

                private fun unregisterActivity(activity: Activity) {
                    if (!activity.isExceptionActivity()) {
                        if (--activityCount < 0) {
                            lastActivity = null
                        }
                    }
                }

                override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                    registerActivity(activity)
                }

                override fun onActivityStarted(activity: Activity) {
                    registerActivity(activity)
                }

                override fun onActivityStopped(activity: Activity) {
                    unregisterActivity(activity)
                }

                override fun onActivityDestroyed(activity: Activity) {}
                override fun onActivityResumed(activity: Activity) {}
                override fun onActivityPaused(activity: Activity) {}
                override fun onActivitySaveInstanceState(
                    activity: Activity,
                    savedInstanceBundle: Bundle
                ) {
                }
            })
    }

    override fun uncaughtException(thread: Thread, throwable: Throwable) {
        lastActivity?.run {
            registerExceptionActivityIntent?.invoke(thread, throwable, lastActivity)
            val stringWriter = StringWriter()
            throwable.printStackTrace(PrintWriter(stringWriter))
            startExceptionActivity(activity = this, exceptionString = stringWriter.toString())
        } ?: defaultExceptionHandler?.uncaughtException(thread, throwable)

        Process.killProcess(Process.myPid())
        exitProcess(-1)
    }

    private fun startExceptionActivity(activity: Activity, exceptionString: String) = activity.run {
        val exceptionActivityIntent =
            Intent(this, DefaultErratumExceptionActivity::class.java).apply {
                putExtra(ErratumExceptionActivity.EXTRA_LAST_ACTIVITY_INTENT, intent)
                putExtra(ErratumExceptionActivity.EXTRA_EXCEPTION_STRING, exceptionString)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            }
        startActivity(exceptionActivityIntent)
        finish()
    }
}
