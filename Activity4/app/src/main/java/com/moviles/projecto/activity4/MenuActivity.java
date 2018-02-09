package com.moviles.projecto.activity4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    private Button button;
    private Button button2;
    private EditText name;
    private EditText hobby;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        db = new DBHelper(this);

        button = findViewById(R.id.button3);
        button2 = findViewById(R.id.button4);

        name = findViewById(R.id.name);
        hobby = findViewById(R.id.hobby);

        Intent intent = getIntent();
        name.setText(intent.getStringExtra("Name"));
    }

    public void goToHobbies(View v){

    }

    public void goToFriends(View v){

    }
    public void insertDb(View v){
        db.save(name.getText().toString(),
                hobby.getText().toString()
        );
    }

    public void findDb(View v){
        String result  = db.find(name.getText().toString());
        hobby.setText(result);
    }

    public void deleteDb(View v){
        int result = db.delete(name.getText().toString());
        Toast.makeText(this, result + " rows affected.", Toast.LENGTH_SHORT).show();
    }
}
