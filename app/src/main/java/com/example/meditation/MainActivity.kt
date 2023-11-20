package com.example.meditation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.meditation.navigation.AppNavHost
import com.example.meditation.ui.theme.HomeScreen
import com.example.meditation.ui.theme.MeditationTheme

class MainActivity : ComponentActivity() {

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeditationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

//                    HomeScreen()
                   AppNavHost()
//                    val user = User(
//                        name = "John Doe",
//                        age = 28,
//                        profilePicture = painterResource(id = R.drawable.profile_picture),
//                        bio = "Full stack developer who loves kotlin and Android"
//                    )
//                    Profilescreen(user = user)
                    
//                    Musicscreen(songsList = songsList)
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeSreenprev() {
    HomeScreen(rememberNavController())
}
