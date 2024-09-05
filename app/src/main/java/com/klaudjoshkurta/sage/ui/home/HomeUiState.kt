package com.klaudjoshkurta.sage.ui.home

import com.klaudjoshkurta.sage.model.Advice

interface HomeUiState {
    data class Success(val advice: Advice) : HomeUiState
    object Error : HomeUiState
    object Loading : HomeUiState
}
