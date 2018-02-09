package com.moviles.projecto.activity4;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private EditText editText;

    private Properties properties;
    public static final String PROPERTIES_FILE = "properties.xml";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        editText = (EditText)findViewById(R.id.editText);

        editText.setText("Hermes");

        properties = new Properties();
        File file = new File(getFilesDir(), PROPERTIES_FILE);

        try {

            if (file.exists()){
                FileInputStream fis = openFileInput(PROPERTIES_FILE);
                properties.loadFromXML(fis);
                properties.getProperty("Name");
                fis.close();
            } else {
                saveProperties();
            }

            InputStream is = getResources().openRawResource(R.raw.texto);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String first = br.readLine();

            AssetManager manager = getAssets();
            is = manager.open("text.txt");
            br = new BufferedReader(new InputStreamReader(is));

            String second = br.readLine();

            textView1.setText(first);
            textView2.setText(second);

        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public void saveProperties() throws IOException{
        FileOutputStream fos = openFileOutput(PROPERTIES_FILE, Context.MODE_PRIVATE);
        properties.setProperty("Name", this.editText.getText().toString());
        properties.storeToXML(fos, null);
    }

    public void saveName(View v) throws IOException{
        FileOutputStream fos = openFileOutput(PROPERTIES_FILE, Context.MODE_PRIVATE);
        properties.setProperty("Name", this.editText.getText().toString());
        properties.storeToXML(fos, null);
    }

    public void goToMenu(View v) throws IOException{
        Intent intent = new Intent(this, MenuActivity.class);
        File file = new File(getFilesDir(), PROPERTIES_FILE);
        if (file.exists()){
            FileInputStream fis = openFileInput(PROPERTIES_FILE);
            properties.loadFromXML(fis);
            intent.putExtra("Name", properties.getProperty("Name"));
            fis.close();
        } else {
            saveProperties();
        }
        startActivity(intent);
    }
}
