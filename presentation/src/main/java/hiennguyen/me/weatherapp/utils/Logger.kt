package hiennguyen.me.weatherapp.utils

import android.os.Build
import android.util.Log
import hiennguyen.me.weatherapp.BuildConfig
import java.util.regex.Pattern

object Logger {

    fun v(tag: String = callerTag(), message: String) = inDebug {
        Log.v(tag, message)
    }

    fun v(tag: String = callerTag(), message: String, throwable: Throwable) = inDebug {
        Log.v(tag, message, throwable)
    }

    fun d(tag: String = callerTag(), message: String) = inDebug {
        Log.d(tag, message)
    }

    fun d(tag: String = callerTag(), message: String, throwable: Throwable) = inDebug {
        Log.d(tag, message, throwable)
    }

    fun i(tag: String = callerTag(), message: String) = inDebug {
        Log.i(tag, message)
    }

    fun i(tag: String = callerTag(), message: String, throwable: Throwable) = inDebug {
        Log.i(tag, message, throwable)
    }

    fun w(tag: String = callerTag(), message: String) = inDebug {
        Log.w(tag, message)
    }

    fun w(tag: String = callerTag(), message: String, throwable: Throwable) = inDebug {
        Log.w(tag, message, throwable)
    }

    fun e(tag: String = callerTag(), message: String) = inDebug {
        Log.e(tag, message)
    }

    fun e(tag: String = callerTag(), message: String, throwable: Throwable) = inDebug {
        Log.e(tag, message, throwable)
    }

    fun wtf(tag: String = callerTag(), message: String) = inDebug {
        Log.wtf(tag, message)
    }

    fun wtf(tag: String = callerTag(), message: String, throwable: Throwable) = inDebug {
        Log.wtf(tag, message, throwable)
    }

    private inline fun inDebug(action: () -> Unit) {
        if (BuildConfig.DEBUG) {
            action()
        }
    }

    const private val MAX_TAG_LENGTH = 23
    const private val CALL_STACK_INDEX = 2
    val ANONYMOUS_CLASS =  Pattern.compile("(\\$\\d+)+$")

    /**
     * @return The class name for the calling class as a String.
     */
    private fun callerTag(): String {
        val stackTrace = Throwable().stackTrace
        val callerElement = stackTrace[CALL_STACK_INDEX]
        var tag = callerElement.className
        val matcher = ANONYMOUS_CLASS.matcher(tag)

        if (matcher.find()) {
            tag = matcher.replaceAll("")
        }
        tag = tag.substring(tag.lastIndexOf('.') + 1)

        // Tag length limit was removed in API 24.
        return if (tag.length <= MAX_TAG_LENGTH || Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tag
        } else tag.substring(0, MAX_TAG_LENGTH)
    }
}