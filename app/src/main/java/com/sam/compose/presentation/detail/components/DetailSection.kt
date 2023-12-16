package com.sam.compose.presentation.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sam.compose.R
import com.sam.compose.presentation.home.Places
import com.sam.compose.presentation.home.places
import com.sam.compose.ui.theme.Blue
import com.sam.compose.ui.theme.Grey
import com.sam.compose.ui.theme.White

@Composable
fun DetailSection(
    modifier: Modifier = Modifier,
    place: Places
) {

    var textOverFlow by remember { mutableStateOf(false) }
    var showFullText by remember { mutableStateOf(false) }
    Column(
        modifier = modifier
            .background(White)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = place.name,
                    style = MaterialTheme.typography.displaySmall
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_star),
                        contentDescription = null,
                        tint = Color.Yellow,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(10.dp)
                    )
                    Text(
                        text = "${place.rating.toString()} (355 Review)",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = Grey
                        )
                    )
                }
            }
            Text(
                text = place.name,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Blue
                )
            )
        }

        Spacer(modifier = Modifier.size(20.dp))
        Text(
            text = place.description,
            style = MaterialTheme.typography.bodyLarge,
            maxLines = if (showFullText) Int.MAX_VALUE else 5,
            overflow = TextOverflow.Ellipsis,
            onTextLayout = { textLayoutResult ->
                textOverFlow = textLayoutResult.hasVisualOverflow
            }
        )

        if (textOverFlow || showFullText) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
                    showFullText = !showFullText
                }
            ) {
                Text(
                    text = if (!showFullText) "Read More" else "Read Less",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Blue
                    )
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_down_bold),
                    contentDescription = null,
                    tint = Color.Blue,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(15.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun DetailSectionPreview() {
    DetailSection(place = places[0])
}