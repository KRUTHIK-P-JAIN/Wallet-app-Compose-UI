package com.example.walletappuiincompose.data.model

import com.google.gson.annotations.SerializedName

data class SpendingStatistic(
    @SerializedName("date")
    val date: String = "Dec 1",

    @SerializedName("amount")
    val amount: Float = 123f
)