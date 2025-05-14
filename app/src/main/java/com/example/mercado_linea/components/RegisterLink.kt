package com.example.mercado_linea.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun RegisterLink(navController: NavController) {
    Row(horizontalArrangement = Arrangement.Center) {
        Text(text = "¿No tienes una cuenta? ")
        TextButton(onClick = { navController.navigate("register") }) {
            Text(text = "Regístrate", color = MaterialTheme.colorScheme.primary)
        }
    }
}
