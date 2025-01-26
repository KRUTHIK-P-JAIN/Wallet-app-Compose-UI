package com.example.walletappuiincompose.usecase

import com.example.walletappuiincompose.data.model.ApiResponse
import com.example.walletappuiincompose.utils.ResponseState
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getData(): Flow<ResponseState<ApiResponse>>
}