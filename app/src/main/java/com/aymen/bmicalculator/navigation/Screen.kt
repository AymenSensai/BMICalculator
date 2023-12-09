package com.aymen.bmicalculator.navigation

sealed class Screen(val route: String){
    data object Home : Screen("home")
    data object Score : Screen("score")
}
