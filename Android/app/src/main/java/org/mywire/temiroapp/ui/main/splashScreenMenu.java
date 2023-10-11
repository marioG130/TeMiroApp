package org.mywire.temiroapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import org.mywire.temiroapp.MainActivity;
import org.mywire.temiroapp.R;

public class splashScreenMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_splash_screen_menu);


        Button button1 = findViewById(R.id.btn_splash_login);
        ImageButton button2 = findViewById(R.id.btn_splash_enter);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(splashScreenMenu.this, MainActivity.class);
                intent.putExtra("mostrarListaCompleta", true); // Pasa información adicional a la actividad "activity_main"
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(splashScreenMenu.this, MainActivity.class);
                intent.putExtra("mostrarListaCompleta", false); // Pasa información adicional a la actividad "activity_main"
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(splashScreenMenu.this, MainActivity.class);
                intent.putExtra("mostrarListaCompleta", false); // Pasa información adicional a la actividad "activity_main"
                startActivity(intent);
            }
        });






    }











}