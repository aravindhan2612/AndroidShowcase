package com.ab.koinexample.domain

interface AuthRepository {

    suspend fun  getUserName(): String
    suspend fun  getAddress(): String
}