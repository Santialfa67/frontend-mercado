import com.example.mercado_linea.interfaces.CarritoCompraApiService
import com.example.mercado_linea.interfaces.CategoriaApiService
import com.example.mercado_linea.interfaces.PedidoApiService
import com.example.mercado_linea.interfaces.ProductoApiService
import com.example.mercado_linea.interfaces.ProveedorApiService
import com.example.mercado_linea.interfaces.UsuarioApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroClient {
    private const val BASE_URL = "http://10.0.2.2:8080" // Reemplaza con la URL de tu backend

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val usuarioApiService: UsuarioApiService by lazy {
        retrofit.create(UsuarioApiService::class.java)
    }
    val productoApiService: ProductoApiService by lazy {
        retrofit.create(ProductoApiService::class.java)
    }
    val categoriaApiService: CategoriaApiService by lazy {
        retrofit.create(CategoriaApiService::class.java)
    }
    val proveedorApiService: ProveedorApiService by lazy {
        retrofit.create(ProveedorApiService::class.java)
    }
    val pedidoApiService: PedidoApiService by lazy {
        retrofit.create(PedidoApiService::class.java)
    }
    val carritoCompraApiService: CarritoCompraApiService by lazy {
        retrofit.create(CarritoCompraApiService::class.java)
    }

}