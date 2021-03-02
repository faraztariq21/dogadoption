package com.challenge.dogadoptionapp.views

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.challenge.dogadoptionapp.R
import com.challenge.dogadoptionapp.models.Dog
import com.challenge.dogadoptionapp.models.defaultDogs

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun DogList(dogs: List<Dog>,itemClickedCallback: (dogId: Int) -> Unit) {
    Box{
        LazyColumn {
            items(dogs.size){ index ->
                DogCard(dogs[index], Modifier.padding(16.dp), itemClickedCallback)
            }
        }
    }
}

@Composable
fun DogListScreen(openDetails: (Int) -> Unit) {
    val itemClickedCallback: (dogId: Int) -> Unit = { dogId->
        openDetails(dogId)
    }
    Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.fillMaxSize()) {
            TopAppBar(title = {
                Text(stringResource(id = R.string.app_name))
            })
            DogList(defaultDogs,itemClickedCallback)
        }
    }
}