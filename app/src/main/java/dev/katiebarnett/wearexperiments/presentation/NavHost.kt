package dev.katiebarnett.wearexperiments.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.wear.compose.material.ScalingLazyListState
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable

@Composable
fun NavHost(
    navController: NavHostController,
    listState: ScalingLazyListState,
    modifier: Modifier = Modifier,
) {
    SwipeDismissableNavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {
        composable("home") {
            HomeScreen( listState = listState, onUserInputClick = {
                navController.navigate("userInput")
            })
        }
        composable("userInput") {
            UserInputScreen()
        }
    }
}
