package com.example.mercado_linea.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mercado_linea.Repository.ProveedorRepository
import com.example.mercado_linea.model.Proveedor
import kotlinx.coroutines.launch
import retrofit2.Response

class ProveedorViewModel : ViewModel() {
    private val repository = ProveedorRepository()

    private val _proveedor = MutableLiveData<Proveedor?>()
    val proveedor: LiveData<Proveedor?> = _proveedor

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun obtenerProveedor(id: Int) {
        viewModelScope.launch {
            val response = repository.obtenerProveedor(id)
            if (response.isSuccessful) {
                _proveedor.value = response.body()
                _error.value = null
            } else {
                _proveedor.value = null
                _error.value = "Error al obtener el proveedor: ${response.message()}"
            }
        }
    }
}