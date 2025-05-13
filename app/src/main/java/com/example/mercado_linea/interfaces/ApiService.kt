//package com.example.frontend_mercado.network
//
//import com.example.mercado_linea.model.*
//import retrofit2.Call
//import retrofit2.http.*
//
//interface ApiService {
//
//    // Usuarios
//    @GET("/usuarios")
//    fun getAllUsuarios(): Call<List<Usuario>>
//
//    @GET("/usuarios/{id}")
//    fun getUsuarioById(@Path("id") id: Int): Call<Usuario>
//
//    @POST("/usuarios")
//    fun saveUsuario(@Body usuario: Usuario): Call<Usuario>
//
//    @PUT("/usuarios/{id}")
//    fun updateUsuario(@Path("id") id: Int, @Body usuario: Usuario): Call<Usuario>
//
//    @DELETE("/usuarios/{id}")
//    fun deleteUsuario(@Path("id") id: Int): Call<Void>
//
//    // Categorias
//    @GET("/categorias")
//    fun getAllCategorias(): Call<List<Categoria>>
//
//    @GET("/categorias/{id}")
//    fun getCategoriaById(@Path("id") id: Int): Call<Categoria>
//
//    @POST("/categorias")
//    fun saveCategoria(@Body categoria: Categoria): Call<Categoria>
//
//    @PUT("/categorias/{id}")
//    fun updateCategoria(@Path("id") id: Int, @Body categoria: Categoria): Call<Categoria>
//
//    @DELETE("/categorias/{id}")
//    fun deleteCategoria(@Path("id") id: Int): Call<Void>
//
//    // Proveedores
//    @GET("/proveedores")
//    fun getAllProveedores(): Call<List<Proveedor>>
//
//    @GET("/proveedores/{id}")
//    fun getProveedorById(@Path("id") id: Int): Call<Proveedor>
//
//    @POST("/proveedores")
//    fun saveProveedor(@Body proveedor: Proveedor): Call<Proveedor>
//
//    @PUT("/proveedores/{id}")
//    fun updateProveedor(@Path("id") id: Int, @Body proveedor: Proveedor): Call<Proveedor>
//
//    @DELETE("/proveedores/{id}")
//    fun deleteProveedor(@Path("id") id: Int): Call<Void>
//
//    // Productos
//    @GET("/productos")
//    fun getAllProductos(): Call<List<Producto>>
//
//    @GET("/productos/{id}")
//    fun getProductoById(@Path("id") id: Int): Call<Producto>
//
//    @POST("/productos")
//    fun saveProducto(@Body producto: Producto): Call<Producto>
//
//    @PUT("/productos/{id}")
//    fun updateProducto(@Path("id") id: Int, @Body producto: Producto): Call<Producto>
//
//    @DELETE("/productos/{id}")
//    fun deleteProducto(@Path("id") id: Int): Call<Void>
//
//    // Carrito Compras
//    @GET("/carrito_compras/usuario/{userId}")
//    fun getCarritoByUsuario(@Path("userId") userId: Int): Call<List<CarritoCompra>>
//
//    @POST("/carrito_compras")
//    fun addToCarrito(@Body carritoItem: CarritoCompra): Call<CarritoCompra>
//
//    @PUT("/carrito_compras/{id}")
//    fun updateCarritoItem(@Path("id") id: Int, @Body carritoItem: CarritoCompra): Call<CarritoCompra>
//
//    @DELETE("/carrito_compras/{id}")
//    fun deleteCarritoItem(@Path("id") id: Int): Call<Void>
//
//    // Pedidos
//    @GET("/pedidos/usuario/{userId}")
//    fun getPedidosByUsuario(@Path("userId") userId: Int): Call<List<Pedido>>
//
//    @GET("/pedidos/{id}")
//    fun getPedidoById(@Path("id") id: Int): Call<Pedido>
//
//    @POST("/pedidos")
//    fun createPedido(@Body pedido: Pedido): Call<Pedido>

//    // Detalles Pedido (solo GET para mostrar detalles de un pedido)
//    @GET("/detalles_pedido/pedido/{pedidoId}")
//    fun getDetallesPedidoByPedido(@Path("pedidoId") pedidoId: Int): Call<List<DetallePedido>>
//}