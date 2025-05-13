package com.example.mercado_linea.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mercado_linea.Repository.PedidoRepository
import com.example.mercado_linea.model.Pedido
import kotlinx.coroutines.launch
import retrofit2.Response

class PedidoViewModel : ViewModel() {
    private val repository = PedidoRepository()

    private val _pedido = MutableLiveData<Pedido?>()
    val pedido: LiveData<Pedido?> = _pedido

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun obtenerPedido(id: Int) {
        viewModelScope.launch {
            val response = repository.obtenerPedido(id)
            if (response.isSuccessful) {
                _pedido.value = response.body()
                _error.value = null
            } else {
                _pedido.value = null
                _error.value = "Error al obtener el pedido: ${response.message()}"
            }
        }
    }
}