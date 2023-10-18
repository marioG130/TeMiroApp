package org.mywire.temiroapp.ui.test;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.mywire.temiroapp.R;
import org.mywire.temiroapp.data.local.SQLmanager;
import org.mywire.temiroapp.data.prefs.PreferencesHelper;

public class TestPrincipal extends AppCompatActivity {

    boolean esUsuarioRegistrado;
    String nombreUsuario;
    int idUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activ_principal);

        // Carga datos iniciales para los tests de vision
        SQLmanager man = new SQLmanager(this);
        man.cargarDatosEpica6();

        // Recupera valores desde las preferencias
        PreferencesHelper prefs = new PreferencesHelper(this);
        esUsuarioRegistrado = prefs.isUsuarioRegistrado();
        nombreUsuario = prefs.getNombreUsuario();
        idUsuario = prefs.getIdUsuario();
    }

}
