package com.example.walletappuiincompose.usecase

import javax.inject.Inject

class UseCase @Inject constructor(private val repository: Repository) {

    suspend fun getData() = repository.getData()
}