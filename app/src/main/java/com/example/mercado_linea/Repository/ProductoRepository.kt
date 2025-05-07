package com.example.mercado_linea.Repository

import com.example.mercado_linea.model.Producto
import com.example.mercado_linea.network.RetrofitClient
import retrofit2.Response

class ProductoRepository {
    suspend fun obtenerProductos(): Response<List<Producto>> {
        return RetrofitClient.apiService.obtenerProductos()
    }
}
