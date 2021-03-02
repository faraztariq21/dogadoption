package com.challenge.dogadoptionapp.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.challenge.dogadoptionapp.R
import com.challenge.dogadoptionapp.models.Dog
import com.challenge.dogadoptionapp.models.defaultDogs

@Composable
fun DogDetails(dog: Dog, modifier: Modifier) {
    Surface(shape = RoundedCornerShape(8.dp), elevation = 8.dp, modifier = modifier) {
        val image = ImageBitmap.imageResource(dog.image)
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                bitmap = image,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(11.dp)
            ) {
                SetText("Name: ${dog.name}", true)
                SetText("Breed For: ${dog.bred_for}")
                SetText("Breed Group: ${dog.breed_group}")
                SetText("Height: ${dog.height}")
                SetText("Weight: ${dog.weight}")
                SetText("Life Span: ${dog.life_span}")
                SetText("Origin: ${dog.origin}")
                SetText("Temperament: ${dog.temperament}")
            }
        }
    }
}

@Composable
fun SetText(text: String, isName: Boolean = false) {
    Text(
        text,
        style = if (isName) {
            MaterialTheme.typography.h5
        } else {
            MaterialTheme.typography.body2
        },
        modifier = Modifier.padding(5.dp)
    )
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
fun DefaultDogDetails() {
    val navigateBack: () -> Unit = {}
    DogDetailsScreen(0,navigateBack)
}

@Composable
fun DogDetailsScreen(dogId: Int, navigateBack: () -> Unit) {
    val dog = defaultDogs.find { it.id == dogId }
    Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.fillMaxSize()) {
            TopAppBar(title = {
                Text("${dog?.name!!} Details")
            },
                navigationIcon = {
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_back_arrow),
                        contentDescription = "",
                        modifier = Modifier
                            .width(40.dp)
                            .height(30.dp)
                            .clickable {
                                navigateBack()
                            }
                    )
                })
            DogDetails(dog!!, Modifier.padding(5.dp))
        }
    }
}