package com.example.mercado_linea.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mercado_linea.Repository.ProductoRepository
import com.example.mercado_linea.model.Producto
import kotlinx.coroutines.launch
import retrofit2.Response

class ProductoViewModel : ViewModel() {
    private val repository = ProductoRepository()

    private val _producto = MutableLiveData<Producto?>()
    val producto: LiveData<Producto?> = _producto

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun obtenerProducto(id: Int) {
        viewModelScope.launch {
            val response = repository.obtenerProducto(id)
            if (response.isSuccessful) {
                _producto.value = response.body()
                _error.value = null
            } else {
                _producto.value = null
                _error.value = "Error al obtener el producto: ${response.message()}"
            }
        }
    }

    // Aquí puedes agregar otras funciones para manejar la lógica de la interfaz de usuario relacionada con el producto
}