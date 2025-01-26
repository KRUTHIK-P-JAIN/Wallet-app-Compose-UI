package com.example.walletappuiincompose.data.api

import com.example.walletappuiincompose.data.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("31fbb1e2-9b97-473e-b0d7-a86c6f04af08")
    suspend fun getData(): Response<ApiResponse>
}