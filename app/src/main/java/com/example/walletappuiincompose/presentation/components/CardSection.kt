package com.example.walletappuiincompose.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.walletappuiincompose.R
import com.example.walletappuiincompose.data.model.User

@Preview
@Composable
fun CardSectionPreview() {
    CardSection(user = User())
}

@Composable
fun CardSection(user: User) {
    Box {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(
                    brush = Brush.horizontalGradient(listOf(Color.Green, Color.Yellow))
                )
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp, 10.dp)
                .height(240.dp),
            elevation = CardDefaults.cardElevation(6.dp),
            shape = RoundedCornerShape(20.dp),
        ) {
            CardContent(Modifier.fillMaxSize(), user)
        }
    }
}

@Composable
fun CardContent(modifier: Modifier = Modifier, user: User) {
    Box(
        modifier = modifier
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.error
                    )
                )
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.world),
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.background.copy(0.1f)),
            modifier = Modifier
                .fillMaxSize()
                /*
                offset is a modifier used to shift or translate a composable's position by
                a specific amount along the x and y axes. It helps you move UI elements within
                their parent layout without affecting other elements' positions.
                 */
                .offset(150.dp, 80.dp)
        )
        Column(
            modifier = Modifier
                .padding(top = 22.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.my_balance),
                color = MaterialTheme.colorScheme.onPrimary.copy(0.6f),
                fontSize = 22.sp,
                fontFamily = Font(R.font.play).toFontFamily()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "$${user.balance}",
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 40.sp,
                fontFamily = Font(R.font.play).toFontFamily()
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(22.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = "* * * * ${user.card.last4}",
                color = MaterialTheme.colorScheme.onPrimary.copy(0.8f),
                fontSize = 23.sp,
                fontFamily = Font(R.font.play).toFontFamily()
            )
            Icon(
                painter = painterResource(id = R.drawable.visa),
                contentDescription = stringResource(R.string.visa),
                modifier = Modifier
                    .size(100.dp)
                    .offset(y = 30.dp), // offset was not used in referenced video. know why?
                tint = MaterialTheme.colorScheme.background
            )
        }
    }
}
