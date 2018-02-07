package com.moviles.projecto.hw3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HobbiesActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobbies);

        textView = (TextView)findViewById(R.id.textView4);
        editText = (EditText)findViewById(R.id.editText2);
        button = (Button)findViewById(R.id.button2);
    }

    public void goBack(View v){
        Intent resultado = new Intent();
        resultado.putExtra("hobby", editText.getText().toString());
        setResult(Activity.RESULT_OK, resultado);
        finish();
    }
}
