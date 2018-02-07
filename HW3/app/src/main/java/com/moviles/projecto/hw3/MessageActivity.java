package com.moviles.projecto.hw3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MessageActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        editText = (EditText)findViewById(R.id.editText3);
        button = (Button)findViewById(R.id.button3);
    }

    public void goBack(View v){
        Intent resultado = new Intent();
        resultado.putExtra("message", editText.getText().toString());
        setResult(Activity.RESULT_OK, resultado);
        finish();
    }
}
