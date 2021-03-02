package com.challenge.dogadoptionapp.models

import androidx.annotation.DrawableRes

data class Dog(
    val id: Int,
    @DrawableRes val image: Int,
    val name: String,
    val bred_for: String,
    val breed_group: String,
    val height: String,
    val weight: String,
    val life_span: String,
    val origin: String,
    val temperament: String
)