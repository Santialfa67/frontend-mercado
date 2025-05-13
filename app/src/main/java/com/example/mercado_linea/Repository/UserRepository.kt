package com.example.mercado_linea.Repository

import com.example.mercado_linea.model.Usuario
import retrofit2.Response

class UserRepository {
    private val usuarioApiService = RetroClient.usuarioApiService

    suspend fun obtenerUsuario(id: Int): Response<Usuario> {
        return usuarioApiService.obtenerUsuario(id)
    }

    // Aquí puedes agregar funciones para interactuar con la API y manejar la lógica de datos
}