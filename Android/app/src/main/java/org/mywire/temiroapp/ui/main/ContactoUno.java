package org.mywire.temiroapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.mywire.temiroapp.R;
import org.mywire.temiroapp.ui.user.LoginActivity;

public class ContactoUno extends AppCompatActivity {

    EditText editTextApellido;
    EditText editTextNombre;
    EditText editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_contacto_uno);

        editTextApellido = findViewById(R.id.editTextApellido);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextEmail = findViewById(R.id.editTextEmail);
    }

    public void enviarConsulta(View view) {
        boolean validar;

        validar = !String.valueOf(editTextApellido.getText()).isEmpty() &&
                  !String.valueOf(editTextNombre.getText()).isEmpty() &&
                  !String.valueOf(editTextEmail.getText()).isEmpty();
        if (validar) {
            Intent act = new Intent(this, ContactoDos.class);
            startActivity(act);
        } else {
            Toast.makeText(ContactoUno.this, "Debe completar los campos !", Toast.LENGTH_LONG).show();
        }
    }

}
