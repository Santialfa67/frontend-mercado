package com.example.mercado_linea.model

data class Pedido(
    val pedidoId: Int? = null,
    val usuario: Usuario? = null,
    val total: Double? = null,
    val estado: String? = null,
    val direccionEnvio: String? = null,
    val metodoPago: String? = null
)