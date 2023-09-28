package org.mywire.temiroapp.ui.store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.mywire.temiroapp.MainActivity;
import org.mywire.temiroapp.R;

public class storeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_activity);
    }

    public void Volver_store(View view){
        Intent volver_store = new Intent(this, MainActivity.class);
        startActivity(volver_store);


    }
}