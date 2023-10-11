package org.mywire.temiroapp.ui.train;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import org.mywire.temiroapp.R;
import android.net.Uri;
import android.widget.VideoView;

public class TrainActivity1 extends AppCompatActivity {

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

        //recordar la carpeta res/raw con los 3 videos
        // Configurar la fuente del video para Parpadeo
        final String videoPathParpadeo = "android.resource://" + getPackageName() + "/" + R.raw.parpadeo_ejer;
        parpadeoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar mensaje de construcción para el ejercicio Parpadeo
                mensajeParpadeo.setVisibility(View.VISIBLE);
                
                // Configurar el texto de descripción para el ejercicio Parpadeo
                descripcionTextView.setText(getString(R.string.descripcion_parpadeo));
                
                // Configurar la fuente del video y empezar la reproducción
                videoView.setVideoURI(Uri.parse(videoPathParpadeo));
                videoView.start();
            }
        });

        // Configurar la fuente del video para cuerda
        final String videoPathCuerda = "android.resource://" + getPackageName() + "/" + R.raw.cuerda_ejer;
        cuerdaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar mensaje de construcción para el ejercicio Cuerda
                mensajeCuerda.setVisibility(View.VISIBLE);
                
                // Configurar el texto de descripción para el ejercicio Cuerda
                descripcionTextView.setText(getString(R.string.descripcion_cuerda));
                
                // Configurar la fuente del video y empezar la reproducción
                videoView.setVideoURI(Uri.parse(videoPathCuerda));
                videoView.start();
            }
        });

        // Configurar la fuente del video para Movimientos
        final String videoPathMovimiento = "android.resource://" + getPackageName() + "/" + R.raw.movimiento_ejer;
        movimientoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar mensaje de construcción para el ejercicio Movimientos
                mensajeMovimiento.setVisibility(View.VISIBLE);
                
                // Configurar el texto de descripción para el ejercicio Movimientos
                descripcionTextView.setText(getString(R.string.descripcion_movimiento));
                
                // Configurar la fuente del video y empezar la reproducción
                videoView.setVideoURI(Uri.parse(videoPathMovimiento));
                videoView.start();
            }
        });
    }

    // Agregar los métodos onPause() y onDestroy() para gestionar el ciclo de vida del VideoView
    @Override
    protected void onPause() {
        super.onPause();
        // Pausar la reproducción del video si está en curso
        if (videoView.isPlaying()) {
            videoView.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Liberar recursos asociados al VideoView
        videoView.stopPlayback();
    }
}
