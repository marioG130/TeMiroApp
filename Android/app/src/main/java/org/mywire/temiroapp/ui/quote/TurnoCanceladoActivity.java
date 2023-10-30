package org.mywire.temiroapp.ui.quote;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import org.mywire.temiroapp.MainActivity;
import org.mywire.temiroapp.R;

public class TurnoCanceladoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quote_turno_cancelado);

        Button btnNuevaReserva = findViewById(R.id.btnNuevaReserva);
        btnNuevaReserva.setOnClickListener(v -> {
            Intent act = new Intent(TurnoCanceladoActivity.this, TurneroActivity.class);
            startActivity(act);
        });

        Button btnVolverHome = findViewById(R.id.btnVolverHome);
        btnVolverHome.setOnClickListener(v -> {
            Intent act = new Intent(TurnoCanceladoActivity.this, MainActivity.class);
            startActivity(act);
        });
    }

}
