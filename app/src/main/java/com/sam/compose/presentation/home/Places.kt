package com.sam.compose.presentation.home

data class Places(
    var id :Int,
    var name: String,
    var rating : Double,
    var isSaved : Boolean,
    var imageUrl : String,
)

val places = listOf<Places>(
    Places(
        id = 1,
        name = "Alley Palace",
        rating = 4.1,
        isSaved = false,
        imageUrl = ""
    ),
    Places(
        id = 2,
        name = "Coeurdes Alpes",
        rating = 4.1,
        isSaved = true,
        imageUrl = ""
    ),
    Places(
        id = 3,
        name = "Alley Palace",
        rating = 4.1,
        isSaved = false,
        imageUrl = ""
    ),
    Places(
        id = 4,
        name = "Coeurdes Alpes",
        rating = 4.1,
        isSaved = true,
        imageUrl = ""
    ),

)