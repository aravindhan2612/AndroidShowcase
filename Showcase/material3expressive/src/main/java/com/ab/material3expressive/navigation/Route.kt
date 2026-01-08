package com.ab.material3expressive.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Route : NavKey {
    @Serializable
    object Home : Route
    @Serializable
    object Material3Expressive : Route
}