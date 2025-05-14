package com.example.mercado_linea.ui.productos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.mercado_linea.R
//import com.squareup.picasso.Picasso // Si usas Picasso para cargar imágenes
import com.example.mercado_linea.ViewModel.ProductoViewModel
import com.squareup.picasso.Picasso

class ProductoDetailFragment : Fragment() { // O AppCompatActivity si es una Activity

    private val viewModel: ProductoViewModel by viewModels()
    private lateinit var nombreTextView: TextView
    private lateinit var descripcionTextView: TextView
    private lateinit var precioTextView: TextView
    private lateinit var imagenImageView: ImageView
    // Agrega más TextViews para otros campos

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_producto_detail, container, false) // Reemplaza con tu layout
        nombreTextView = view.findViewById(R.id.nombreTextView) // Reemplaza con los IDs de tus vistas
        descripcionTextView = view.findViewById(R.id.descripcionTextView)
        precioTextView = view.findViewById(R.id.precioTextView)
        imagenImageView = view.findViewById(R.id.imagenImageView)
        // Inicializa otras vistas
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Simula la obtención de un ID de producto
        val productoId = 1

        viewModel.obtenerProducto(productoId)

        viewModel.producto.observe(viewLifecycleOwner, Observer { producto ->
            producto?.let {
                nombreTextView.text = it.nombre
                descripcionTextView.text = it.descripcion
                precioTextView.text = "$${it.precio}"
                it.imagen?.let { url ->
                    // Utiliza una librería como Picasso o Glide para cargar la imagen desde la URL
                    Picasso.get().load(url).into(imagenImageView)
                }
                // Actualiza otras vistas con los datos del producto
            }
        })

        viewModel.error.observe(viewLifecycleOwner, Observer { error ->
            error?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        })
    }
}