package com.example.mercado_linea.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mercado_linea.R
import com.example.mercado_linea.model.DetallePedido

class DetallePedidoAdapter(private val detalles: List<DetallePedido>) :
    RecyclerView.Adapter<DetallePedidoAdapter.DetallePedidoViewHolder>() {

    inner class DetallePedidoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productoNombreTextView: TextView = itemView.findViewById(R.id.productoNombreTextView)
        val cantidadTextView: TextView = itemView.findViewById(R.id.cantidadTextView)
        val precioUnitarioTextView: TextView = itemView.findViewById(R.id.precioUnitarioTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetallePedidoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_detalle_pedido, parent, false)
        return DetallePedidoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DetallePedidoViewHolder, position: Int) {
        val detalle = detalles[position]
        holder.productoNombreTextView.text = detalle.producto?.nombre ?: "N/A"
        holder.cantidadTextView.text = "Cantidad: ${detalle.cantidad}"
        holder.precioUnitarioTextView.text = "Precio: $${detalle.precioUnitario}"
    }

    override fun getItemCount() = detalles.size
}