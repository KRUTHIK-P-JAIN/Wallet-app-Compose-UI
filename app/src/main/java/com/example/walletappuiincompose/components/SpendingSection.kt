package com.example.walletappuiincompose.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.walletappuiincompose.R
import com.example.walletappuiincompose.randomColor

@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SpendingSection() {
    //column was not used in referenced video, looks fine. but I had use column then only the ui was intact. know why?
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Spending Breakdown",
            fontSize = 25.sp,
            fontFamily = Font(R.font.play).toFontFamily(),
            modifier = Modifier.padding(horizontal = 22.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(spendingItems) {
                SpendingItems(it)
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
    }
}

@Composable
fun SpendingItems(
    spendingItem: SpendingItem
) {
    ElevatedCard(
        modifier = Modifier.size(150.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)// need to understand this
                .background(spendingItem.color.copy(0.5f))
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = spendingItem.icon,
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

val spendingItems = listOf(
    SpendingItem(
        name = "Food",
        amount = 123f,
        color = randomColor(),
        icon = Icons.Rounded.Restaurant
    ),
    SpendingItem(
        name = "Shopping",
        amount = 166f,
        color = randomColor(),
        icon = Icons.Rounded.ShoppingBag
    ),
    SpendingItem(
        name = "Subscriptions",
        amount = 84f,
        color = randomColor(),
        icon = Icons.Rounded.Subscriptions
    ),
    SpendingItem(
        name = "Health",
        amount = 140f,
        color = randomColor(),
        icon = Icons.AutoMirrored.Rounded.DirectionsRun
    )
)

data class SpendingItem(
    val name: String,
    val amount: Float,
    val color: Color,
    val icon: ImageVector
)