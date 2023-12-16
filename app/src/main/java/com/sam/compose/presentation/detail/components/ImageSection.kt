package com.sam.compose.presentation.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sam.compose.R
import com.sam.compose.presentation.home.Places
import com.sam.compose.presentation.home.places
import com.sam.compose.ui.theme.Grey
import com.sam.compose.ui.theme.White

@Composable
fun ImageSection(
    modifier: Modifier = Modifier,
    places: Places,
    onBackClicked: () -> Unit = {},
) {

    Box(
        modifier = modifier
            .background(White)
            .padding(bottom = 40.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.intro),
            contentDescription = "Place Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(12.dp))
        )
        Box(
            modifier = Modifier
                .padding(20.dp)
                .size(40.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(White)
                .clickable { onBackClicked() }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = "back Button",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
                    .align(Alignment.Center)
            )
        }

        Box(
            modifier = Modifier
                .padding(end = 20.dp)
                .size(40.dp)
                .align(Alignment.BottomEnd)
                .layout { measurable, constraints ->
                    val placeable = measurable.measure(constraints)
                    layout(placeable.width, placeable.height) {
                        placeable.place(0, placeable.height / 2)
                    }
                }
                .clip(CircleShape)
                .shadow(
                    elevation = 10.dp,
                    spotColor = Grey,
                    shape = CircleShape
                )
                .background(White)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_heart),
                contentDescription = "back Button",
                tint = Color.Red,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .align(Alignment.Center)
            )
        }
    }
}

@Preview
@Composable
fun ImageSectionPreview() {
    ImageSection(places = places[0])
}