package com.example.meditation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.meditation.R


@Composable
fun Intentscreen(navController:NavHostController) {
     val context= LocalContext.current
    Image(
        painter = painterResource(id = R.drawable.mpesa),
        contentDescription = "payments",
        modifier = Modifier.fillMaxSize()
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
//            .background(Color.DarkGray)
    ) {
       Text(text = "Pay ksh200 for Registration to 07******873",
           modifier = Modifier
               .align(Alignment.CenterHorizontally,),
           color = Color.Black,
           fontSize = 30.sp,
           fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { /*TODO*/
            val simToolKitLaunchIntent =
                context.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { context.startActivity(it) } },
            colors = ButtonDefaults.buttonColors(Color.LightGray),
            shape = CircleShape,
            modifier = Modifier
                .width(450.dp)
                .height(55.dp)
        ) {
            Text(text = "MPESA",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color= Color.Black)




    }
}
}

@Preview
@Composable
fun Intentscreenprev() {
    Intentscreen(rememberNavController()
    )
}
