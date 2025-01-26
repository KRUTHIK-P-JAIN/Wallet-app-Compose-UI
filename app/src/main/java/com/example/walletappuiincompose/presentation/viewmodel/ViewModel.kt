package com.example.walletappuiincompose.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walletappuiincompose.data.model.ApiResponse
import com.example.walletappuiincompose.usecase.UseCase
import com.example.walletappuiincompose.utils.ResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(private val useCase: UseCase) : ViewModel() {

    private val _data: MutableStateFlow<ResponseState<ApiResponse>> =
        MutableStateFlow(ResponseState.Loading)
    val data: StateFlow<ResponseState<ApiResponse>> = _data

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            useCase.getData()
                .flowOn(Dispatchers.IO)
                .collect {
                    _data.value = it
                }
        }
    }
}