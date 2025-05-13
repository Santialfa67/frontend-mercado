package com.example.mercado_linea.Repository

import com.example.mercado_linea.model.Categoria
import retrofit2.Response

class CategoriaRepository {
    private val categoriaApiService = RetroClient.categoriaApiService

    suspend fun obtenerCategoria(id: Int): Response<Categoria> {
        return categoriaApiService.obtenerCategoria(id)
    }

    // Aquí puedes agregar funciones para interactuar con la API de categorías
}