package com.klaudjoshkurta.sage.ui.home

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.klaudjoshkurta.sage.R
import com.klaudjoshkurta.sage.ui.components.AdviceBox

@Composable
fun HomeScreen() {

    val homeViewModel: HomeViewModel = viewModel()
    val homeUiState = homeViewModel.homeUiState
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomBar(
                onNewAdviceClick = {
                    homeViewModel.getRandomAdvice()
                },
                onShareClick = {
                    shareAdvice(
                        context = context,
                        advice = (homeUiState as HomeUiState.Success).advice.slip.advice
                    )
                }
            )
        },
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
                is HomeUiState.Success -> AdviceBox(advice = homeUiState.advice)
                is HomeUiState.Error -> {
                    Text(
                        text = "Error",
                        color = Color.Black
                    )
                }
                is HomeUiState.Loading -> {
                    Text(
                        text = "Loading",
                        color = Color.Black
                    )
                }
            }
        }
    }
}

@Composable
fun TopBar(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth().padding(24.dp).statusBarsPadding(),
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_logo),
            contentDescription = null,
            tint = Color.Black
        )
    }
}

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    onNewAdviceClick: () -> Unit,
    onShareClick: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth().padding(horizontal = 24.dp, vertical = 24.dp).navigationBarsPadding(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "Tap for more",
            color = Color.Black,
            modifier = Modifier.clickable { onNewAdviceClick() }
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(R.drawable.ic_share),
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(24.dp).clickable { onShareClick() }
        )
    }
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