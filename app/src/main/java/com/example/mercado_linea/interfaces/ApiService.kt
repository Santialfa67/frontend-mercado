package com.example.mercado_linea.interfaces

import com.example.mercado_linea.model.Usuario
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import retrofit2.Response

// SUSPEND - FUNCIONES ASINCRONAS - SE PAUSAN SIN BLOQUEAR LA EJECUCION PRINCIPAL



interface ApiService {

    @GET("usuarios")
    suspend fun obtenerUsuarios(): List<Usuario>

    @GET("usuarios/{id}")
    suspend fun obtenerUsuarioPorId(@Path("id") id: Int): Usuario

    @POST("usuarios") // Ajusta si tu ruta es diferente
    fun crearUsuario(@Body usuario: Usuario): Call<Usuario>

    @PUT("usuarios/{id}")
    suspend fun actualizarUsuario(@Path("id") id: Int, @Body usuario: Usuario): Usuario

    @DELETE("usuarios/{id}")
    suspend fun eliminarUsuario(@Path("id") id: Int): Response<Void>
}

/*
object RetrofitClient {
    private const val BASE_URL = "http://10.0.2.2:8080"

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
*/
