package com.example.walletappuiincompose.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.walletappuiincompose.R
import com.example.walletappuiincompose.data.model.SpendingStatistic
import com.example.walletappuiincompose.presentation.randomColor
import me.bytebeats.views.charts.bar.BarChart
import me.bytebeats.views.charts.bar.BarChartData
import me.bytebeats.views.charts.bar.render.label.SimpleLabelDrawer
import me.bytebeats.views.charts.bar.render.xaxis.SimpleXAxisDrawer
import me.bytebeats.views.charts.bar.render.yaxis.SimpleYAxisDrawer

@Preview
@Composable
fun SpendingGraphPreview() {
    SpendingGraph(spendingStatistics = listOf(SpendingStatistic()))
}

@Composable
fun SpendingGraph(spendingStatistics: List<SpendingStatistic>) {
    //column was not used in referenced video, looks fine. but I had use column then only the ui was intact. know why?
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(22.dp)
    ) {
        Text(
            text = stringResource(R.string.spending_statistics),
            fontSize = 25.sp,
            fontFamily = Font(R.font.play).toFontFamily()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Graph(spendingStatistics)
    }
}

@Composable
fun Graph(spendingStatistics: List<SpendingStatistic>) {
    BarChart(
        barChartData = BarChartData(bars = getSpendingByDay(spendingStatistics)),
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

fun getSpendingByDay(spendingStatistics: List<SpendingStatistic>): List<BarChartData.Bar> {
    val spendingByDay = arrayListOf<BarChartData.Bar>()
    for (spendingStatistic in spendingStatistics) {
        spendingByDay.add(
            BarChartData.Bar(
                label = spendingStatistic.date,
                value = spendingStatistic.amount,
                color = randomColor(50),
            )
        )
    }
    return spendingByDay
}