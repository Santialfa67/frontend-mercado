package com.example.mercado_linea.Repository

import com.example.mercado_linea.model.DetallePedido
import retrofit2.Response

class PedidoRepository {

    suspend fun obtenerPedido(id: Int): Response<com.example.mercado_linea.model.Pedido> {
        return RetroClient.pedidoApiService.getPedidoById(id)
    }

    suspend fun obtenerDetallesPedido(pedidoId: Int): Response<List<DetallePedido>> {
        return RetroClient.pedidoApiService.getDetallesPedidoByPedido(pedidoId)
    }

}