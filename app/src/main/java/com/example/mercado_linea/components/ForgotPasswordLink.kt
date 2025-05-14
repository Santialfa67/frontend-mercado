package com.example.mercado_linea.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun ForgotPasswordLink() {
    TextButton(onClick = { /* Navegar o mostrar pantalla de "Olvidé mi contraseña" */ }) {
        Text(text = "¿Olvidaste tu contraseña?", color = MaterialTheme.colorScheme.primary)
    }
}
