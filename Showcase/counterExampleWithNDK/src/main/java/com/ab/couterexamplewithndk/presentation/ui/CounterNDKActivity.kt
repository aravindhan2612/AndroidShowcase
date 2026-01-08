package com.ab.couterexamplewithndk.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ab.couterexamplewithndk.presentation.theme.CounterAppTheme
import com.ab.couterexamplewithndk.presentation.ui.screens.counter.CounterScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CounterNDKActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterAppTheme {
                CounterScreen()
            }
        }
    }
}