package com.ab.koinexample.data

import com.ab.koinexample.domain.AuthRepository
import org.koin.dsl.module

val dataModule = module {
    factory<AuthRepository> { AuthRepositoryImpl() }
}