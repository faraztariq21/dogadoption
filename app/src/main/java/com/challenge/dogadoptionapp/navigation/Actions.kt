package com.challenge.dogadoptionapp.navigation

import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.challenge.dogadoptionapp.navigation.Destinations.DogDetail

class Actions(navController: NavHostController) {
    val openDetails: (Int) -> Unit = { dogId ->
        navController.navigate("${DogDetail}/$dogId")
    }
    val navigateBack: () -> Unit = {
        navController.popBackStack()
    }
}