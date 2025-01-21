package com.example.walletappuiincompose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.walletappuiincompose.R
import com.example.walletappuiincompose.randomColor
import me.bytebeats.views.charts.bar.BarChart
import me.bytebeats.views.charts.bar.BarChartData
import me.bytebeats.views.charts.bar.render.label.SimpleLabelDrawer
import me.bytebeats.views.charts.bar.render.xaxis.SimpleXAxisDrawer
import me.bytebeats.views.charts.bar.render.yaxis.SimpleYAxisDrawer

@Preview
@Composable
fun SpendingGraph() {
    //column was not used in referenced video, looks fine. but I had use column then only the ui was intact. know why?
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(22.dp)
    ) {
        Text(
            text = "Spending Statistics",
            fontSize = 25.sp,
            fontFamily = Font(R.font.play).toFontFamily()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Graph()
    }
}

@Composable
fun Graph() {
    BarChart(
        barChartData = BarChartData(bars = spendingByDay),
        xAxisDrawer = SimpleXAxisDrawer(
            axisLineColor = MaterialTheme.colorScheme.onBackground.copy(0.2f),
            axisLineThickness = 2.dp
        ),
        yAxisDrawer = SimpleYAxisDrawer(
            labelTextColor = MaterialTheme.colorScheme.onBackground.copy(0.7f),
            axisLineColor = MaterialTheme.colorScheme.onBackground.copy(0.1f),
            drawLabelEvery = 3,
            labelValueFormatter = {
                "$ ${it.toInt()}"
            }
        ),
        labelDrawer = SimpleLabelDrawer(
            drawLocation = SimpleLabelDrawer.DrawLocation.Outside,
            labelTextSize = 15.sp,
            labelTextColor = MaterialTheme.colorScheme.onBackground.copy(0.7f)
        )
    )
}

val spendingByDay = listOf(
    BarChartData.Bar(
        label = "Dec 1",
        value = 123f,
        color = randomColor(50),
    ),
    BarChartData.Bar(
        label = "Dec 2",
        value = 160f,
        color = randomColor(50),
    ),
    BarChartData.Bar(
        label = "Dec 3",
        value = 204f,
        color = randomColor(50),
    ),
    BarChartData.Bar(
        label = "Dec 4",
        value = 34f,
        color = randomColor(50),
    ),
    BarChartData.Bar(
        label = "Dec 5",
        value = 74f,
        color = randomColor(50),
    )
)