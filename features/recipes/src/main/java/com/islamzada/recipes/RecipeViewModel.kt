package com.islamzada.recipes

import androidx.lifecycle.MutableLiveData
import com.islamzada.common.base.BaseViewModel
import com.islamzada.common.flowstate.Resource
import com.islamzada.common.flowstate.State
import com.islamzada.domain.mapper.RecipeToUIStateMapper
import com.islamzada.domain.usecase.RecipeUseCase
import com.islamzada.entities.uimodel.RecipeUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    val recipeUseCase : RecipeUseCase,
    private val mapper: RecipeToUIStateMapper
) : BaseViewModel() {
    val data = MutableLiveData<RecipeUIState?>()

    suspend fun getFlights() {
        recipeUseCase.getList().collectLatest {
            when(it) {
                is Resource.Error -> state.emit(State.error(it.message))
                is Resource.Loading -> state.emit(State.loading())
                is Resource.Success -> {
                    state.emit(State.success())
                    it.data?.let { recipes ->
                        val result = mapper.map (recipes)
                        data.postValue(result)
                    }
                }
            }
        }
    }
}