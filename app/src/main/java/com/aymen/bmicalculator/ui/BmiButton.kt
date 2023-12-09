package com.aymen.bmicalculator.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aymen.bmicalculator.ui.theme.Blue

@Composable
fun BmiButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Blue),
        modifier = modifier
    ) {
        Text(text = text, color = Color.White, modifier = Modifier.padding(vertical = 16.dp))
    }
}

@Preview
@Composable
fun BmiButtonPreview() {
    BmiButton(text = "CALCULATE BMI", modifier = Modifier.fillMaxWidth(), onClick = {})
}