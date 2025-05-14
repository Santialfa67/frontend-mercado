package com.example.mercado_linea.ui.categorias

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
import com.example.mercado_linea.ViewModel.CategoriaViewModel

class CategoriaDetailFragment : Fragment() {

    private val viewModel: CategoriaViewModel by viewModels()
    private lateinit var nombreTextView: TextView
    private lateinit var descripcionTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_categoria_detail, container, false)
        nombreTextView = view.findViewById(R.id.nombreTextView)
        descripcionTextView = view.findViewById(R.id.descripcionTextView)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoriaId = 1 // Simula obtener un ID

        viewModel.obtenerCategoria(categoriaId)

        viewModel.categoria.observe(viewLifecycleOwner, Observer { categoria ->
            categoria?.let {
                nombreTextView.text = it.nombre
                descripcionTextView.text = it.descripcion ?: ""
            }
        })

        viewModel.error.observe(viewLifecycleOwner, Observer { error ->
            error?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        })
    }
}