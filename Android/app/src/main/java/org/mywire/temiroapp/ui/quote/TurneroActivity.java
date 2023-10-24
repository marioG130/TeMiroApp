package org.mywire.temiroapp.ui.quote;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import org.mywire.temiroapp.MainActivity;
import org.mywire.temiroapp.R;

public class TurneroActivity extends AppCompatActivity {

    private EditText editTextTema;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private final Calendar selectedDateTime = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quote_turnero);

        editTextTema = findViewById(R.id.editTextTema);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);

        Button btnReservar = findViewById(R.id.btnReservar);
        btnReservar.setOnClickListener(v -> {
            String temaCita = editTextTema.getText().toString();

            if (validarFechaHora() && !temaCita.isEmpty()) {

                guardarReserva(temaCita);
                Toast.makeText(TurneroActivity.this, "Reserva guardada", Toast.LENGTH_SHORT).show();

                Intent act = new Intent(TurneroActivity.this, TurnoAgendadoActivity.class);
                startActivity(act);

            } else {
                Toast.makeText(TurneroActivity.this, "Por favor, completa todos los campos correctamente", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnVolverHome = findViewById(R.id.btnVolverHome);
        btnVolverHome.setOnClickListener(v -> {
            Intent act = new Intent(TurneroActivity.this, MainActivity.class);
            startActivity(act);
        });
    }

    private boolean validarFechaHora() {
        int dayOfWeek = selectedDateTime.get(Calendar.DAY_OF_WEEK);
        int hourOfDay = selectedDateTime.get(Calendar.HOUR_OF_DAY);

        if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
            Toast.makeText(this, "Por favor, elija un día entre lunes y viernes", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (hourOfDay < 9 || hourOfDay >= 18) {
            Toast.makeText(this, "Por favor, elija una hora entre las 9am y las 6pm", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void guardarReserva(String tema) {
        // Aquí implementar la lógica para guardar la reserva con el tema, la fecha y la hora seleccionada
        // Usar SharedPreferences o la base de datos para almacenar la información
    }
}
