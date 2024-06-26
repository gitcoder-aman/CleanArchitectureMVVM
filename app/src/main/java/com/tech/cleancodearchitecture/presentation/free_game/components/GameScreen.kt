package com.tech.cleancodearchitecture.presentation.free_game.components

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tech.cleancodearchitecture.presentation.free_game.state.FreeGameState

@Composable
fun GameScreen(
    freeGameState: FreeGameState, modifier: Modifier
) {
    Log.i("@@GameScreen", "GameScreen: ${freeGameState.freeGames?.size}")
    if (freeGameState.freeGames?.isNotEmpty()!!) {
        LazyColumn {
            items(freeGameState.freeGames) {
                FreeGameItem(modifier, it)
            }
        }
    } else if (freeGameState.isLoading) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}