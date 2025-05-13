package com.example.mercado_linea.Repository

import com.example.mercado_linea.model.Pedido
import retrofit2.Response

class PedidoRepository {
    private val pedidoApiService = RetroClient.pedidoApiService

    suspend fun obtenerPedido(id: Int): Response<Pedido> {
        return pedidoApiService.obtenerPedido(id)
    }
}