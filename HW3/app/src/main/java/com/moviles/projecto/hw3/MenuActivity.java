package com.moviles.projecto.hw3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    private TextView textView;
    private TextView textView2;
    private ImageButton imageButton;
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private final static int HOBBY_CODE = 0;
    private final static int FRIENDS_CODE = 1;
    private final static int MSG_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();

        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        imageButton = (ImageButton)findViewById(R.id.imageButton);
        imageButton2 = (ImageButton)findViewById(R.id.imageButton4);
        imageButton3 = (ImageButton)findViewById(R.id.imageButton5);

        textView.setText(intent.getStringExtra("name"));
    }

    public void changeToHobbies(View v){
        Intent intent = new Intent(this, HobbiesActivity.class);
        startActivityForResult(intent, HOBBY_CODE);
    }

    public void changeToFriends(View v){
        Intent intent = new Intent(this, FriendsActivity.class);
        startActivityForResult(intent, FRIENDS_CODE);
    }

    public void changeToMessage(View v){
        Intent intent = new Intent(this, MessageActivity.class);
        startActivityForResult(intent, MSG_CODE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(resultCode, resultCode, data);

        if (requestCode == HOBBY_CODE && resultCode == Activity.RESULT_OK){
            textView2.setText(data.getStringExtra("hobby"));
        }

        if (requestCode == MSG_CODE && resultCode == Activity.RESULT_OK){
            Toast.makeText(this, "Mensaje: " + data.getStringExtra("message") + ". enviado", Toast.LENGTH_SHORT).show();
        }
    }
}
