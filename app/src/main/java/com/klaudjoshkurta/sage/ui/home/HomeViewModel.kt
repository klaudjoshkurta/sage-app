package com.klaudjoshkurta.sage.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.klaudjoshkurta.sage.network.AdviceApi
import kotlinx.coroutines.launch
import retrofit2.HttpException

class HomeViewModel : ViewModel() {

    var homeUiState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    init {
        getRandomAdvice()
    }

    fun getRandomAdvice() {
        viewModelScope.launch {
            homeUiState = HomeUiState.Loading
            homeUiState = try {
                HomeUiState.Success(AdviceApi.retrofitService.getRandomAdvice())
            } catch (e: Exception) {
                HomeUiState.Error
            } catch (e: HttpException) {
                HomeUiState.Error
            }
        }
    }
}