package com.laohei.homepage.component

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.laohei.homepage.ui.theme.primary
import com.laohei.homepage.ui.theme.secondary
import com.laohei.homepage.ui.theme.third

@Composable
fun Background() {
    val backgroundColors = remember {
        listOf(primary, secondary, third)
    }


    val infiniteTransition = rememberInfiniteTransition(label = "background")
    val targetOffset = with(LocalDensity.current) {
        1000.dp.toPx()
    }
    val offset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = targetOffset,
        animationSpec = infiniteRepeatable(
            tween(30000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "offset"
    )

    Box(
        modifier = Modifier.fillMaxSize()
            .blur(40.dp)
            .drawWithCache {
                val brushSize = 400f
                val brush = Brush.linearGradient(
                    colors = backgroundColors,
                    start = Offset(offset, offset),
                    end = Offset(offset + brushSize, offset + brushSize),
                    tileMode = TileMode.Mirror
                )
                onDrawBehind {
                    drawRect(brush)
                }
            })
}