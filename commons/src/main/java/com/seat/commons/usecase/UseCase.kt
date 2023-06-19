package com.seat.commons.usecase

interface UseCase<Params, Return> {
    operator fun invoke(params: Params): Return
}
