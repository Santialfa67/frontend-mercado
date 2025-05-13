package com.example.mercado_linea.interfaces

import com.example.mercado_linea.model.Pedido
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PedidoApiService {
    @GET("/pedidos/{id}")
    suspend fun obtenerPedido(@Path("id") id: Int): Response<Pedido>
}