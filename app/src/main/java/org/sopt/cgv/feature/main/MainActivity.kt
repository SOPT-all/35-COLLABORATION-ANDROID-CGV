package org.sopt.cgv.feature.main

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import org.sopt.cgv.core.designsystem.theme.CGVTheme
import org.sopt.cgv.feature.home.HomeRoute
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import org.sopt.cgv.core.data.datasourceImpl.CgvDataSourceImpl
import org.sopt.cgv.core.domain.repository.CgvRepositoryImpl
import org.sopt.cgv.feature.seats.SeatSelectScreen
import org.sopt.cgv.network.ServicePool.cgvService


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dataSource = CgvDataSourceImpl(cgvService)
        val repository = CgvRepositoryImpl(dataSource)


        enableEdgeToEdge()
        setContent {
            SeatSelectScreen(
                modifier = Modifier,
                movieId = 2L,
                repository = repository
            )
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)

        ) {
            composable("home") {
                HomeRoute(
                    onTicketClick = { /* 네비게이션 로직 */ },
                    onSearchClick = { /* 네비게이션 로직 */ },
                    onMenuClick = { /* 네비게이션 로직 */ },
                    onReservationClick = { navController.navigate("seats") }
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CGVTheme {
        Greeting("Android")
    }
}
