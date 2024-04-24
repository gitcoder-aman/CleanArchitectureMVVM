package com.tech.cleancodearchitecture.data.repository

import com.tech.cleancodearchitecture.core.common.Resource
import com.tech.cleancodearchitecture.data.remote.FreeGameApi
import com.tech.cleancodearchitecture.data.remote.mapper.toDomainFreeGames
import com.tech.cleancodearchitecture.domain.model.FreeGames
import com.tech.cleancodearchitecture.domain.repository.FreeGamesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FreeGamesRepositoryImpl @Inject constructor(
    private val freeGameApi: FreeGameApi
) : FreeGamesRepository {
    override fun getFreeGames(): Flow<Resource<List<FreeGames>>> = flow {
        emit(Resource.Loading())

        val result = freeGameApi.getFreeGameList().map {
            it.toDomainFreeGames()
        }
        emit(Resource.Success(result))

    }.flowOn(Dispatchers.IO)
        .catch {
            emit(Resource.Error(it.message.toString()))
        }
}