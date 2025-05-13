package com.example.mercado_linea.interfaces

import com.example.mercado_linea.model.CarritoCompra
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CarritoCompraApiService {

    @GET("/carrito/{id}")
    suspend fun obtenerItemCarrito(@Path("id") id: Int): Response<CarritoCompra>

    @GET("/carrito/usuario/{userId}")
    suspend fun obtenerCarritoPorUsuario(@Path("userId") userId: Int): Response<List<CarritoCompra>>

}