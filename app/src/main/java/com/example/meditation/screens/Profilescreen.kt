package com.example.meditation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.meditation.R
import com.example.meditation.data.User
import com.example.meditation.navigation.ROUTE_HOME

@Composable
fun ProfileScreen(navController: NavHostController, userId: String?) {
    // Fetch user details using userId

    val user = User(
        name = "TINAH",
        age = 28,
        bio = "Android developer at Google",
        profilePicture = painterResource(id = R.drawable.profile_picture),
        address = "123 Main Street, City, State, USA",
       email = "tinah@example.com",
       phoneNumber = "+1 (123) 456-7890"
    )


    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background_image2),
            contentDescription = "Background image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds


        )

        ProfileContent(user = user, onBackClick = { navController.navigate(ROUTE_HOME) })
    }
}

@Composable
fun ProfileContent(user: User, onBackClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = user.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = user.bio,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = user.address,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = user.email,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = user.phoneNumber,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier.padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { /* Save */ }) {
                Icon(Icons.Default.AddCircle, contentDescription = "Save")
            }

            IconButton(onClick = { /* Edit */ }) {
                Icon(Icons.Default.Edit, contentDescription = "Edit")
            }

            IconButton(onClick = { /* Delete */ }) {
                Icon(Icons.Default.Delete, contentDescription = "Delete", tint = Color.Red)
            }
        }

        Button(onClick = onBackClick) {
            Text(text = "Go Back")
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    val user = User(
        name = "TINAH",
        age = 28,
        bio = "Android developer at Google",
        profilePicture = painterResource(id = R.drawable.profile_picture),
        address = "123 Main Street, City, State, USA",
        email = "tinah@example.com",
        phoneNumber = "+1 (123) 456-7890"
    )

    ProfileContent(user = user, onBackClick = {})
}
