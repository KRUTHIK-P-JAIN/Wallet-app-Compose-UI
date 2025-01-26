package com.example.walletappuiincompose.data.repository

import android.util.Log
import com.example.walletappuiincompose.data.api.Api
import com.example.walletappuiincompose.usecase.Repository
import com.example.walletappuiincompose.utils.ResponseState
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val api: Api) : Repository {
    override suspend fun getData() = flow {
        try {
            emit(ResponseState.Loading)

            val response = api.getData()
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(ResponseState.Success(it))
                } ?: emit(ResponseState.Error("Empty Response"))
            } else {
                emit(ResponseState.Error("Error: ${response.message()}"))
            }
        } catch (e: Exception) {
            Log.d("Error", "api error: $e")
        }
    }
}