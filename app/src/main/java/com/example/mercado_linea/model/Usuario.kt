package com.example.mercado_linea.model

data class Usuario(
    val nombre: String,
    val email: String,
    val contraseña: String,
    val telefono: String?,
    val direccion: String?,
    val preferencias: String?
)

