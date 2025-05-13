package com.example.mercado_linea.interfaces

import com.example.mercado_linea.model.Usuario
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UsuarioApiService {
    @GET("/usuarios/{id}")
    suspend fun obtenerUsuario(@Path("id") id: Int): Response<Usuario>

}
