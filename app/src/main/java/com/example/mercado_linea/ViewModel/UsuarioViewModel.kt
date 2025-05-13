package com.example.mercado_linea.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mercado_linea.Repository.UserRepository
import com.example.mercado_linea.model.Usuario
import kotlinx.coroutines.launch
import retrofit2.Response

class UsuarioViewModel : ViewModel() {
    private val repository = UserRepository()

    private val _usuario = MutableLiveData<Usuario?>()
    val usuario: LiveData<Usuario?> = _usuario

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun obtenerUsuario(id: Int) {
        viewModelScope.launch {
            val response = repository.obtenerUsuario(id)
            if (response.isSuccessful) {
                _usuario.value = response.body()
                _error.value = null
            } else {
                _usuario.value = null
                _error.value = "Error al obtener el usuario: ${response.message()}"
            }
        }
    }

    // Aquí puedes agregar otras funciones para manejar la lógica de la interfaz de usuario relacionada con el usuario
}