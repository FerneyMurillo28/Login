package com.example.login.navigation

sealed class AppScreens(val ruta:String){
    object LoginScreen:AppScreens(ruta="loginScreen")
    object RegistrationScreen:AppScreens(ruta="RegistrationScreen")
}
