package com.example.mercado_linea.ui.proveedores

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
import com.example.mercado_linea.ViewModel.ProveedorViewModel

class ProveedorDetailFragment : Fragment() {

    private val viewModel: ProveedorViewModel by viewModels()
    private lateinit var nombreTextView: TextView
    private lateinit var contactoTextView: TextView
    private lateinit var direccionTextView: TextView
    private lateinit var productosOfrecidosTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_proveedor_detail, container, false)
        nombreTextView = view.findViewById(R.id.nombreTextView)
        contactoTextView = view.findViewById(R.id.contactoTextView)
        direccionTextView = view.findViewById(R.id.direccionTextView)
        productosOfrecidosTextView = view.findViewById(R.id.productosOfrecidosTextView)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val proveedorId = 1 // Simula obtener un ID

        viewModel.obtenerProveedor(proveedorId)

        viewModel.proveedor.observe(viewLifecycleOwner, Observer { proveedor ->
            proveedor?.let {
                nombreTextView.text = it.nombre
                contactoTextView.text = it.contacto ?: ""
                direccionTextView.text = it.direccion ?: ""
                productosOfrecidosTextView.text = it.productosOfrecidos ?: ""
            }
        })

        viewModel.error.observe(viewLifecycleOwner, Observer { error ->
            error?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        })
    }
}