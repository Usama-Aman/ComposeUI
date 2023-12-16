package com.sam.compose.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
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
fun PopularSection(
    modifier: Modifier = Modifier,
    places: List<Places>,
    onSeeAllClicked: () -> Unit = {},
    onItemClicked: () -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Popular",
                style = MaterialTheme.typography.bodyLarge,
                color = Black
            )
            Text(
                text = "See All",
                style = MaterialTheme.typography.bodyMedium,
                color = Blue,
                modifier = Modifier.clickable { onSeeAllClicked() }
            )
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(10.dp),
        ) {
            items(places.size) { index ->
                PlaceItem(places[index], onItemClicked)
            }
        }
    }
}

@Composable
fun PlaceItem(place: Places, onItemClicked: () -> Unit) {
    Box(
        modifier = Modifier
            .width(200.dp)
            .height(250.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable { onItemClicked() }
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.intro),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = place.name,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .background(
                        color = Grey,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(5.dp)
            )
            Spacer(modifier = Modifier.size(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = place.rating.toString(),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .background(
                            color = Grey,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(5.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_heart),
                    contentDescription = null,
                    Modifier
                        .size(30.dp)
                        .background(White, shape = CircleShape)
                        .padding(5.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PopularSectionPreview() {
    PopularSection(places = places) {}
}