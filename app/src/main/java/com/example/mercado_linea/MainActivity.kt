package com.example.mercado_linea


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mercado_linea.ui.usuarios.UsuarioDetailFragment // Reemplaza con la ruta correcta a tu Fragment
import com.example.mercado_linea.R // Asegúrate de que la importación de R sea correcta

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Reemplaza con el nombre de tu layout principal

        if (savedInstanceState == null) {
            val fragment = UsuarioDetailFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment) // Usa el ID del FrameLayout que acabas de añadir
                .commit()
        }
    }
}