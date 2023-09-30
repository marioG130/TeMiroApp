package org.mywire.temiroapp.ui.train;

import static androidx.navigation.ViewKt.findNavController;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TrainActivity2 extends AppCompatActivity {

    private Button parpadeoButton;
    private Button enfoqueButton;
    private Button movimientosButton;
    private TextView mensajeParpadeo;
    private TextView mensajeEnfoque;
    private TextView mensajeMovimientos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);

        parpadeoButton = findViewById(R.id.parpadeoButton);
        enfoqueButton = findViewById(R.id.enfoqueButton);
        movimientosButton = findViewById(R.id.movimientosButton);
        mensajeParpadeo = findViewById(R.id.mensajeParpadeo);
        mensajeAgudeza = findViewById(R.id.mensajeEnfoque);
        mensajeMovimientos = findViewById(R.id.mensajeMovimientos);

        parpadeoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar mensaje de construcción para el ejercicio parpadeo
                mensajeParpadeo.setVisibility(View.VISIBLE);
            }
        });

        enfoqueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar mensaje de construcción para el ejercicio de enfoque
                mensajeEnfoque.setVisibility(View.VISIBLE);
            }
        });

        movimientosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar mensaje de construcción para el ejercicio movimientos
                mensajeMovimientos.setVisibility(View.VISIBLE);
            }
        });
    }
}