package org.mywire.temiroapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import org.mywire.temiroapp.R;

public class ContactoUno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_contacto_uno);
    }

    public void enviarConsulta(View view) {
        Intent act = new Intent(this, ContactoDos.class);
        startActivity(act);
    }

}
