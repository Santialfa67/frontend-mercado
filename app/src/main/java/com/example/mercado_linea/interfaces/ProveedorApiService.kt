package com.example.mercado_linea.interfaces

import com.example.mercado_linea.model.Proveedor
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProveedorApiService {
    @GET("/proveedores/{id}")
    suspend fun obtenerProveedor(@Path("id") id: Int): Response<Proveedor>
}