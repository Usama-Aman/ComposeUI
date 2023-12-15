package com.sam.compose.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sam.compose.ui.theme.Blue
import com.sam.compose.ui.theme.Blue05

@Composable
fun CategorySection(
    modifier: Modifier = Modifier,
    categories: List<String> = categoriess
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(categories.size) { index ->
            CategoryItem(categories[index])
        }
    }
}

@Composable
fun CategoryItem(category: String) {
    Box(
        modifier = Modifier
            .background(Blue05, RoundedCornerShape(10.dp))
            .height(40.dp)
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(

            text = category,
            style = MaterialTheme.typography.bodyMedium,
            color = Blue,
        )
    }
}

var categoriess = listOf("Location", "Hotels", "Food", "Adventure", "Location", "Hotels", "Food", "Adventure")

@Preview
@Composable
fun CategorySectionPreview() {
    CategorySection(categories = categoriess)
}