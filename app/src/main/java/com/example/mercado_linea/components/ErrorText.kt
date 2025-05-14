package com.example.mercado_linea.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun ErrorMessageText(error: String) {
    Text(
        text = error,
        color = Color.Red,
        style = MaterialTheme.typography.bodySmall
    )
}
