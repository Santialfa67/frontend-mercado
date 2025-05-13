package com.example.mercado_linea.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mercado_linea.Repository.CategoriaRepository
import com.example.mercado_linea.model.Categoria
import kotlinx.coroutines.launch
import retrofit2.Response

class CategoriaViewModel : ViewModel() {
    private val repository = CategoriaRepository()

    private val _categoria = MutableLiveData<Categoria?>()
    val categoria: LiveData<Categoria?> = _categoria

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun obtenerCategoria(id: Int) {
        viewModelScope.launch {
            val response = repository.obtenerCategoria(id)
            if (response.isSuccessful) {
                _categoria.value = response.body()
                _error.value = null
            } else {
                _categoria.value = null
                _error.value = "Error al obtener la categoría: ${response.message()}"
            }
        }
    }
}