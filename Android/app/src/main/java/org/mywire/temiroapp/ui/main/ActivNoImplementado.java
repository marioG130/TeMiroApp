package org.mywire.temiroapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import org.mywire.temiroapp.MainActivity;
import org.mywire.temiroapp.R;

public class ActivNoImplementado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activ_noimplementado);
    }

    public void botonVolverAClick(View view) {
        Intent act = new Intent(this, MainActivity.class);
        startActivity(act);
    }

}
