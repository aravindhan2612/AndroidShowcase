package com.ab.koinexample.presentation

import com.ab.koinexample.presentation.screens.AuthViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module


data class User(val name: String)

val UserScope = named("UserScope")

val userModule = module {
    scope(UserScope) {
        scoped {
            User("Baskaran")
        }
    }
}

data class SessionManager(
    val session: String
)

val sessionModule = module {
    scope<MainActivity> {
        scoped {
            SessionManager("this is session")
        }
    }
}
val uiModule = module {
    viewModel {
        AuthViewModel(  get(), get())
    }
    factory<String>(named("first")) {
        "first string"
    }
    factory<String>(named("second")) {
        "second string"
    }
}