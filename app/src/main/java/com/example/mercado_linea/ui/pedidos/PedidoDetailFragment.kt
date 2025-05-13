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
import com.example.mercado_linea.R
import com.example.mercado_linea.ViewModel.PedidoViewModel

class PedidoDetailFragment : Fragment() {

    private val viewModel: PedidoViewModel by viewModels()
    private lateinit var pedidoIdTextView: TextView
    private lateinit var usuarioIdTextView: TextView
    private lateinit var totalTextView: TextView
    private lateinit var estadoTextView: TextView
    private lateinit var direccionEnvioTextView: TextView
    private lateinit var metodoPagoTextView: TextView
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
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pedidoId?.let {
            viewModel.obtenerPedido(it)
        }

        viewModel.pedido.observe(viewLifecycleOwner, Observer { pedido ->
            pedido?.let {
                pedidoIdTextView.text = "ID del Pedido: ${it.pedidoId}"
                usuarioIdTextView.text = "ID del Usuario: ${it.usuario?.userId ?: "N/A"}" // Asumiendo que tienes la relación Usuario en Pedido
                totalTextView.text = "Total: $${it.total}"
                estadoTextView.text = "Estado: ${it.estado}"
                direccionEnvioTextView.text = "Dirección de Envío: ${it.direccionEnvio}"
                metodoPagoTextView.text = "Método de Pago: ${it.metodoPago}"
                // Aquí podrías manejar la lista de detalles del pedido si la implementas
            }
        })

        viewModel.error.observe(viewLifecycleOwner, Observer { error ->
            error?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        })
    }
}