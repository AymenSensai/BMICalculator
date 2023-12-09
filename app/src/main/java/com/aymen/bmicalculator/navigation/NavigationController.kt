package com.aymen.bmicalculator.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aymen.bmicalculator.home.HomeScreen
import com.aymen.bmicalculator.home.HomeScreenViewModel
import com.aymen.bmicalculator.score.ScoreScreen
import com.aymen.bmicalculator.score.ScoreScreenViewModel

@Composable
fun NavigationController() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(Screen.Home.route) {
            val viewModel = viewModel<HomeScreenViewModel>()
            val state = viewModel.state
            HomeScreen(
                state = state,
                onEvent = { viewModel.onEvent(it) },
                navigateToScoreScreen = {
                    navController.navigate(
                        Screen.Score.route +
                                "?weight=${state.weight}&height=${state.height}"
                    )
                }
            )
        }

        composable(
            route = Screen.Score.route + "?weight={weight}&height={height}",
            arguments = listOf(
                navArgument(
                    name = "weight"
                ) {
                    type = NavType.IntType
                    defaultValue = -1
                },
                navArgument(
                    name = "height"
                ) {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) {
            val viewModel = viewModel<ScoreScreenViewModel>()
            val state = viewModel.state
            ScoreScreen(state = state, navigateToHomeScreen = { navController.popBackStack() })
        }

    }

}