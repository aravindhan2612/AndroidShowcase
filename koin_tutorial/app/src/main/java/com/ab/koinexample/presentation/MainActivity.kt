package com.ab.koinexample.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ab.koinexample.core.theme.KoinExampleTheme
import com.ab.koinexample.presentation.screens.AuthViewModel
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.activityScope
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope

class MainActivity : ComponentActivity(), AndroidScopeComponent {

    // scope
    override val scope: Scope by activityScope()

    private val sessionManager: SessionManager by inject<SessionManager>()

    private lateinit var  userScope: Scope
    private lateinit var user: User

    private val firstString : String by inject(named("first"))
    private val secondString : String by inject(named("second"))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //custom scope
        userScope = getKoin().createScope("scope_id", UserScope)
        user = userScope.get()
        enableEdgeToEdge()
        setContent {
            KoinExampleTheme {
                val viewModel = getViewModel<AuthViewModel>()
                val state by viewModel.state.collectAsStateWithLifecycle()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(innerPadding)
                                .fillMaxSize(),
                            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            state.name?.let {
                                Text(
                                    text = it.plus(user.name),
                                )
                            }
                            state.address?.let {
                                Text(
                                    text = it.plus(firstString).plus(secondString),
                                )
                            }

                            Text(
                                text = sessionManager.session,
                            )
                        }
                        if (state.isLoading) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                CircularProgressIndicator()
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        onCloseScope()
        userScope.close()
        super.onDestroy()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KoinExampleTheme {
        Greeting("Android")
    }
}