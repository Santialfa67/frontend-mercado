package com.example.mercado_linea.Repository

import com.example.mercado_linea.model.Producto
import com.example.mercado_linea.model.Usuario
import retrofit2.Response

class ProductoRepository {
    private val productoApiService = RetroClient.productoApiService

    suspend fun obtenerProducto(id: Int): Response<Producto> {
        return productoApiService.obtenerProducto(id)
    }

    // Aquí puedes agregar funciones para interactuar con la API y manejar la lógica de datos de productos
}
