package com.enestekin.socialnetwork.util

import android.content.res.Resources
import android.util.TypedValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


fun Dp.toPx() : Float {

    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.value, // referring Dp
        Resources.getSystem().displayMetrics
    )
}

fun Float.toDp(): Dp{
    return  (this / Resources.getSystem().displayMetrics.density).dp
}