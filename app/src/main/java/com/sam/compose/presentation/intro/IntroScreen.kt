package com.sam.compose.presentation.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sam.compose.R
import com.sam.compose.ui.theme.Blue
import com.sam.compose.ui.theme.White

@Composable
fun IntroScreen(onExploreButtonClicked: () -> Unit) {

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.intro),
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(id = R.string.app_name),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp),
                style = MaterialTheme.typography.displayLarge,
                color = White
            )
            Spacer(modifier = Modifier.weight(1f))
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Plan your",
                    style = MaterialTheme.typography.displaySmall,
                    color = White
                )
                Text(
                    text = "Luxurious \nVacation",
                    style = MaterialTheme.typography.displayMedium,
                    color = White
                )

                Button(
                    onClick = { onExploreButtonClicked() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(top = 10.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Blue,
                        contentColor = White
                    )
                ) {
                    Text(
                        text = "Explore",
                        style = MaterialTheme.typography.displaySmall.copy(
                            fontSize = 22.sp
                        ),
                        color = White
                    )
                }
            }

        }
    }

}

@Preview
@Composable
fun IntroScreenPreview() {
    IntroScreen {

    }
}