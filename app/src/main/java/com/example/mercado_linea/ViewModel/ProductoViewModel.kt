package com.example.mercado_linea.ViewModel

import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mercado_linea.Repository.ProductoRepository
import com.example.mercado_linea.model.Producto
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.mercado_linea.network.RetrofitClient

class ProductoViewModel : ViewModel() {
    var productos by mutableStateOf<List<Producto>>(emptyList())
    var error by mutableStateOf("")

    init {
        cargarProductos()
    }

    fun cargarProductos() {
        viewModelScope.launch {
            try {
                val respuesta = RetrofitClient.apiService.obtenerProductos()
                if (respuesta.isSuccessful) {
                    productos = respuesta.body() ?: emptyList()
                } else {
                    error = "Error: ${respuesta.code()}"
                }
            } catch (e: Exception) {
                error = "Excepción: ${e.message}"
            }
        }
    }
}

