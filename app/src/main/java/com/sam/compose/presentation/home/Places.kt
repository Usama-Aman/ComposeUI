package com.sam.compose.presentation.home

data class Places(
    var id :Int,
    var name: String,
    var rating : Double,
    var isSaved : Boolean,
    var imageUrl : String,
    var description : String,
    var price : String = "199"
)

val places = listOf<Places>(
    Places(
        id = 1,
        name = "Alley Palace",
        rating = 4.1,
        isSaved = false,
        imageUrl = "",
        description = "Aspen is as close as one can get to a storybook alpine town in America. The choose-your-own-adventure possibilities—skiing, hiking, dining shopping and Aspen is as close as one can get to a storybook alpine town in America. The choose-your-own-adventure possibilities—skiing, hiking, dining shopping and"
    ),
    Places(
        id = 2,
        name = "Coeurdes Alpes",
        rating = 4.1,
        isSaved = true,
        imageUrl = "",
        description = "Aspen is as close as one can get to a storybook alpine town in America. The choose-your-own-adventure possibilities—skiing, hiking, dining shopping and Aspen is as close as one can get to a storybook alpine town in America. The choose-your-own-adventure possibilities—skiing, hiking, dining shopping and"
    ),
    Places(
        id = 3,
        name = "Alley Palace",
        rating = 4.1,
        isSaved = false,
        imageUrl = "",
        description = "Aspen is as close as one can get to a storybook alpine town in America. The choose-your-own-adventure possibilities—skiing, hiking, dining shopping and Aspen is as close as one can get to a storybook alpine town in America. The choose-your-own-adventure possibilities—skiing, hiking, dining shopping and"
    ),
    Places(
        id = 4,
        name = "Coeurdes Alpes",
        rating = 4.1,
        isSaved = true,
        imageUrl = "",
        description = "Aspen is as close as one can get to a storybook alpine town in America. The choose-your-own-adventure possibilities—skiing, hiking, dining shopping and Aspen is as close as one can get to a storybook alpine town in America. The choose-your-own-adventure possibilities—skiing, hiking, dining shopping and"
    ),

)