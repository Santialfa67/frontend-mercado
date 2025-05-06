package com.example.mercado_linea.Repository


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.mercado_linea.ViewModel.UsuarioViewModel
import com.example.mercado_linea.model.Usuario


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsuarioScreen(viewModel: UsuarioViewModel = UsuarioViewModel()) {
    var nombre by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var contraseña by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var preferencias by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Registrar Usuario") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = contraseña, onValueChange = { contraseña = it }, label = { Text("Contraseña") }, visualTransformation = PasswordVisualTransformation(), modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = telefono, onValueChange = { telefono = it }, label = { Text("Teléfono") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = direccion, onValueChange = { direccion = it }, label = { Text("Dirección") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = preferencias, onValueChange = { preferencias = it }, label = { Text("Preferencias") }, modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                viewModel.crearUsuario(
                    nombre, email, contraseña,
                    telefono.ifBlank { null },
                    direccion.ifBlank { null },
                    preferencias.ifBlank { null }
                )
            }) {
                Text("Registrar")
            }
        }
    }
}