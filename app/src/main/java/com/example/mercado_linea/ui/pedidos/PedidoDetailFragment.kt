package com.example.mercado_linea.ui.pedidos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mercado_linea.R
import com.example.mercado_linea.ViewModel.PedidoViewModel
import com.example.mercado_linea.ui.adapters.DetallePedidoAdapter

class PedidoDetailFragment : Fragment() {

    private val viewModel: PedidoViewModel by viewModels()
    private lateinit var pedidoIdTextView: TextView
    private lateinit var usuarioIdTextView: TextView
    private lateinit var totalTextView: TextView
    private lateinit var estadoTextView: TextView
    private lateinit var direccionEnvioTextView: TextView
    private lateinit var metodoPagoTextView: TextView
    private lateinit var detallesPedidoRecyclerView: RecyclerView
    private lateinit var detallePedidoAdapter: DetallePedidoAdapter
    private var pedidoId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pedidoId = it.getInt("pedidoId")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pedido_detail, container, false)
        pedidoIdTextView = view.findViewById(R.id.pedidoIdTextView)
        usuarioIdTextView = view.findViewById(R.id.usuarioIdTextView)
        totalTextView = view.findViewById(R.id.totalTextView)
        estadoTextView = view.findViewById(R.id.estadoTextView)
        direccionEnvioTextView = view.findViewById(R.id.direccionEnvioTextView)
        metodoPagoTextView = view.findViewById(R.id.metodoPagoTextView)
        detallesPedidoRecyclerView = view.findViewById(R.id.detallesPedidoRecyclerView)
        detallesPedidoRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detallePedidoAdapter = DetallePedidoAdapter(emptyList())
        detallesPedidoRecyclerView.adapter = detallePedidoAdapter

        pedidoId?.let {
            viewModel.obtenerPedido(it)
        }

        viewModel.pedido.observe(viewLifecycleOwner, Observer { pedido ->
            pedido?.let {
                pedidoIdTextView.text = "ID del Pedido: ${it.pedidoId}"
                usuarioIdTextView.text = "ID del Usuario: ${it.usuario?.userId ?: "N/A"}"
                totalTextView.text = "Total: $${it.total}"
                estadoTextView.text = "Estado: ${it.estado}"
                direccionEnvioTextView.text = "Dirección de Envío: ${it.direccionEnvio}"
                metodoPagoTextView.text = "Método de Pago: ${it.metodoPago}"
            }
        })

        viewModel.detallesPedido.observe(viewLifecycleOwner, Observer { detalles ->
            detallePedidoAdapter.notifyDataSetChanged()
            detallePedidoAdapter = DetallePedidoAdapter(detalles)
            detallesPedidoRecyclerView.adapter = detallePedidoAdapter
        })

        viewModel.error.observe(viewLifecycleOwner, Observer { error ->
            error?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        })
    }
}