package com.example.walletappuiincompose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.walletappuiincompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewTopBar() {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    TopBar(
        modifier = Modifier.fillMaxWidth(),
        scrollBehaviour = scrollBehavior
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier,
    scrollBehaviour: TopAppBarScrollBehavior
) {
    TopAppBar(
        scrollBehavior = scrollBehaviour,
        title = {
            Box(
                modifier = modifier.padding(end = 22.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(40.dp)
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .align(Alignment.CenterStart) // vertically - center, horizontally - left
                )
                Text(
                    text = "Wallet",
                    modifier = Modifier.padding(start = 12.dp),
                    fontSize = 40.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontFamily = FontFamily(Font(R.font.play))
                )
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "profile image",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .clip(RoundedCornerShape(12.dp))
                        .size(50.dp)
                )
            }
        }
    )
}