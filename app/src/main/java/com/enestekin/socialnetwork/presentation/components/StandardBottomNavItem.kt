package com.enestekin.socialnetwork.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enestekin.socialnetwork.presentation.ui.theme.HintGray
import com.enestekin.socialnetwork.presentation.ui.theme.SpaceMedium
import com.enestekin.socialnetwork.presentation.ui.theme.SpaceSmall


@Composable
@Throws(IllegalArgumentException::class)
fun RowScope.StandardBottomNavItem( // only need this in RowScope
    icon: ImageVector,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    selected: Boolean = false,
    alertCount: Int? = null,
    selectedColor: Color = MaterialTheme.colors.primary,
    unSelectedColor: Color = HintGray,
    enabled: Boolean = true,
    onClick: () -> Unit

) {

    // The same as require fun
    if (alertCount != null && alertCount < 0) {
        throw  IllegalArgumentException("Alert count can't be negative")
    }
//    alertCount?.let {
//        require(alertCount >= 0)
//    }


    BottomNavigationItem(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        selectedContentColor = selectedColor,
        unselectedContentColor = unSelectedColor,
        icon = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(SpaceSmall)
                    //drawing line under selected
                    .drawBehind {
                        if (selected) {
                            drawLine(
                                color = if (selected) selectedColor else unSelectedColor,
                                start = Offset(
                                    size.width / 2f - 15.dp.toPx(),
                                    size.height
                                ),// coordinate system starts top left
                                end = Offset(
                                    size.width / 2f + 15.dp.toPx(),
                                    size.height
                                ),
                                strokeWidth = 2.dp.toPx(),
                                cap = StrokeCap.Round


                            )
                        }

                    }
            ) {
                Icon(
                    imageVector = icon, contentDescription = contentDescription,
                    modifier = Modifier.align(Alignment.Center)
                )

                if (alertCount != null) {
                    val alertText = if (alertCount > 99) {
                        "99+"
                    } else {
                        " ${alertCount.toString()}"
                    }
                    Text(
                        text = alertText,
                        color = MaterialTheme.colors.onPrimary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp,
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .offset(10.dp)
                            .size(16.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colors.primary)
                    )
                }
            }

        }
    )


}