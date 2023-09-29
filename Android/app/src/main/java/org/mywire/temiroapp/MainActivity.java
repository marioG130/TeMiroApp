package org.mywire.temiroapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.mywire.temiroapp.ui.main.ActivNoImplementado;
import org.mywire.temiroapp.ui.product.ProductsServicesPpal;
import org.mywire.temiroapp.ui.store.StoreActivity;
import org.mywire.temiroapp.ui.test.TestPrincipal;
import org.mywire.temiroapp.ui.user.login_activity;
import org.mywire.temiroapp.ui.user.registro_activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Epica 1 - Páginas Principales ---------------------------------------------------------------
    public void iniciarContacto(View view) {
        Intent act = new Intent(this, ActivNoImplementado.class);
        startActivity(act);
    }

    // Epica 2 - Manejo de Usuarios ----------------------------------------------------------------
    public void iniciarLogin(View view) {
        Intent act = new Intent(this, login_activity.class);
        startActivity(act);
    }


    // Epica 3 - Productos y Servicios -------------------------------------------------------------
    public void iniciarProdServ(View view) {
        Intent act = new Intent(this, ProductsServicesPpal.class);
        startActivity(act);
    }

    // Epica 4 - Pedidos en Tienda -----------------------------------------------------------------
    public void iniciarStore(View view) {
        Intent iniciar_store = new Intent(this, StoreActivity.class);
        startActivity(iniciar_store);
    }

    // Epica 5 - Turnero de Servicios --------------------------------------------------------------
    public void iniciarTurnero(View view) {
        Intent act = new Intent(this, ActivNoImplementado.class);
        startActivity(act);
    }

    // Epica 6 - Pruebas de Visión -----------------------------------------------------------------
    public void iniciarPruebas(View view) {
        Intent act = new Intent(this, TestPrincipal.class);
        startActivity(act);
    }

    // Epica 7 - Ejercicios de Visión --------------------------------------------------------------
    public void iniciarEjercicios(View view) {
        Intent act = new Intent(this, ActivNoImplementado.class);
        startActivity(act);
    }

}
