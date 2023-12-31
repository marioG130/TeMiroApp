package org.mywire.temiroapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import org.mywire.temiroapp.R;
import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_splash_screen_start);

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenStart.this, SplashScreenMenu.class);
                startActivity(intent);
                finish();
            }
        };
        Timer tiempo = new Timer();
        tiempo.schedule(tarea, 3000);
    }

}
