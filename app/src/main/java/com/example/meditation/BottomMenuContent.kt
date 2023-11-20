package com.example.meditation

import androidx.annotation.DrawableRes
import androidx.compose.ui.Modifier


data class BottomMenuContent(
    val title: String,
    @DrawableRes val iconId: Int,
    val modifier: Modifier

)