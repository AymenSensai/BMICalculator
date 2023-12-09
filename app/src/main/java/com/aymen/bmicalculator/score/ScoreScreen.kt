package com.aymen.bmicalculator.score

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aymen.bmicalculator.ui.BmiButton
import com.aymen.bmicalculator.score.components.drawArc
import com.aymen.bmicalculator.score.components.drawBlueArc
import com.aymen.bmicalculator.ui.theme.Blue
import com.aymen.bmicalculator.ui.theme.BlueTextColor
import com.aymen.bmicalculator.ui.theme.DarkGrey

@Composable
fun ScoreScreen(
    state: ScoreState,
    navigateToHomeScreen: () -> Unit
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {

        Text(
            text = "Result",
            color = BlueTextColor,
            style = MaterialTheme.typography.headlineSmall
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Your BMI is",
                color = Color.Black,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .clip(CircleShape)
                    .aspectRatio(1f)
                    .border(border = BorderStroke(1.dp, DarkGrey), shape = CircleShape)
                    .padding(36.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .aspectRatio(1f)
                        .drawBehind {
                            drawArc(
                                startAngle = 270f * state.score.toFloat() / 27 - 90,
                                strokeWidth = 5f,
                                color = DarkGrey
                            )
                            drawBlueArc(
                                progress = state.score.toFloat() / 27,
                                startAngle = 270f,
                                strokeWidth = 10f,
                                color = Blue
                            )
                        },
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "%.2f".format(state.score),
                        color = Color.Black,
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }


            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = state.message,
                color = BlueTextColor,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(32.dp))

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .border(
                        border = BorderStroke(1.dp, Color.Black),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp)
            ) {
                Text(
                    text = state.description,
                    color = Color.Black,
                    style = MaterialTheme.typography.titleMedium
                )
            }

        }

        Spacer(modifier = Modifier.height(32.dp))

        BmiButton(
            text = "TRY AGAIN",
            modifier = Modifier.fillMaxWidth(),
            onClick = navigateToHomeScreen
        )

    }

}

@Preview
@Composable
fun ScoreScreenPreview() {
    ScoreScreen(
        state = ScoreState(
            score = 25.0,
            message = "UnderWeight",
            description = "A BMI below 18.5 indicating that you might be undernourished or lacking sufficient body weight in relation to your height. Health risks associated with being underweight can include weakened immune function, nutritional deficiencies, and osteoporosis."
        ),
        navigateToHomeScreen = {}
    )
}