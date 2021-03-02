package com.challenge.dogadoptionapp.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.constraintlayout.compose.*
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
fun DogCard(dog: Dog, modifier: Modifier, itemClickedCallback: (dogId: Int) -> Unit) {
    Surface(shape = RoundedCornerShape(8.dp), elevation = 8.dp, modifier = modifier) {
        val image = ImageBitmap.imageResource(dog.image)
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable {
                    itemClickedCallback(dog.id)
                }
        ) {
            val (dogImage, name, backArrow) = createRefs()
            Image(
                bitmap = image,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .constrainAs(dogImage) {
                        top.linkTo(parent.top)
                    }
                    .fillMaxWidth()
                    .height(250.dp)
            )
            Text(
                "Name: ${dog.name}",
                Modifier.constrainAs(name) {
                    top.linkTo(dogImage.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                },
                style = MaterialTheme.typography.h6
            )
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.ic_right_arrow),
                contentDescription = "",
                modifier = Modifier
                    .constrainAs(backArrow) {
                        top.linkTo(dogImage.bottom, margin = 16.dp)
                        end.linkTo(parent.end)
                    }
                    .width(50.dp)
                    .height(30.dp)
            )
        }

    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
fun DefaultDogCard() {
    val itemClickedCallback: (dogId: Int) -> Unit = {}
    DogCard(defaultDogs[0], Modifier.padding(16.dp),itemClickedCallback = itemClickedCallback)
}