package com.example.walletappuiincompose.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.DirectionsRun
import androidx.compose.material.icons.rounded.Restaurant
import androidx.compose.material.icons.rounded.ShoppingBag
import androidx.compose.material.icons.rounded.Subscriptions
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.walletappuiincompose.R
import com.example.walletappuiincompose.data.model.SpendingBreakdown
import com.example.walletappuiincompose.presentation.randomColor

@Preview
@Composable
fun SpendingSectionPreview() {
    SpendingSection(spendingBreakdown = spendingItems)
}

@Composable
fun SpendingSection(spendingBreakdown: List<SpendingBreakdown>) {
    //column was not used in referenced video, looks fine. but I had use column then only the ui was intact. know why?
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.spending_breakdown),
            fontSize = 25.sp,
            fontFamily = Font(R.font.play).toFontFamily(),
            modifier = Modifier.padding(horizontal = 22.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(spendingBreakdown) {
                SpendingItems(it)
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
    }
}

@Composable
fun SpendingItems(
    spendingItem: SpendingBreakdown
) {
    ElevatedCard(
        modifier = Modifier.size(150.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)// need to understand this
                .background(randomColor().copy(0.5f))
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = getIcon(spendingItem.icon),
                contentDescription = spendingItem.name,
                tint = Color.Black.copy(0.8f),
                modifier = Modifier.size(33.dp)
            )
            Column {
                //rubik is default font for app so no need to add font family for text.
                Text(
                    text = spendingItem.name,
                    color = Color.Black.copy(0.7f),
                    fontSize = 15.sp
                )
                Text(
                    text = "$${spendingItem.amount}",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontFamily = Font(R.font.play).toFontFamily()
                )
            }
        }
    }
}

fun getIcon(icon: String): ImageVector {
    return when (icon) {
        "ic_fork_knife" -> Icons.Rounded.Restaurant
        "ic_shopping_bag" -> Icons.Rounded.ShoppingBag
        "ic_health" -> Icons.AutoMirrored.Rounded.DirectionsRun
        else -> Icons.Rounded.Subscriptions
    }
}

val spendingItems = listOf(
    SpendingBreakdown(
        name = "Food",
        amount = 123f,
        icon = "ic_fork_knife"
    ),
    SpendingBreakdown(
        name = "Shopping",
        amount = 166f,
        icon = "ic_shopping_bag"
    ),
    SpendingBreakdown(
        name = "Subscriptions",
        amount = 84f,
        icon = "ic_subscription"
    ),
    SpendingBreakdown(
        name = "Health",
        amount = 140f,
        icon = "ic_health"
    )
)