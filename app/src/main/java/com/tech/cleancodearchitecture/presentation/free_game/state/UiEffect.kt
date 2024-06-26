package com.tech.cleancodearchitecture.presentation.free_game.state

sealed class UiEffect {
    class ShowSnackBar(val msg : String) : UiEffect()
    object NavigateToDetailScreen : UiEffect()
}
