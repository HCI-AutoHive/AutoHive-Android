package com.example.chian.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.chian.screen.ChatScreen
import com.example.chian.screen.MainScreen
import com.example.chian.viewmodel.MainViewModel

@Composable
fun RootNavGraph(
    navHostController: NavHostController
) {
    val mainViewModel: MainViewModel = viewModel()

    NavHost(
        navController = navHostController,
        startDestination = Route.HOME
    ){
        composable(Route.HOME) {
            MainScreen()
        }
        composable(Route.CHAT) {
            ChatScreen(
                mainViewModel = mainViewModel,
                navHostController = navHostController
            )
        }
    }
}