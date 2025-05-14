package com.example.mercado_linea.Repository

import com.example.mercado_linea.model.CarritoCompra
import retrofit2.Response

class CarritoCompraRepository {
    private val carritoCompraApiService = RetroClient.carritoCompraApiService

    suspend fun obtenerItemCarrito(id: Int): Response<CarritoCompra> {
        return carritoCompraApiService.obtenerItemCarrito(id)
    }

    suspend fun obtenerCarritoPorUsuario(userId: Int): Response<List<CarritoCompra>> {
        return carritoCompraApiService.obtenerCarritoPorUsuario(userId)
    }

    // Otras funciones para interactuar con la API del carrito
}