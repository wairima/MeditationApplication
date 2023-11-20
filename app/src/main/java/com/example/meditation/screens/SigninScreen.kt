package com.example.meditation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController
import com.example.meditation.R
import com.example.meditation.navigation.ROUTE_HOME
import com.example.meditation.navigation.ROUTE_SIGNIN
import com.example.meditation.navigation.ROUTE_SIGNUP

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SigninScreen(navController : NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }

    fun signIn() {
        userName = email
    }


    Image(
        painter = painterResource(id = R.drawable.bg_image),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome Back",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(40.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text(text = "Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text(text = "Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = { /* handle login */navController.navigate(
                ROUTE_HOME
            )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Sign In",
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.ExtraBold,)
        }
//
//        Button(
//            onClick = { /* handle login */navController.navigate(
//                ROUTE_MPESA
//            ) },
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text(text = "Please make payment for registration")
//        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Don't have an account? Sign up",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            color = androidx.compose.ui.graphics.Color.Black,
            modifier = Modifier.clickable { /* handle navigation to sign up screen */ navController.navigate(
                ROUTE_SIGNUP
            )
            }
        )

//        Spacer(modifier = Modifier.height(40.dp))
//
//        SignUpWithGoogle()
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//        SignUpWithFacebook()
//    }
//}

//@Composable
//fun SignUpWithGoogle() {
//    Button(
//        onClick = { /* handle Google sign up */ },
//        modifier = Modifier.fillMaxWidth(),
//        colors = ButtonDefaults.buttonColors(
//            androidx.compose.ui.graphics.Color.Blue // change this line for your desired color
//        )
//    )
//    {
//        Image(
//            painter = painterResource(id = R.drawable.google_logo),
//            contentDescription = "Google Logo",
//            modifier = Modifier.size(24.dp)
//        )
//
//        Spacer(modifier = Modifier.width(8.dp))
//
//        Text(text = "Sign In with Google")
//    }
//}
//
//@Composable
//fun SignUpWithFacebook() {
//    Button(
//        onClick = { /* handle Facebook sign up */ },
//        modifier = Modifier.fillMaxWidth(),
//        colors = ButtonDefaults.buttonColors(
//            androidx.compose.ui.graphics.Color.Blue
//        )
//    ) {
//        Image(
//            painter = painterResource(id = R.drawable.facebook_logo),
//            contentDescription = "Facebook Logo",
//            modifier = Modifier.size(24.dp)
//        )
//
//        Spacer(modifier = Modifier.width(8.dp))
//
//        Text(text = "Sign In with Facebook")
//    }
//}
    }
    }
@Preview
@Composable
fun SigninScreenprev() {
    SigninScreen(rememberNavController())
}