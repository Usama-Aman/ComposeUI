package com.sam.compose.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sam.compose.R
import com.sam.compose.presentation.home.Places
import com.sam.compose.presentation.home.places
import com.sam.compose.ui.theme.Black
import com.sam.compose.ui.theme.Blue
import com.sam.compose.ui.theme.Grey
import com.sam.compose.ui.theme.White

@Composable
fun RecommendedSection(
    modifier: Modifier = Modifier,
    recommendedPlaces: List<RecommendedPlaces>,
) {
    Column(
        modifier = modifier
    ) {

        Text(
            text = "Recommended",
            style = MaterialTheme.typography.bodyLarge,
            color = Black
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(10.dp),
        ) {
            items(recommendedPlaces.size) { index ->
                RecommendedItem(recommendedPlaces[index])
            }
        }
    }
}

@Composable
fun RecommendedItem(recommendedPlaces: RecommendedPlaces) {
    Box(
        modifier = Modifier
            .width(200.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom
        ) {

            Box {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    painter = painterResource(id = R.drawable.intro),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
                Text(
                    text = recommendedPlaces.dimensions,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .layout { measurable, constraints ->
                            val placeable = measurable.measure(constraints)
                            layout(placeable.width, placeable.height) {
                                placeable.place(0, placeable.height / 2)
                            }
                        }
                        .padding(end = 10.dp)
                        .border(2.dp, White, shape = RoundedCornerShape(10.dp))
                        .background(Grey, shape = RoundedCornerShape(10.dp))
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                )
            }
            Text(
                text = recommendedPlaces.name,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(5.dp)
            )
            Row(
                modifier = Modifier
                    .padding(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = "",
                    tint = Color.Yellow
                )
                Text(
                    text = recommendedPlaces.name,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun RecommendedSectionPreview() {
    RecommendedSection(recommendedPlaces = recommendedPlaces)
}