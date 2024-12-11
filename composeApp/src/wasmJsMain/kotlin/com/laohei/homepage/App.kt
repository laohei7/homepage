package com.laohei.homepage

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import com.laohei.homepage.screen.HomePage
import com.laohei.homepage.ui.theme.SansFont

@Composable
fun App() {
    MaterialTheme(
        typography = Typography(SansFont())
    ) {
        HomePage()
    }
}