package org.mywire.temiroapp.ui.user;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.mywire.temiroapp.MainActivity;
import org.mywire.temiroapp.R;

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
        boolean verificado;
        String nombre, clave;

        // Falta verificar el usuario/password
        nombre = String.valueOf(usuario.getText());
        clave = String.valueOf(contrasena.getText());
        verificado = true;

        if (verificado) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("esUsuarioRegistrado", true);
            intent.putExtra("nombreUsuario", nombre);
            startActivity(intent);
        } else {
            // mostrar error
        }
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
