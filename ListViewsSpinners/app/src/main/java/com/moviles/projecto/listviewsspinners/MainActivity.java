package com.moviles.projecto.listviewsspinners;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        spinner = (Spinner)findViewById(R.id.spinner);

        // como poblar widgets para colecciones
        // datos - Adapter - widget

        String[] source = {"Hermes", "Alejandro", "Edy", "Sara"};

        // Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                source
        );

        listView.setAdapter(adapter);
        spinner.setAdapter(adapter);
    }
}
