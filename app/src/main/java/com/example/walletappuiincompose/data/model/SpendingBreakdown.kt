package com.example.walletappuiincompose.data.model

import com.google.gson.annotations.SerializedName

data class SpendingBreakdown(
    @SerializedName("name")
    val name: String,

    @SerializedName("amount")
    val amount: Float,

    @SerializedName("icon")
    val icon: String
)