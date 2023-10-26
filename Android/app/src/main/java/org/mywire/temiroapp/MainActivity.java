package org.mywire.temiroapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import org.mywire.temiroapp.data.local.SQLmanager;
import org.mywire.temiroapp.data.prefs.PreferencesHelper;
import org.mywire.temiroapp.ui.main.ContactoUno;
import org.mywire.temiroapp.ui.product.ProductsServicesPpal;
import org.mywire.temiroapp.ui.quote.TurneroActivity;
import org.mywire.temiroapp.ui.store.StoreActivity;
import org.mywire.temiroapp.ui.test.TestPrincipal;
import org.mywire.temiroapp.ui.train.TrainActivity1;
import org.mywire.temiroapp.ui.user.LoginActivity;
import org.mywire.temiroapp.ui.user.PerfilUsuarioActivity;

public class MainActivity extends AppCompatActivity {

    boolean esUsuarioRegistrado;
    String nombreUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa la database por si no existiera
        SQLmanager man = new SQLmanager(this);
        man.crearDatabase();

        // Recupera valores desde las preferencias
        PreferencesHelper prefs = new PreferencesHelper(this);
        esUsuarioRegistrado = prefs.isUsuarioRegistrado();
        nombreUsuario = prefs.getNombreUsuario();

        Button boton1 = findViewById(R.id.btnVerCatalogo);
        Button boton2 = findViewById(R.id.botonTurno);
        Button boton3 = findViewById(R.id.botonEstadoDeCompra);
        ImageButton imageMin = findViewById(R.id.iconoUsuario);
        TextView userName = findViewById(R.id.user_name_main);

        if (esUsuarioRegistrado) {
            boton1.setVisibility(View.VISIBLE);
            boton2.setVisibility(View.VISIBLE);
            boton3.setVisibility(View.VISIBLE);
            userName.setVisibility(View.VISIBLE);
            userName.setText(nombreUsuario);
        } else {
            boton1.setVisibility(View.VISIBLE);
            boton2.setVisibility(View.GONE);
            boton3.setVisibility(View.GONE);
            userName.setVisibility(View.GONE);
        }
        imageMin.setVisibility(View.VISIBLE);
    }

    // Epica 1 - Páginas Principales ---------------------------------------------------------------
    public void iniciarContacto(View view) {
        Intent act = new Intent(this, ContactoUno.class);
        startActivity(act);
    }

    // Epica 2 - Manejo de Usuarios ----------------------------------------------------------------
    public void iniciarUsuario(View view) {
        if (esUsuarioRegistrado) {
            Intent act = new Intent(this, PerfilUsuarioActivity.class);
            startActivity(act);
        } else {
            Intent act = new Intent(this, LoginActivity.class);
            startActivity(act);
        }
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
        Intent act = new Intent(this, TurneroActivity.class);
        startActivity(act);
    }

    // Epica 6 - Pruebas de Visión -----------------------------------------------------------------
    public void iniciarPruebas(View view) {
        Intent act = new Intent(this, TestPrincipal.class);
        startActivity(act);
    }

    // Epica 7 - Ejercicios de Visión --------------------------------------------------------------
    public void iniciarEjercicios(View view) {
        Intent act = new Intent(this, TrainActivity1.class);
        startActivity(act);
    }

}
