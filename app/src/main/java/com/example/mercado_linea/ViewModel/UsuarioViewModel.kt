package com.example.mercado_linea.ViewModel


import androidx.lifecycle.ViewModel
import com.example.mercado_linea.model.Usuario
import com.example.mercado_linea.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UsuarioViewModel : ViewModel() {
    fun crearUsuario(
        nombre: String,
        email: String,
        contraseña: String,
        telefono: String?,
        direccion: String?,
        preferencias: String?
    ) {
        val usuario = Usuario(nombre, email, contraseña, telefono, direccion, preferencias)
        val call = RetrofitClient.apiService.crearUsuario(usuario)

        call.enqueue(object : Callback<Usuario> {
            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                if (response.isSuccessful) {
                    println("✅ Usuario creado: ${response.body()}")
                } else {
                    println("❌ Error: ${response.code()} - ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                println("❌ Error de red: ${t.message}")
            }
        })
    }
}
