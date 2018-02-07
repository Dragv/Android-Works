package com.moviles.projecto.listviewsspinners;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by drag on 2/02/18.
 */

public class StudentAdapter extends BaseAdapter{

    private ArrayList<Student> source;
    private Activity activity;

    public  StudentAdapter(ArrayList<Student> source, Activity activity){
        this.source = source;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return source.size();
    }

    @Override
    public Object getItem(int i) {
        return source.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        // view - la row (justamente)
        // si ya fue creada antes la recibimos de parametro
        // si no es null

        if (view == null){

            // crear el view por primera vez
            view = activity.getLayoutInflater().inflate(
                    R.layout.row,
                    null
            );
        }

        TextView nombre = (TextView)view.findViewById(R.id.textName);
        TextView calificaion = (TextView)view.findViewById(R.id.textGrade);

        Student actual = source.get(i);
        nombre.setText(actual.getNombre());
        calificaion.setText(actual.getCalificaion() + "");

        return view;
    }
}
