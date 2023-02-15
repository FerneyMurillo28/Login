package com.example.login.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login.presentation.login.LoginScreen
import com.example.login.presentation.login.LoginViewModel
import com.example.login.presentation.registration.RegisterViewModel
import com.example.login.presentation.registration.RegistrationScreen
import com.example.login.screens.HomeScreen

@SuppressLint("SuspiciousIndentation")
@Composable
fun AppNavigation(){
    val navController= rememberNavController()
    NavHost(navController = navController,
        startDestination = AppScreens.LoginScreen.ruta ){
        composable(route = AppScreens.LoginScreen.ruta){
        val viewModel=LoginViewModel()
        if(viewModel.state.value.successLogin){
            LaunchedEffect(key1 = Unit ){
                navController.navigate((AppScreens.HomeScreen.ruta))
                {
                    popUpTo(AppScreens.LoginScreen.ruta){
                        inclusive=true
                    }
                }
            }
        }else{
            LoginScreen(
                navController,
                state=viewModel.state.value,
                onLogin = viewModel::login,
                onDismissDiolog = viewModel::hideErrorDialog,
                onNavigateToRegister = {navController.navigate((AppScreens.RegistrationScreen.ruta))}
            )
        }
        }
        composable(route = AppScreens.RegistrationScreen.ruta){
            val viewModel=RegisterViewModel()
            RegistrationScreen(
                navController,
                state =  viewModel.state.value,
                onRegister = viewModel::register,
                onBack = {navController.popBackStack()},
                onDismissDialog =viewModel::hideErrorDialog)
        }
        composable(route = AppScreens.HomeScreen.ruta){ HomeScreen(navController) }
    }
}//finFun