package com.example.mercado_linea.interfaces

import com.example.mercado_linea.model.Categoria
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CategoriaApiService {
    @GET("categorias/{id}")
    suspend fun obtenerCategoria(@Path("id") id: Int): Response<Categoria>

}