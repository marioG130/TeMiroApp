package org.mywire.temiroapp.ui.user;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.mywire.temiroapp.R;
import org.mywire.temiroapp.model.User;
import org.mywire.temiroapp.util.GenericRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroActivity extends AppCompatActivity {

    Button btn_registro;
    EditText editTextNomUs, editTextTextEmailAddress;
    EditText editTextTextPassword, editTextTextPassword2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_registro_activity);

        btn_registro = findViewById(R.id.btn_registro);
        editTextNomUs = findViewById(R.id.editTextNomUs);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        editTextTextPassword2 = findViewById(R.id.editTextTextPassword2);

        btn_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registroUser(createUser());
                validar();
            }
        });
    }

    public User createUser() {
        User user = new User();
        user.setUsuario(editTextNomUs.getText().toString());
        user.setEmail(editTextTextEmailAddress.getText().toString());
        user.setPassword(editTextTextPassword.getText().toString());
        user.getIdusuario();
        return user;
    }

    private void registroUser(User user) {
        Call<GenericRequest> userRequestCall = UserApiClient.getService().registroUser(user);
        userRequestCall.enqueue(new Callback<GenericRequest>() {
            @Override
            public void onResponse(Call<GenericRequest> call, Response<GenericRequest> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(RegistroActivity.this, "Registro exitoso", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(RegistroActivity.this, "Error de registro", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<GenericRequest> call, Throwable t) {
                Toast.makeText(RegistroActivity.this, "Error de registro"+ t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public boolean validar() {
        boolean retorno = true;
        String usuario = editTextNomUs.getText().toString();
        String email = editTextTextEmailAddress.getText().toString();
        String clave = editTextTextPassword.getText().toString();
        String clave2 = editTextTextPassword2.toString();
        if (usuario.isEmpty()) {
            editTextNomUs.setError("Debe ingresar un nombre de usuario");
            retorno = false;
        }
        if (email.isEmpty()) {
            editTextTextEmailAddress.setError("Debe ingresar un email");
            retorno = false;
        }
        if (clave.isEmpty()) {
            editTextTextPassword.setError("Debe ingresar una contraseña");
            retorno = false;
        }
        return retorno;
    }

    public void iniciarLogin(View view) {
        Intent act = new Intent(this, LoginActivity.class);
        startActivity(act);
    }

    public void volverLogin(View view) {
        Intent act = new Intent(this, LoginActivity.class);
        startActivity(act);
    }

}
