package com.tech.cleancodearchitecture.data.remote.mapper

import com.tech.cleancodearchitecture.data.remote.dataTransferObject.FreeGamesDto
import com.tech.cleancodearchitecture.domain.model.FreeGames

fun FreeGamesDto.toDomainFreeGames() : FreeGames{
    return FreeGames(gameUrl,id, shortDescription, thumbnail, title)

}