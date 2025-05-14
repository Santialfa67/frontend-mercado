
package com.example.mercado_linea.model

data class Producto(
    val productoId: Int? = null,
    val nombre: String? = null,
    val descripcion: String? = null,
    val precio: Double? = null,
    val categoria: Categoria? = null, // Asumo que envías el objeto completo
    val imagen: String? = null,
    val stock: Int? = null,
    val proveedor: Proveedor? = null // Asumo que envías el objeto completo
)


//data class Categoria(val id: Int, val nombre: String)
//data class Proveedor(val id: Int, val nombre: String)
