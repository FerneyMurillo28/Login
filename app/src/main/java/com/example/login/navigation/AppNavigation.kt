package com.example.login.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login.presentation.login.LoginScreen
import com.example.login.presentation.registration.RegistrationScreen

@Composable
fun AppNavigation(){
    val navController= rememberNavController()
    NavHost(navController = navController,
        startDestination = AppScreens.LoginScreen.ruta){
        composable(route=AppScreens.LoginScreen.ruta){ LoginScreen(navController)}
        composable(route=AppScreens.RegistrationScreen.ruta){ RegistrationScreen(navController)}
    }
}