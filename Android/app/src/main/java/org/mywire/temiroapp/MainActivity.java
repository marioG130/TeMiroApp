package org.mywire.temiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.mywire.temiroapp.ui.store.storeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void Iniciar_store(View view){
        Intent iniciar_store = new Intent(this, storeActivity.class);
        startActivity(iniciar_store);


    }
}