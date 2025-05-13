package com.example.mercado_linea.ui.carrito

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mercado_linea.R
import com.example.mercado_linea.ViewModel.CarritoCompraViewModel
import com.example.mercado_linea.ui.adapters.CarritoCompraAdapter

class CarritoCompraFragment : Fragment() {

    private val viewModel: CarritoCompraViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CarritoCompraAdapter
    private lateinit var emptyCartTextView: TextView
    private lateinit var loadingProgressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_carrito_compra, container, false)
        recyclerView = view.findViewById(R.id.carritoRecyclerView)
        emptyCartTextView = view.findViewById(R.id.emptyCartTextView)
        loadingProgressBar = view.findViewById(R.id.loadingProgressBar)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = CarritoCompraAdapter(emptyList()) // Inicializa el adapter
        recyclerView.adapter = adapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Simula la obtención del ID del usuario actual (deberías obtenerlo de tu lógica de autenticación)
        val userId = 1

        viewModel.obtenerCarritoPorUsuario(userId)

        viewModel.carritoItems.observe(viewLifecycleOwner, Observer { carritoItems ->
            if (carritoItems.isEmpty()) {
                recyclerView.visibility = View.GONE
                emptyCartTextView.visibility = View.VISIBLE
            } else {
                recyclerView.visibility = View.VISIBLE
                emptyCartTextView.visibility = View.GONE
                adapter.actualizarCarrito(carritoItems)
            }
        })

        viewModel.error.observe(viewLifecycleOwner, Observer { error ->
            error?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.isLoading.observe(viewLifecycleOwner, Observer { isLoading ->
            loadingProgressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        })
    }
}