package com.example.mercado_linea.model

data class DetallePedido(
    val detalleId: Int? = null,
    val pedido: Pedido? = null, // O Int? pedidoId si prefieres manejar solo el ID
    val producto: Producto? = null, // O Int? productoId si prefieres manejar solo el ID
    val cantidad: Int? = null,
    val precioUnitario: Double? = null
)