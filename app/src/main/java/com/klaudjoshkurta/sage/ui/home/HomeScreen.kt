@file:OptIn(ExperimentalMaterial3Api::class)

package com.klaudjoshkurta.sage.ui.home

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.klaudjoshkurta.sage.R
import com.klaudjoshkurta.sage.ui.components.AdviceBox
import com.klaudjoshkurta.sage.ui.components.MenuSheet

@Composable
fun HomeScreen(
    sharedPreferences: SharedPreferences
) {

    val homeViewModel: HomeViewModel = viewModel()
    val homeUiState = homeViewModel.homeUiState
    val context = LocalContext.current
    var showMenu by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_logo),
                    contentDescription = null,
                    modifier = Modifier.padding(top = 24.dp),
                    tint = Color.Black
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                when (homeUiState) {
                    is HomeUiState.Success -> AdviceBox(
                        advice = homeUiState.advice,
                        onShareClick = {
                            shareAdvice(
                                context = context,
                                advice = homeUiState.advice.slip.advice
                            )
                        }
                    )
                    is HomeUiState.Error -> LoadingState()
                    is HomeUiState.Loading -> LoadingState()
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(
                    onClick = {
                        homeViewModel.getRandomAdvice()
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_arrow_clockwise),
                        contentDescription = null,
                        tint = Color.Black
                    )
                }
            }
        }
    }
}

@Composable
fun LoadingState() {
    CircularProgressIndicator(
        modifier = Modifier.width(64.dp),
    )
}

private fun shareAdvice(
    context: Context,
    advice: String
) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, advice)
    }
    context.startActivity(
        Intent.createChooser(
            intent,
            context.getString(R.string.share_advice)
        )
    )
}