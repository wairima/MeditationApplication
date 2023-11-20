package com.example.meditation.data

import androidx.compose.ui.graphics.painter.Painter


data class User(
    val name: String,
    val age: Int,
    val bio: String,
    val profilePicture: Painter,
    val address: String,
    val email: String,
    val phoneNumber: String
)

