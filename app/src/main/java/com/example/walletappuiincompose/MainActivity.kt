package com.example.walletappuiincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.walletappuiincompose.components.ActionsSection
import com.example.walletappuiincompose.components.CardSection
import com.example.walletappuiincompose.components.SpendingGraph
import com.example.walletappuiincompose.components.SpendingSection
import com.example.walletappuiincompose.components.TopBar
import com.example.walletappuiincompose.ui.theme.WalletAppUIInComposeTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
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
                            .padding(paddingValues)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        CardSection()
        Spacer(modifier = Modifier.height(20.dp))
        ActionsSection()
        Spacer(modifier = Modifier.height(40.dp))
        SpendingSection()
        Spacer(modifier = Modifier.height(40.dp))
        SpendingGraph()
        Spacer(modifier = Modifier.height(100.dp))
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
    MainScreen()
}