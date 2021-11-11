package com.enestekin.socialnetwork.core.util

import java.text.SimpleDateFormat
import java.util.*

object DateFormatUtil {

    fun timeStampToFormattedString(timestamp: Long, pattern: String): String {
        // apply reference to SimpleDateFormat  and return SimpleDateFormat
        // apply reference to SimpleDateFormat  but return last line lambda func
        return SimpleDateFormat(pattern, Locale.getDefault()).run {
            format(timestamp)
        }
    }
}