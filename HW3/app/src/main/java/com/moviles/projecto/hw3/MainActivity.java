package com.moviles.projecto.hw3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private  static final int CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);
    }

    public void clickInitial(View v){
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("name", editText.getText().toString());
        startActivityForResult(intent, CODE);
    }
}
