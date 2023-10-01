package org.mywire.temiroapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import org.mywire.temiroapp.R;
import org.mywire.temiroapp.MainActivity;

public class ContactoDos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_contacto_dos);
    }

    public void volverAMenu(View view) {
        Intent act = new Intent(this, MainActivity.class);
        startActivity(act);
    }

}
