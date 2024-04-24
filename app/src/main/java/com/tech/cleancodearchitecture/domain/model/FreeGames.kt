package com.tech.cleancodearchitecture.domain.model

data class FreeGames(
    val gameUrl: String,
    val id: Int,
    val shortDescription: String,
    val thumbnail: String,
    val title: String
)