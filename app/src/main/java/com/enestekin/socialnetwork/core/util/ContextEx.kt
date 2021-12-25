package com.enestekin.socialnetwork.core.util

import android.content.Context
import android.content.Intent
import com.enestekin.socialnetwork.R

fun Context.sendSharePostIntent(postId: String) {
   val intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(
            Intent.EXTRA_TEXT,
        getString(
            R.string.share_intent_text,
        "https://pl-coding.com/$postId"
        )
        )
        type = "text/plain"
    }
    if (intent.resolveActivity(packageManager) != null){
       startActivity(Intent.createChooser(intent, "Select an app "))
    }
}