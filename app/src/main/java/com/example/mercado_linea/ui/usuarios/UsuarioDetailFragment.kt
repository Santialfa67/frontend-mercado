package com.example.mercado_linea.ui.usuarios

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
import com.example.mercado_linea.ViewModel.UsuarioViewModel

class UsuarioDetailFragment : Fragment() {

    private val viewModel: UsuarioViewModel by viewModels()
    private lateinit var nombreTextView: TextView
    private lateinit var emailTextView: TextView
    private var usuarioId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            usuarioId = it.getInt("usuarioId")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_usuario_detail, container, false)
        nombreTextView = view.findViewById(R.id.nombreTextView)
        emailTextView = view.findViewById(R.id.emailTextView)
        // Inicializa otras vistas
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        usuarioId?.let {
            viewModel.obtenerUsuario(it)
        }

        viewModel.usuario.observe(viewLifecycleOwner, Observer { usuario ->
            usuario?.let {
                nombreTextView.text = it.nombre
                emailTextView.text = it.email
            }
        })

        viewModel.error.observe(viewLifecycleOwner, Observer { error ->
            error?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        })
    }
}