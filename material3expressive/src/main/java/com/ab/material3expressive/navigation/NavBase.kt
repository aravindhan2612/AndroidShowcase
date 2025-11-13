package com.ab.material3expressive.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.ab.material3expressive.screens.HomeScreen

@Composable
fun NavBase() {
    val backStack = rememberNavBackStack(Route.Home)

    NavDisplay(
        backStack = backStack,
        entryProvider = entryProvider {
            entry<Route.Home> {
                HomeScreen()
            }
            entry<Route.Material3Expressive> {

            }
        }
    )
}