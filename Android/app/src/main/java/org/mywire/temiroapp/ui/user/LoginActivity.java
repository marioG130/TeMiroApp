package org.mywire.temiroapp.ui.user;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import org.mywire.temiroapp.MainActivity;
import org.mywire.temiroapp.R;
import org.mywire.temiroapp.data.prefs.PreferencesHelper;
import org.mywire.temiroapp.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        if(TextUtils.isEmpty(usuario.getText().toString()) || TextUtils.isEmpty(contrasena.getText().toString())){
            Toast.makeText(LoginActivity.this, "Ingrese un nombre de usuario y contraseña", Toast.LENGTH_SHORT).show();

        }else{
            User loginRequest = new User();
            loginRequest.setUsuario(usuario.getText().toString());
            loginRequest.setPassword(contrasena.getText().toString());

            loginUser(loginRequest);

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);

        }


        // Falta verificar el usuario/password y traer el id
        nombre = String.valueOf(usuario.getText());
        clave = String.valueOf(contrasena.getText());
        id = 1;
        verificado = (!nombre.isEmpty());// modificar
        if(clave.isEmpty()){
            usuario.setError("Debe ingresar su nombre de usuario");
        }
        if(nombre.isEmpty()){
            contrasena.setError("Debe ingresar su contraseña");
        }



        PreferencesHelper prefs = new PreferencesHelper(this);
        if (verificado) {
            prefs.setUsuarioRegistrado(true);
            prefs.setNombreUsuario(nombre);
            prefs.setIdUsuario(id);
        } else {
            Toast.makeText(LoginActivity.this, "Error en usuario o contraseña !", Toast.LENGTH_SHORT).show();
            prefs.setUsuarioRegistrado(false);
        }

    }


    public void loginUser(User loginRequest){
        Call<UserRequest> loginResponseCall = UserApiClient.getService().loginUser(loginRequest);
        loginResponseCall.enqueue(new Callback<UserRequest>() {
            @Override
            public void onResponse(Call<UserRequest> call, Response<UserRequest> response) {
                if(response.isSuccessful()){
                    UserRequest loginResponse = response.body();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class).putExtra("data", loginResponse));
                    finish();
                }else{
                    String message = "Se ha producido un error";
                    Toast.makeText(LoginActivity.this,message,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UserRequest> call, Throwable t) {

                Toast.makeText(LoginActivity.this, "Inicio de Sesión exitoso",Toast.LENGTH_LONG).show();
            }
        });

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
