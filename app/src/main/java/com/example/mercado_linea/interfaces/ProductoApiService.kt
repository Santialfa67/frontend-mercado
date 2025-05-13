package com.example.mercado_linea.interfaces

import com.example.mercado_linea.model.Producto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductoApiService {
    @GET("/productos/{id}")
    suspend fun obtenerProducto(@Path("id") id: Int): Response<Producto>

    // Aquí puedes agregar otras funciones para obtener todos los productos, por categoría, etc.
}