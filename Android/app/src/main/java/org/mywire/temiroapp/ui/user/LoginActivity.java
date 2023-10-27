package org.mywire.temiroapp.ui.user;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;
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

    public interface LoginUserCallbacks {
        void onSuccess(Boolean value);
        void onError(Throwable throwable);
    }

    EditText usuario;
    EditText contrasena;
    boolean verificado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login_activity);
        usuario = findViewById(R.id.nombreUsuario);
        contrasena = findViewById(R.id.contrasena);
    }

    public void iniciarSesion(View view) {
        PreferencesHelper prefs;
        String nombre, clave;
        User uRequest;

        prefs = new PreferencesHelper(this);
        nombre = String.valueOf(usuario.getText());
        clave = String.valueOf(contrasena.getText());
        verificado = false;
        if (nombre.isEmpty()) {
            usuario.setError("Debe ingresar su nombre de usuario");
        }
        if (clave.isEmpty()) {
            contrasena.setError("Debe ingresar su contraseña");
        }
        if (nombre.isEmpty() || clave.isEmpty()) {
            Toast.makeText(LoginActivity.this, "Ingrese un nombre de usuario y contraseña", Toast.LENGTH_LONG).show();
            return;
        } else {
            uRequest = new User();
            uRequest.setUsuario(nombre);
            uRequest.setPassword(clave);
            loginUsuario(uRequest, new LoginUserCallbacks() {
                @Override
                public void onSuccess(Boolean value) {
                    verificado = value;
                    if (verificado) {
                        Log.d("LOGIN","Verificado "+nombre);
                        prefs.setUsuarioRegistrado(true);
                        prefs.setNombreUsuario(nombre);
                        // La siguiente funcion buscará los datos adicionales del usuario, como el id
                        // que serán guardados luego en las prefs durante el callback de esa función
                        traerDatosUsuario(nombre);
                        // Al finalizar el callback arrancará la MainActivity con ese usuario
                    } else {
                        Log.d("LOGIN","NO verificado");
                        Toast.makeText(LoginActivity.this, "Error en usuario o contraseña !", Toast.LENGTH_LONG).show();
                        prefs.setUsuarioRegistrado(false);
                        // Arranca la MainActivity como un usuario genérico
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
                @Override
                public void onError(Throwable t) {
                    Log.d("LOGIN",t.getMessage());
                }
            });
        }
    }

    public void loginUsuario(User uReq, LoginUserCallbacks callbacks) {
        Call<String> loginResponseCall = UserApiClient.getService().loginUser(uReq);
        loginResponseCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("LOGIN",response.toString());
                Log.d("LOGIN",String.valueOf(response.code()));
                if (response.isSuccessful()) {
                    if (response.code()==200) {
                        callbacks.onSuccess(true);  // code 200 "OK"
                    } else {
                        callbacks.onSuccess(false); // code 401 "NO AUTORIZADO"
                    }
                } else {
                    callbacks.onSuccess(false);
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("LOGIN", t.getMessage());
                callbacks.onError(t);
            }
        });
    }

    public void traerDatosUsuario(String nombreU) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://temiro.mywire.org:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // se obtiene el nombre de usuario de la API de usuario
        ApiService usuarioApiService = retrofit.create(ApiService.class);
        Call<List<User>> usuarioCall = usuarioApiService.getUsuarios();
        usuarioCall.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    List<User> usuarios = response.body();
                    // Busca el nombre de usuario en la lista de usuarios
                    int idCliente = -1;
                    for (User u : usuarios) {
                        if (u.getUsuario().equals(nombreU)) {
                            idCliente = u.getIdusuario();
                            break;
                        }
                    }
                    if (idCliente > 0) {
                        PreferencesHelper prefs = new PreferencesHelper(LoginActivity.this);
                        prefs.setIdUsuario(idCliente);
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
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
