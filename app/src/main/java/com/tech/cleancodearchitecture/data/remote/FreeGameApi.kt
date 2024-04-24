package com.tech.cleancodearchitecture.data.remote

import com.tech.cleancodearchitecture.data.remote.dataTransferObject.FreeGamesDto
import retrofit2.http.GET

interface FreeGameApi {

    @GET("games")
    suspend fun getFreeGameList() : List<FreeGamesDto>
}