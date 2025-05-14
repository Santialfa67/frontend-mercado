package com.example.mercado_linea.ViewModel

import com.example.mercado_linea.Repository.CarritoCompraRepository
import com.example.mercado_linea.model.CarritoCompra
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response


class CarritoCompraViewModel : ViewModel() {
    private val repository = CarritoCompraRepository()

    private val _carritoItems = MutableLiveData<List<CarritoCompra>>()
    val carritoItems: LiveData<List<CarritoCompra>> = _carritoItems

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun obtenerCarritoPorUsuario(userId: Int) {
        _isLoading.value = true
        viewModelScope.launch {
            val response = repository.obtenerCarritoPorUsuario(userId)
            _isLoading.value = false
            if (response.isSuccessful) {
                _carritoItems.value = response.body() ?: emptyList()
                _error.value = null
            } else {
                _carritoItems.value = emptyList()
                _error.value = "Error al obtener el carrito: ${response.message()}"
            }
        }
    }

    // Aquí puedes agregar otras funciones para agregar, eliminar, o actualizar items del carrito
    // Por ejemplo:
    // suspend fun agregarItemAlCarrito(userId: Int, productoId: Int, cantidad: Int) { ... }
    // suspend fun eliminarItemDelCarrito(carritoItemId: Int) { ... }
    // suspend fun actualizarCantidadItemCarrito(carritoItemId: Int, nuevaCantidad: Int) { ... }
}