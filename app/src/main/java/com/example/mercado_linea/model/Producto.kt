
package com.example.mercado_linea.model

data class Producto(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val precio: Double,
    val stock: Int,
    val categoria: String?,
    val proveedor: String?
)


data class Categoria(val id: Int, val nombre: String)
data class Proveedor(val id: Int, val nombre: String)
