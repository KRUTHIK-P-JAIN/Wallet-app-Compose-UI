package com.example.walletappuiincompose.data.model

import com.google.gson.annotations.SerializedName

data class Card(
    @SerializedName("last4")
    val last4: String = "5678"
)