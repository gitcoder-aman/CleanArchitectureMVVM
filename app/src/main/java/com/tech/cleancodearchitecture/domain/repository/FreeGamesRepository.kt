package com.tech.cleancodearchitecture.domain.repository

import com.tech.cleancodearchitecture.core.common.Resource
import com.tech.cleancodearchitecture.domain.model.FreeGames
import kotlinx.coroutines.flow.Flow

interface FreeGamesRepository {

    fun getFreeGames() : Flow<Resource<List<FreeGames>>>
}