package com.example.mercado_linea.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun EmailInput(email: String, onEmailChange: (String) -> Unit, error: String) {
    Column(modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)) {
        OutlinedTextField(
            value = email,
            onValueChange = onEmailChange,
            label = { Text("Correo electrónico") },
            isError = error.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        )
        if (error.isNotEmpty()) {
            ErrorMessageText(error = error)
        }
    }
}
@Composable
fun ErrorText(error: String) {

}
