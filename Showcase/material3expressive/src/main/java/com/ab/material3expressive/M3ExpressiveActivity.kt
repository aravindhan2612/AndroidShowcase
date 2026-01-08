package com.ab.material3expressive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ab.core.theme.AndroidShowcaseTheme
import com.ab.material3expressive.navigation.NavBase

class M3ExpressiveActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidShowcaseTheme {
                NavBase()
            }
        }
    }
}