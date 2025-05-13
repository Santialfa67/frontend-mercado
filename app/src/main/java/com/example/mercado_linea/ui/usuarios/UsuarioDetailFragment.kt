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

class UsuarioDetailFragment : Fragment() { // O AppCompatActivity si es una Activity

    private val viewModel: UsuarioViewModel by viewModels()
    private lateinit var nombreTextView: TextView
    private lateinit var emailTextView: TextView
    private var usuarioId: Int? = null // Para almacenar el ID del argumento

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            usuarioId = it.getInt("usuarioId") // Obtén el ID del argumento con la clave "usuarioId"
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_usuario_detail, container, false) // Reemplaza con tu layout
        nombreTextView = view.findViewById(R.id.nombreTextView) // Reemplaza con los IDs de tus vistas
        emailTextView = view.findViewById(R.id.emailTextView)
        // Inicializa otras vistas
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Llama a obtenerUsuario solo si tenemos un ID
        usuarioId?.let {
            viewModel.obtenerUsuario(it)
        }

        viewModel.usuario.observe(viewLifecycleOwner, Observer { usuario ->
            usuario?.let {
                nombreTextView.text = it.nombre
                emailTextView.text = it.email
                // Actualiza otras vistas con los datos del usuario
            }
        })

        viewModel.error.observe(viewLifecycleOwner, Observer { error ->
            error?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        })
    }
}