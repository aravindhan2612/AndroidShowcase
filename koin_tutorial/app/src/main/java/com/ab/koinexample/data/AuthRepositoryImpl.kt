package com.ab.koinexample.data

import com.ab.koinexample.domain.AuthRepository
import kotlinx.coroutines.delay

class AuthRepositoryImpl: AuthRepository {
    override suspend fun getUserName(): String {
        delay(3000)
        return "Aravind"
    }

    override suspend fun getAddress(): String {
        delay(1000)
        return "address"
    }
}