package org.mywire.temiroapp.ui.train;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.mywire.temiroapp.R;
import org.mywire.temiroapp.ui.user.LoginActivity;
import org.mywire.temiroapp.data.prefs.PreferencesHelper;
import android.net.Uri;
import android.widget.VideoView;

public class TrainActivity1 extends AppCompatActivity {

    boolean esUsuarioRegistrado;
    String nombreUsuario;
    int idUsuario;

    private Button parpadeoButton;
    private Button cuerdaButton;
    private Button movimientoButton;
    private TextView mensajeParpadeo;
    private TextView mensajeCuerda;
    private TextView mensajeMovimiento;
    private VideoView videoView;
    private TextView descripcionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_activity);

        parpadeoButton = findViewById(R.id.parpadeoButton);
        cuerdaButton = findViewById(R.id.cuerdaButton);
        movimientoButton = findViewById(R.id.movimientoButton);
        mensajeParpadeo = findViewById(R.id.mensajeParpadeo);
        mensajeCuerda = findViewById(R.id.mensajeCuerda);
        mensajeMovimiento = findViewById(R.id.mensajeMovimiento);
        videoView = findViewById(R.id.videoView);
        descripcionTextView = findViewById(R.id.descripcionTextView);
        descripcionTextView.setText("");
        ocultarMensajes();

        // Recupera valores desde las preferencias
        PreferencesHelper prefs = new PreferencesHelper(this);
        esUsuarioRegistrado = prefs.isUsuarioRegistrado();
        nombreUsuario = prefs.getNombreUsuario();
        idUsuario = prefs.getIdUsuario();

        parpadeoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ocultarMensajes();
                if (esUsuarioRegistrado) {
                    // Mostrar el video de Parpadeo
                    mensajeParpadeo.setVisibility(View.VISIBLE);
                    descripcionTextView.setText(getString(R.string.descripcion_parpadeo));
                    // Reemplaza "videoUrlParpadeo" por la URL correcta del video
                    String videoUrlParpadeo = "http://temiro.mywire.org:8000/media/video/parpadeo_1.mp4";
                    videoView.setVideoURI(Uri.parse(videoUrlParpadeo));
                    videoView.start();
                } else {
                    Toast.makeText(TrainActivity1.this, "Solo disponible para usuarios registrados !", Toast.LENGTH_LONG).show();
                    // Redirigir al usuario a la actividad de inicio de sesión
                    Intent intent = new Intent(TrainActivity1.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        cuerdaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ocultarMensajes();
                if (esUsuarioRegistrado) {
                    // Mostrar el video de Cuerda
                    mensajeCuerda.setVisibility(View.VISIBLE);
                    descripcionTextView.setText(getString(R.string.descripcion_enfoque));
                    // Reemplaza "videoUrlCuerda" por la URL correcta del video
                    String videoUrlEnfoque = "http://temiro.mywire.org:8000/media/video/enfoque_1.mp4";
                    videoView.setVideoURI(Uri.parse(videoUrlEnfoque));
                    videoView.start();
                } else {
                    Toast.makeText(TrainActivity1.this, "Solo disponible para usuarios registrados !", Toast.LENGTH_LONG).show();
                    // Redirigir al usuario a la actividad de inicio de sesión
                    Intent intent = new Intent(TrainActivity1.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        movimientoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ocultarMensajes();
                if (esUsuarioRegistrado) {
                    // Mostrar el video de Movimiento
                    mensajeMovimiento.setVisibility(View.VISIBLE);
                    descripcionTextView.setText(getString(R.string.descripcion_movimiento));
                    // Reemplaza "videoUrlMovimiento" por la URL correcta del video
                    String videoUrlMovimiento = "http://temiro.mywire.org:8000/media/video/movimiento_1.mp4";
                    videoView.setVideoURI(Uri.parse(videoUrlMovimiento));
                    videoView.start();
                } else {
                    Toast.makeText(TrainActivity1.this, "Solo disponible para usuarios registrados !", Toast.LENGTH_LONG).show();
                    // Redirigir al usuario a la actividad de inicio de sesión
                    Intent intent = new Intent(TrainActivity1.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    void ocultarMensajes() {
        mensajeParpadeo.setVisibility(View.INVISIBLE);
        mensajeCuerda.setVisibility(View.INVISIBLE);
        mensajeMovimiento.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (videoView.isPlaying()) {
            videoView.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        videoView.stopPlayback();
    }

}
