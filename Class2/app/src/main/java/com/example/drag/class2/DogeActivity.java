package com.example.drag.class2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DogeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doge);

        Intent intent = getIntent();

        Toast.makeText(this,
                         intent.getStringExtra("prueba") + " " + intent.getIntExtra("prueba", 0),
                              Toast.LENGTH_SHORT
        ).show();
    }

    public void regresar(View v){
        // para regresar
        Intent resultado = new Intent();
        resultado.putExtra("regreso", "REGRESO Y ESTUVO BIEN")
        setResult(Activity.RESULT_OK, resultado);
        finish();
    }
}
