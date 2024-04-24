package com.tech.cleancodearchitecture.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tech.cleancodearchitecture.presentation.free_game.components.GameScreen
import com.tech.cleancodearchitecture.presentation.free_game.state.UiEffect
import com.tech.cleancodearchitecture.presentation.free_game.viewmodel.FreeGameViewModel
import com.tech.cleancodearchitecture.presentation.navigation.screens.Screen
import kotlinx.coroutines.flow.collectLatest

@Composable
fun Navigation(navController: NavHostController) {
    val snackBarHostState = remember {
        SnackbarHostState()
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackBarHostState)}
    ) {
        NavHost(navController = navController, startDestination = Screen.GameScreen.route,modifier = Modifier.padding(it)){
            composable(Screen.GameScreen.route){
                val freeGameViewModel = hiltViewModel<FreeGameViewModel>()
                val freeGameState = freeGameViewModel.freeGameState.collectAsStateWithLifecycle()  //retain data when change orientation of mobile



                GameScreen(freeGameState = freeGameState.value,modifier = Modifier)
                LaunchedEffect(key1 = true) {
                    freeGameViewModel.uiEffect.collectLatest {
                        when(it){
                            UiEffect.NavigateToDetailScreen -> TODO()
                            is UiEffect.ShowSnackBar -> {
                                snackBarHostState.showSnackbar(it.msg, duration = SnackbarDuration.Long)
                            }

                        }
                    }
                }
            }
        }
    }
}