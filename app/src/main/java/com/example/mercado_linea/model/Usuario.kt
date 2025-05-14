package com.example.mercado_linea.model

data class Usuario(
    val userId: Int? = null,
    val nombre: String? = null,
    val email: String? = null,
    val contrasena: String? = null,
    val telefono: String? = null,
    val direccion: String? = null,
    val preferencias: String? = null
)
