package com.example.mercado_linea.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mercado_linea.ViewModel.ProductoViewModel

@Composable
fun ProductosScreen(viewModel: ProductoViewModel = ProductoViewModel()) {
    val productos = viewModel.productos
    val error = viewModel.error

    Column(Modifier.padding(16.dp)) {
        Text("Lista de Productos", style = MaterialTheme.typography.titleLarge)

        if (error.isNotEmpty()) {
            Text("Error: $error", color = MaterialTheme.colorScheme.error)
        } else {
            LazyColumn {
                items(productos) { producto ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Column(Modifier.padding(8.dp)) {
                            Text("Nombre: ${producto.nombre}")
                            Text("Precio: $${producto.precio}")
                            Text("Stock: ${producto.stock}")
                        }
                    }
                }
            }
        }
    }
}
