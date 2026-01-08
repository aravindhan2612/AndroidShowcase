package com.ab.koinexample.presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ab.koinexample.domain.usecase.GetAddressUseCase
import com.ab.koinexample.domain.usecase.GetUsernameUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update

class AuthViewModel(
    private val getAddressUseCase: GetAddressUseCase,
    private val getUsernameUseCase: GetUsernameUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(UiState())
    val state = _state.asStateFlow()

    init {
        getUserName()
        getAddress()
    }

    fun getUserName() = getUsernameUseCase().onStart {
        _state.update {
            it.copy(
                isLoading = true
            )
        }
    }.onEach { result ->
        _state.update {
            it.copy(
                name = result,
                isLoading = false
            )
        }
    }.catch { error ->
        _state.update {
            it.copy(
                error = error.toString(),
                isLoading = false
            )
        }
    }.launchIn(
        viewModelScope
    )

    fun getAddress() = getAddressUseCase().onStart {
        _state.update {
            it.copy(
                isLoading = true
            )
        }
    }.onEach { result ->
        _state.update {
            it.copy(
                address = result,
                isLoading = false
            )
        }
    }.catch { error ->
        _state.update {
            it.copy(
                error = error.toString(),
                isLoading = false
            )
        }
    }.launchIn(
        viewModelScope
    )
}

data class UiState(
    val isLoading: Boolean = false,
    val name: String? = null,
    val address: String? = null,
    val error: String? = null
)