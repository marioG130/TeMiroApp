package org.mywire.temiroapp.ui.test;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.mywire.temiroapp.R;
import org.mywire.temiroapp.data.local.SQLmanager;

public class TestPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activ_principal);
        SQLmanager man = new SQLmanager(this);
        man.crearDatabase();
        man.cargarDatosEpica6();
    }

}
