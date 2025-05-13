package com.example.mercado_linea.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mercado_linea.Repository.PedidoRepository
import com.example.mercado_linea.model.DetallePedido
import com.example.mercado_linea.model.Pedido
import kotlinx.coroutines.launch
import retrofit2.Response

class PedidoViewModel : ViewModel() {
    private val repository = PedidoRepository()

    private val _pedido = MutableLiveData<Pedido?>()
    val pedido: LiveData<Pedido?> = _pedido

    private val _detallesPedido = MutableLiveData<List<DetallePedido>>()
    val detallesPedido: LiveData<List<DetallePedido>> = _detallesPedido

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun obtenerPedido(id: Int) {
        viewModelScope.launch {
            val pedidoResponse = repository.obtenerPedido(id)
            if (pedidoResponse.isSuccessful) {
                _pedido.value = pedidoResponse.body()
                _error.value = null
                // Llamar a la función para obtener los detalles del pedido
                obtenerDetallesPedido(id)
            } else {
                _pedido.value = null
                _error.value = "Error al obtener el pedido: ${pedidoResponse.message()}"
            }
        }
    }

    private fun obtenerDetallesPedido(pedidoId: Int) {
        viewModelScope.launch {
            val detallesResponse = repository.obtenerDetallesPedido(pedidoId) // Asegúrate de tener esta función en tu Repository
            if (detallesResponse.isSuccessful) {
                _detallesPedido.value = detallesResponse.body() ?: emptyList()
            } else {
                // Manejar el error al obtener los detalles del pedido si es necesario
            }
        }
    }

    // Asegúrate de tener una función obtenerDetallesPedido en tu PedidoRepository
    // que haga la llamada a tu endpoint "/detalles_pedido/pedido/{pedidoId}"
}