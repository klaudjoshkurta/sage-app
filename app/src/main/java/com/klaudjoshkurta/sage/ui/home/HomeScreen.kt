package com.klaudjoshkurta.sage.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen() {

    val homeViewModel: HomeViewModel = viewModel()
    val homeUiState = homeViewModel.homeUiState

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            when (homeUiState) {
                is HomeUiState.Success -> {
                    Text(
                        text = homeUiState.advice.slip.advice,
                        color = Color.Black
                    )
                }
                is HomeUiState.Error -> {
                    Text(text = "Error")
                }
                is HomeUiState.Loading -> {
                    Text(text = "Loading")
                }
            }
        }
    }
}