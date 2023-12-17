package com.sam.compose.presentation.home_navigation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sam.compose.R
import com.sam.compose.ui.theme.Blue
import com.sam.compose.ui.theme.Blue05
import com.sam.compose.ui.theme.Grey
import com.sam.compose.ui.theme.White

@Composable
fun BottomNavigation(
    items: List<Int>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
) {

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 30.dp,
                shape = RoundedCornerShape(
                    topEnd = 30.dp,
                    topStart = 30.dp
                ),
                spotColor = Grey
            )
            .clip(
                RoundedCornerShape(
                    topStart = 30.dp,
                    topEnd = 30.dp
                )
            ),
        tonalElevation = 20.dp,
        containerColor = White,
    ) {
        items.forEachIndexed { index, bottomBarItems ->

            NavigationBarItem(
                selected = (selectedIndex == index),
                onClick = { onItemSelected(index) },
                icon = {
                    Icon(
                        painter = painterResource(id = bottomBarItems),
                        contentDescription = null,
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Blue,
                    unselectedIconColor = Grey,
                    indicatorColor = MaterialTheme.colorScheme.background
                )
            )
        }
    }

}

data class BottomBarItems(
    @DrawableRes
    var icon: Int
)


@Preview
@Composable
fun BottomNavigationPreview() {
    BottomNavigation(
        items = listOf(
            R.drawable.ic_home,
            R.drawable.ic_ticket
        ),
        selectedIndex = 0,
        onItemSelected = {}
    )
}