package org.mywire.temiroapp.ui.train;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.mywire.temiroapp.R;
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

        Button loginButton = findViewById(R.id.loginButton);
        Button registroButton = findViewById(R.id.registroButton);

        parpadeoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validar()) {
                    // Mostrar el video de Parpadeo
                    mensajeParpadeo.setVisibility(View.VISIBLE);
                    descripcionTextView.setText(getString(R.string.descripcion_parpadeo));
                    // Reemplaza "videoUrlParpadeo" por la URL correcta del video
                    String videoUrlParpadeo = "http://temiro.mywire.org:8000/media/video/parpadeo_1.mp4";
                    videoView.setVideoURI(Uri.parse(videoUrlParpadeo));
                    videoView.start();
                } else {
                    // Redirigir al usuario a la actividad de inicio de sesión
                    Intent intent = new Intent(TrainActivity1.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        cuerdaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validar()) {
                    // Mostrar el video de Cuerda
                    mensajeCuerda.setVisibility(View.VISIBLE);
                    descripcionTextView.setText(getString(R.string.descripcion_cuerda));
                    // Reemplaza "videoUrlCuerda" por la URL correcta del video
                    String videoUrlCuerda = "http://temiro.mywire.org:8000/media/video/enfoque_1.mp4";
                    videoView.setVideoURI(Uri.parse(videoUrlCuerda));
                    videoView.start();
                } else {
                    // Redirigir al usuario a la actividad de inicio de sesión
                    Intent intent = new Intent(TrainActivity1.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        movimientoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validar()) {
                    // Mostrar el video de Movimiento
                    mensajeMovimiento.setVisibility(View.VISIBLE);
                    descripcionTextView.setText(getString(R.string.descripcion_movimiento));
                    // Reemplaza "videoUrlMovimiento" por la URL correcta del video
                    String videoUrlMovimiento = "http://temiro.mywire.org:8000/media/video/movimiento_1.mp4";
                    videoView.setVideoURI(Uri.parse(videoUrlMovimiento));
                    videoView.start();
                } else {
                    // Redirigir al usuario a la actividad de inicio de sesión
                    Intent intent = new Intent(TrainActivity1.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirigir al usuario a la actividad de inicio de sesión
                Intent intent = new Intent(TrainActivity1.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        registroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirigir al usuario a la actividad de registro
                Intent intent = new Intent(TrainActivity1.this, RegistroActivity.class);
                startActivity(intent);
            }
        });
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

   /* private boolean validar() {
        return usuarioHaIniciadoSesion;
    } */
}
