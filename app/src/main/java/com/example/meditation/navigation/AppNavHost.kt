package com.example.meditation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.meditation.screens.MeditationSoundList
import com.example.meditation.screens.Musicscreen
import com.example.meditation.screens.NightIslandScreen
import com.example.meditation.screens.ProfileScreen
import com.example.meditation.screens.SigninScreen
import com.example.meditation.screens.SignupScreen
import com.example.meditation.screens.SleepMeditationScreen
import com.example.meditation.screens.SleepingTipsList
import com.example.meditation.ui.theme.HomeScreen


@Composable
fun AppNavHost(modifier: Modifier=Modifier,navController:NavHostController= rememberNavController(),startDestination:String= ROUTE_SIGNIN) {

    NavHost(navController = navController, modifier=modifier, startDestination = startDestination ){
        composable(ROUTE_SIGNIN){
            SigninScreen(navController)
        }

        composable(ROUTE_SIGNUP){
            SignupScreen(navController)
        }

        composable(ROUTE_HOME){
            HomeScreen(navController)
        }
//        composable(ROUTE_MPESA){
//            Intentscreen(navController)
//        }

        composable(ROUTE_MUSIC){
            Musicscreen(navController)
        }

        composable(Tip_for_sleeping){
            SleepingTipsList(navController)
        }

        composable(NightIslandScreen1){
            NightIslandScreen(navController)
        }

        composable(MeditationSoundList1){
            MeditationSoundList(navController)
        }

        composable(ROUTE_PROFILE){
            ProfileScreen(navController, userId = null)
        }

        composable(SleepMeditationScreen1){
            SleepMeditationScreen(navController)
        }

//        composable(ROUTE_HOME) { com.example.meditation.screens.HomeScreen(navController) }
        composable("profile/{userId}") { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")
            ProfileScreen(navController, userId = null)
        }
//        composable("songList") {
//            SongsList(
//                songsList = songsList
//            )
//        }
    }
}

fun Profilescreen(user: NavHostController) {}

//fun Musicscreen(navController: NavHostController) {}
