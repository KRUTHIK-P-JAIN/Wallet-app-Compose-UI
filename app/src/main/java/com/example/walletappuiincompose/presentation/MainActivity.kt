package com.example.walletappuiincompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.walletappuiincompose.data.model.ApiResponse
import com.example.walletappuiincompose.presentation.components.ActionsSection
import com.example.walletappuiincompose.presentation.components.CardSection
import com.example.walletappuiincompose.presentation.components.SpendingGraph
import com.example.walletappuiincompose.presentation.components.SpendingSection
import com.example.walletappuiincompose.presentation.components.TopBar
import com.example.walletappuiincompose.presentation.ui.theme.WalletAppUIInComposeTheme
import com.example.walletappuiincompose.presentation.viewmodel.ViewModel
import com.example.walletappuiincompose.utils.ResponseState
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: ViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WalletAppUIInComposeTheme {
                // scrollBehaviour for collapsing toolbar effect
                val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
                    state = rememberTopAppBarState()
                )

                // Scaffold for topBar
                Scaffold(
                    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                    topBar = {
                        TopBar(
                            modifier = Modifier.fillMaxWidth(),
                            scrollBehaviour = scrollBehavior
                        )
                    }
                ) { paddingValues ->
                    MainScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                        viewModel
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier, viewModel: ViewModel) {
    when (val data = viewModel.data.collectAsState().value) {
        is ResponseState.Loading -> {
            ProgressBar(modifier)
        }

        is ResponseState.Success -> {
            MainScreenUi(modifier, data.data)
        }

        is ResponseState.Error -> {
            ErrorUi(modifier, data)
        }
    }
}

@Composable
fun ErrorUi(modifier: Modifier, data: ResponseState.Error) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.BottomCenter)
            .padding(10.dp, 0.dp)
    ) {
        Snackbar(containerColor = Color.Red) {
            BasicText(text = data.message)
        }
    }
}

@Composable
fun MainScreenUi(modifier: Modifier, data: ApiResponse) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        CardSection(data.user)
        Spacer(modifier = Modifier.height(20.dp))
        ActionsSection()
        Spacer(modifier = Modifier.height(40.dp))
        SpendingSection(data.spendingBreakdown)
        Spacer(modifier = Modifier.height(40.dp))
        SpendingGraph(data.spendingStatistics)
        Spacer(modifier = Modifier.height(100.dp))
    }
}

@Composable
fun ProgressBar(modifier: Modifier) {
    Box(
        modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        CircularProgressIndicator(modifier = Modifier.size(40.dp))
    }
}

fun randomColor(minBrightness: Int = 80): Color {
    val random = Random.Default
    val red = random.nextInt(minBrightness, 256)
    val green = random.nextInt(minBrightness, 256)
    val blue = random.nextInt(minBrightness, 256)
    return Color(red, green, blue)
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
//    MainScreen()
}