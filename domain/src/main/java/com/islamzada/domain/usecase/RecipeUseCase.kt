package com.islamzada.domain.usecase

import com.islamzada.common.flowstate.Resource
import com.islamzada.data.repo.RecipeRepositoryInterface
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecipeUseCase @Inject constructor(
    private val repository : RecipeRepositoryInterface) {
    suspend fun getList() = flow {
        emit(Resource.Loading())
        repository.getRecipe()?.let {
            emit(Resource.Success(it))
        } ?: emit(Resource.Error("Empty message error"))
    }.catch { exception->
        emit(Resource.Error(exception.localizedMessage))
    }
}