package com.example.walletappuiincompose.data.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("user")
    val user: User,

    @SerializedName("spendingBreakdown")
    val spendingBreakdown: List<SpendingBreakdown>,

    @SerializedName("spendingStatistics")
    val spendingStatistics: List<SpendingStatistic>
)