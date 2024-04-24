package com.tech.cleancodearchitecture.domain.usecase

import com.tech.cleancodearchitecture.domain.repository.FreeGamesRepository
import javax.inject.Inject

class FreeGameUseCase @Inject constructor(
    private val repository: FreeGamesRepository
) {
    operator fun invoke() = repository.getFreeGames()
}