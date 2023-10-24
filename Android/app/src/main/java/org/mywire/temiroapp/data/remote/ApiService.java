package org.mywire.temiroapp.data.remote;

import org.mywire.temiroapp.model.Cliente;
import org.mywire.temiroapp.model.User;
import org.mywire.temiroapp.model.Venta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiService {
    @GET("webapi/venta?format=json")
    Call<List<Venta>> getVentas();

    @GET("webapi/cliente?format=json")
    Call<List<Cliente>> getClientes();

    @GET("webapi/usuario?format=json")
    Call<List<User>> getUsuarios();

    @GET("webapi/venta")
    Call<List<Venta>> getVentasCliente(@Query("search") int idUsuario);
}
