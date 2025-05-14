package com.example.mercado_linea.Repository

import com.example.mercado_linea.model.Proveedor
import retrofit2.Response

class ProveedorRepository {
    private val proveedorApiService = RetroClient.proveedorApiService

    suspend fun obtenerProveedor(id: Int): Response<Proveedor> {
        return proveedorApiService.obtenerProveedor(id)
    }
}