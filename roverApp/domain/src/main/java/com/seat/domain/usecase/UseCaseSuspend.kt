package com.seat.domain.usecase

interface UseCaseSuspend<Params, Return> {
    suspend operator fun invoke(params: Params): Return
}
