package com.challenge.dogadoptionapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.challenge.dogadoptionapp.navigation.Actions
import com.challenge.dogadoptionapp.navigation.Destinations
import com.challenge.dogadoptionapp.navigation.Destinations.DogDetail
import com.challenge.dogadoptionapp.navigation.Destinations.DogDetailArgs.DogId
import com.challenge.dogadoptionapp.ui.theme.DogAdoptionAppTheme
import com.challenge.dogadoptionapp.views.DogDetailsScreen
import com.challenge.dogadoptionapp.views.DogListScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultPreview()
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
fun DefaultPreview() {
    val navController = rememberNavController()
    val actions = remember(navController) {
        Actions(navController)
    }
    DogAdoptionAppTheme {
        NavHost(navController, startDestination = Destinations.Home) {
            composable(Destinations.Home) { DogListScreen(actions.openDetails) }
            composable(
                "${DogDetail}/{$DogId}",
                arguments = listOf(navArgument(DogId) { type = NavType.IntType })
            ) { navBackStackEntry ->
                DogDetailsScreen(
                    navBackStackEntry.arguments?.getInt(DogId) ?: 0,
                    actions.navigateBack
                )
            }
        }
    }
}