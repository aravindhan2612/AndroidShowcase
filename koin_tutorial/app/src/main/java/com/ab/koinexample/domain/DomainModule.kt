package com.ab.koinexample.domain

import com.ab.koinexample.domain.usecase.GetAddressUseCase
import com.ab.koinexample.domain.usecase.GetUsernameUseCase
import org.koin.dsl.module


val domainModule = module {
    factory { GetUsernameUseCase(get()) }
    factory { GetAddressUseCase(get()) }
}