package com.seat.commons.usecase

interface UseCaseSuspend<Params, Return> {
    suspend operator fun invoke(params: Params): Return
}
