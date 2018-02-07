package com.example.drag.class2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private Button button, button2;
    private  static final int PERRITO_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // retrieve a reference to the UI widgets
        textView = (TextView)findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);

        textView.setText("WELL HELLO THERE");
        editText.setHint("THIS IS AN EXAMPLE OF A HINT");
        button.setText("AWW YISS");

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(), "otro click", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //2 ways to deetect a click
    // declare a method that returns void and expects a View parameter


    public void clickTest(View v) {
        Log.i("Main", "Clickitty click");
        // FACTORY - regresa una instancia de Toast
        Toast.makeText(this, "Clicked", Toast.LENGTH_LONG).show();

        // cambio de actividad
        // - las actividades se manejan a nivel OS
        // - para abrir una nueva actividad solicitamos que se abra
        Intent intent = new Intent(this, DogeActivity.class);
        intent.putExtra("name", editText.getText().toString());
        intent.putExtra("pruba", 5);

        //startActivity(intent);
        startActivityForResult(intent, PERRITO_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // aqui escuchamos el regreso de una actividad
        if (requestCode == PERRITO_CODE && resultCode == Activity.RESULT_OK){
            Toast.makeText(this,
                             "PERRITO EXITOSO" + data.getStringExtra("regreso"),
                                  Toast.LENGTH_SHORT
            ).show();
        }
    }
}
