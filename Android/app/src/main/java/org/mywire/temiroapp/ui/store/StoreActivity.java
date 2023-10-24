package org.mywire.temiroapp.ui.store;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.mywire.temiroapp.R;
import org.mywire.temiroapp.data.prefs.PreferencesHelper;
import org.mywire.temiroapp.data.remote.ApiService;
import org.mywire.temiroapp.model.Venta;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StoreActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VentaAdapter ventaAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_activity);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ventaAdapter = new VentaAdapter();
        recyclerView.setAdapter(ventaAdapter);

        // Inicializa Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://temiro.mywire.org:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService clienteApiService = retrofit.create(ApiService.class);

        PreferencesHelper prefs = new PreferencesHelper(StoreActivity.this);
        int idUsuario = prefs.getIdUsuario();

        Log.d("StoreActivity", "ID de Cliente: " + idUsuario);

        Call<List<Venta>> ventaCall = clienteApiService.getVentasCliente(idUsuario);
        ventaCall.enqueue(new Callback<List<Venta>>() {
            @Override
            public void onResponse(Call<List<Venta>> call, Response<List<Venta>> response) {
                if (response.isSuccessful()) {
                    List<Venta> ventas = response.body();
                    ventaAdapter.setData(ventas);
                } else {
                    Log.e("StoreActivity", "Error en la solicitud de ventas: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Venta>> call, Throwable t) {
                Log.e("StoreActivity", "Error en la solicitud de ventas: " + t.getMessage());
            }
        });
    }
}