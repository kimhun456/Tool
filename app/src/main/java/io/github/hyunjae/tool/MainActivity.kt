package io.github.hyunjae.tool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import io.github.hyunjae.tool.presentation.ui.navigation.BottomNavigationBar
import io.github.hyunjae.tool.presentation.ui.navigation.NavigationGraph
import io.github.hyunjae.tool.presentation.ui.theme.ToolTheme
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("MainActivity onCreate called")
        enableEdgeToEdge()
        setContent {
            ToolTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Timber.d("MainScreen Composable called")
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavigationGraph(navController = navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ToolTheme {
        MainScreen()
    }
}