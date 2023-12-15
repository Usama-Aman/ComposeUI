package com.sam.compose.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sam.compose.presentation.home.components.CategorySection
import com.sam.compose.presentation.home.components.HomeTopBar
import com.sam.compose.presentation.home.components.PopularSection
import com.sam.compose.presentation.home.components.SearchField
import com.sam.compose.ui.theme.White

@Composable
fun HomeScreen() {


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            HomeTopBar(
                modifier = Modifier.padding(top = 50.dp, start = 20.dp, end = 20.dp)
            )
            SearchField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp, horizontal = 20.dp),
                value = "",
                onValueChange = {}
            )
            CategorySection()
            PopularSection(places = places)
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}