package com.tech.cleancodearchitecture.presentation.free_game.state

import com.tech.cleancodearchitecture.domain.model.FreeGames

data class FreeGameState(
    val freeGames: List<FreeGames>? = emptyList(),
    val errorMsg : String? = "",
    val isLoading : Boolean = false
)
