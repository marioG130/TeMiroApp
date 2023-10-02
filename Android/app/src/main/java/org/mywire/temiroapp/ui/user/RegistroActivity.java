package org.mywire.temiroapp.ui.user;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import org.mywire.temiroapp.R;

public class RegistroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_registro_activity);
    }

    public void iniciarLogin(View view) {
        Intent act = new Intent(this, LoginActivity.class);
        startActivity(act);
    }

    public void volverLogin(View view) {
        Intent act = new Intent(this, LoginActivity.class);
        startActivity(act);
    }

}
