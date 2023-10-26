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
import org.mywire.temiroapp.data.remote.ApiService;
import org.mywire.temiroapp.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

        //    Modificacion para StoreActivity
        String nombre = String.valueOf(usuario.getText());

        // Realiza la autenticación del usuario y obtén su nombre de usuario
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://temiro.mywire.org:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //se obtiene el nombre de usuario de la API de usuario
        ApiService usuarioApiService = retrofit.create(ApiService.class);
        Call<List<User>> usuarioCall = usuarioApiService.getUsuarios();

        PreferencesHelper prefs = new PreferencesHelper(LoginActivity.this);
        prefs.setUsuarioRegistrado(true);
        prefs.setNombreUsuario(nombre);

        usuarioCall.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    List<User> usuarios = response.body();

                    // Busca el nombre de usuario en la lista de usuarios
                    String nombre = String.valueOf(usuario.getText());
                    int idCliente = -1;

                    for (User usuario : usuarios) {
                        if (usuario.getUsuario().equals(nombre)) {
                            idCliente = usuario.getIdusuario();
                            break;
                        }
                    }

                    if (idCliente > 0) {
                        PreferencesHelper prefs = new PreferencesHelper(LoginActivity.this);
                        prefs.setUsuarioRegistrado(true);
                        prefs.setNombreUsuario(nombre);
                        prefs.setIdUsuario(idCliente);


                    } else {
                        Toast.makeText(LoginActivity.this, "Error en usuario o contraseña!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Error en la solicitud de usuarios: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Error en la solicitud de usuarios: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        // codigo login
        int id;
        String  clave;
        boolean verificado;

        if (TextUtils.isEmpty(usuario.getText().toString()) || TextUtils.isEmpty(contrasena.getText().toString())) {
            Toast.makeText(LoginActivity.this, "Ingrese un nombre de usuario y contraseña", Toast.LENGTH_SHORT).show();
        } else {
            User loginRequest = new User();
            loginRequest.setUsuario(usuario.getText().toString());
            loginRequest.setPassword(contrasena.getText().toString());

            loginUser(loginRequest);

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }

        // Falta verificar el usuario/password y traer el id
        String nombreUser = String.valueOf(usuario.getText());
        clave = String.valueOf(contrasena.getText());
        id = 1;
        verificado = (!nombre.isEmpty()); // modificar
        if (clave.isEmpty()) {
            usuario.setError("Debe ingresar su nombre de usuario");
        }
        if (nombre.isEmpty()) {
            contrasena.setError("Debe ingresar su contraseña");
        }

        prefs = new PreferencesHelper(this);
        if (verificado) {
            prefs.setUsuarioRegistrado(true);
            prefs.setNombreUsuario(nombre);
            prefs.setIdUsuario(id);
        } else {
            Toast.makeText(LoginActivity.this, "Error en usuario o contraseña !", Toast.LENGTH_SHORT).show();
            prefs.setUsuarioRegistrado(false);
        }
    }

    public void loginUser(User loginRequest) {
        Call<UserRequest> loginResponseCall = UserApiClient.getService().loginUser(loginRequest);
        loginResponseCall.enqueue(new Callback<UserRequest>() {
            @Override
            public void onResponse(Call<UserRequest> call, Response<UserRequest> response) {
                if (response.isSuccessful()) {
                    UserRequest loginResponse = response.body();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class).putExtra("data", loginResponse));
                    finish();
                } else {
                    String message = "Se ha producido un error";
                    Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UserRequest> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Inicio de Sesión exitoso", Toast.LENGTH_LONG).show();
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