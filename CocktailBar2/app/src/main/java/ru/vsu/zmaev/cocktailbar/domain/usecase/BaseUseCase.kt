package ru.vsu.zmaev.cocktailbar.domain.usecase

interface BaseUseCase<in Params, out Result> {
     suspend fun execute(params: Params): Result
}