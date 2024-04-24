package com.tech.cleancodearchitecture.presentation.navigation.screens

sealed class Screen(
    val route : String
){
    object GameScreen : Screen("game_screen")
}