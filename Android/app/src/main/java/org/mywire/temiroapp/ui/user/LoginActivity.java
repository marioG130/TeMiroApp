package org.mywire.temiroapp.ui.user;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import org.mywire.temiroapp.MainActivity;
import org.mywire.temiroapp.R;
import org.mywire.temiroapp.data.prefs.PreferencesHelper;

public class LoginActivity extends AppCompatActivity {

    EditText usuario;
    EditText contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login_activity);
        usuario = findViewById(R.id.nombreUsuario);
        contrasena = findViewById(R.id.contrasena);
    }

    public void iniciarSesion(View view) {
        int id;
        String nombre, clave;
        boolean verificado;

        // Falta verificar el usuario/password y traer el id
        nombre = String.valueOf(usuario.getText());
        clave = String.valueOf(contrasena.getText());
        id = 1;
        verificado = (!nombre.isEmpty()); // modificar

        PreferencesHelper prefs = new PreferencesHelper(this);
        if (verificado) {
            prefs.setUsuarioRegistrado(true);
            prefs.setNombreUsuario(nombre);
            prefs.setIdUsuario(id);
        } else {
            Toast.makeText(LoginActivity.this, "Error en usuario o contraseña !", Toast.LENGTH_SHORT).show();
            prefs.setUsuarioRegistrado(false);
        }
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void iniciarRegistro(View view) {
        Intent act = new Intent(this, RegistroActivity.class);
        startActivity(act);
    }

    public void volverHome(View view) {
        Intent act = new Intent(this, MainActivity.class);
        startActivity(act);
    }

}
