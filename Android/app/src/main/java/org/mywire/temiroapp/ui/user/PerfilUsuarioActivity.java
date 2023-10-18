package org.mywire.temiroapp.ui.user;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import org.mywire.temiroapp.MainActivity;
import org.mywire.temiroapp.R;

public class PerfilUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_perfil_activity);
    }

    public void iniciarHome(View view) {
        Intent act = new Intent(this, MainActivity.class);
        startActivity(act);
    }

}
