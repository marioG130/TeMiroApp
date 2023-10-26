package org.mywire.temiroapp.ui.quote;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import org.mywire.temiroapp.MainActivity;
import org.mywire.temiroapp.R;

public class TurnoAgendadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quote_turno_agendado);

        Button btnCancelar = findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(v -> {
            Intent act = new Intent(TurnoAgendadoActivity.this, TurnoCanceladoActivity.class);
            startActivity(act);
        });

        Button btnVolverHome = findViewById(R.id.btnVolverHome);
        btnVolverHome.setOnClickListener(v -> {
            Intent act = new Intent(TurnoAgendadoActivity.this, MainActivity.class);
            startActivity(act);
        });
    }

}
