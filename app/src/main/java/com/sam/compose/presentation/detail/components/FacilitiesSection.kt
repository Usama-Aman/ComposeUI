package com.sam.compose.presentation.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sam.compose.R
import com.sam.compose.ui.theme.Black
import com.sam.compose.ui.theme.Blue05
import com.sam.compose.ui.theme.Grey

@Composable
fun FacilitiesSection(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = "Facilities",
            style = MaterialTheme.typography.bodyLarge,
            color = Black
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(
                14.dp,
                alignment = Alignment.CenterHorizontally
            )
        ) {
            FacilityItem(R.drawable.ic_wifi, "1 MB")
            FacilityItem(R.drawable.ic_food, "Dinner")
            FacilityItem(R.drawable.ic_bath_tub, "1 Tub")
            FacilityItem(R.drawable.ic_pool, "Pool")
        }
    }
}

@Composable
fun FacilityItem(icon: Int, facility: String) {
    Column(
        modifier = Modifier
            .size(80.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Blue05),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = facility,
            tint = Grey
        )
        Text(
            text = facility,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Grey
            ),
        )
    }
}

@Preview
@Composable
fun FacilitySectionPreview() {
    FacilitiesSection()
}