package com.example.mercado_linea.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mercado_linea.R
import com.example.mercado_linea.model.CarritoCompra

class CarritoCompraAdapter(private var carritoItems: List<CarritoCompra>) :
    RecyclerView.Adapter<CarritoCompraAdapter.CarritoViewHolder>() {

    class CarritoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productoIdTextView: TextView = itemView.findViewById(R.id.productoIdTextView) // Asegúrate de tener este ID en item_carrito.xml
        val cantidadTextView: TextView = itemView.findViewById(R.id.cantidadTextView) // Ya tienes este ID
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarritoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_carrito, parent, false) // Usa el layout que creaste
        return CarritoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CarritoViewHolder, position: Int) {
        val currentItem = carritoItems[position]
        holder.productoIdTextView.text = "Producto ID: ${currentItem.producto_id}"
        holder.cantidadTextView.text = "Cantidad: ${currentItem.cantidad}"
        // Aquí podrías agregar más lógica para mostrar el nombre del producto, etc.
    }

    override fun getItemCount() = carritoItems.size

    fun actualizarCarrito(nuevoCarrito: List<CarritoCompra>) {
        carritoItems = nuevoCarrito
        notifyDataSetChanged()
    }
}