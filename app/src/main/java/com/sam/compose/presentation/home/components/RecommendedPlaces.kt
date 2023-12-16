package com.sam.compose.presentation.home.components

data class RecommendedPlaces(
    var id: Int,
    var name: String,
    var tag: String,
    var dimensions: String,
    var imageUrl: String,
)

val recommendedPlaces = listOf(
    RecommendedPlaces(
        id = 1,
        name = "Explore Aspen",
        tag = "Hot Deal",
        dimensions = "4N/5D",
        imageUrl = ""
    ),
    RecommendedPlaces(
        id = 1,
        name = "Luxurious Aspen",
        tag = "Hot Deal",
        dimensions = "4N/5D",
        imageUrl = ""
    )
)