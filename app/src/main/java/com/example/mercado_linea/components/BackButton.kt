package com.example.mercado_linea.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun BackButton() {
    IconButton(onClick = { /* Lógica para volver atrás */ }) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Volver")
        Text(text = "Volver", color = MaterialTheme.colorScheme.primary)
    }
}