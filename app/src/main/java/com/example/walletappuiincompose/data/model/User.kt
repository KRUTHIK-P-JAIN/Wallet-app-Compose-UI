package com.example.walletappuiincompose.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("balance")
    val balance: Double = 4453.00,

    @SerializedName("card")
    val card: Card = Card()
)