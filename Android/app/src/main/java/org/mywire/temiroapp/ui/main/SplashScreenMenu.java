package org.mywire.temiroapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import org.mywire.temiroapp.MainActivity;
import org.mywire.temiroapp.R;
import org.mywire.temiroapp.ui.user.LoginActivity;

public class SplashScreenMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_splash_screen_menu);

        LinearLayout buttonI1 = findViewById(R.id.ll_splash_enter);
        ImageButton buttonI2 = findViewById(R.id.btn_splash_enter);
        Button buttonLogin = findViewById(R.id.btn_splash_login);

        View.OnClickListener myListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashScreenMenu.this, MainActivity.class);
                intent.putExtra("esUsuarioRegistrado", false); // Pasa información adicional a la actividad "activity_main"
                startActivity(intent);
            }
        };
        buttonI1.setOnClickListener(myListener);
        buttonI2.setOnClickListener(myListener);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashScreenMenu.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}
