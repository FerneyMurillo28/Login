package com.example.login.navigation

import androidx.navigation.compose.NamedNavArgument

sealed class AppScreens(
    val ruta:String,
    val  arguments: List<NamedNavArgument>){
    object LoginScreen:AppScreens(ruta="loginScreen", emptyList())
    object RegistrationScreen:AppScreens(ruta="RegistrationScreen",emptyList())
    object HomeScreen:AppScreens(ruta="homeScreen",emptyList())
}
