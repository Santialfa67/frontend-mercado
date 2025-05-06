package com.example.mercado_linea


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mercado_linea.Screen.UsuarioScreen
import com.example.mercado_linea.ui.theme.Mercado_lineaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mercado_lineaTheme {
                UsuarioScreen()
            }
        }
    }
}