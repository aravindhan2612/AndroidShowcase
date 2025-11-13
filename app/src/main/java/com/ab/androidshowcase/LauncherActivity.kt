package com.ab.androidshowcase

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.ab.androidshowcase.ui.theme.AndroidShowcaseTheme
import com.ab.couterexamplewithndk.presentation.ui.CounterNDKActivity
import com.ab.material3expressive.M3ExpressiveActivity

class LauncherActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidShowcaseTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    LauncherScreen()
                }
            }
        }
    }
}

@Composable
fun LauncherScreen() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Android ShowCase",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        Button(
            onClick = {
                val intent = Intent(context, M3ExpressiveActivity::class.java)
                context.startActivity(intent)
            }
        ) {
            Text(text = "Go to Material3 Expressive")
        }

        Button(
            onClick = {
                val intent = Intent(context, CounterNDKActivity::class.java)
                context.startActivity(intent)
            }
        ) {
            Text(text = "Go to NDKCounterApp")
        }
    }
}