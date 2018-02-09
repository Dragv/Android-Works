package com.moviles.projecto.activity4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by drag on 9/02/18.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE = "Activities.db";
    private static final String TABLE = "activity";
    private static final String FIELD_ID = "id";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_HOBBY = "hobby";

    public DBHelper(Context context){
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE + "(" +
                FIELD_ID + "INTEGER PRIMARY KEY, " +
                FIELD_NAME + "TEXT, " +
                FIELD_HOBBY + "TEXT)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS ?";
        String[] params = {TABLE};
        sqLiteDatabase.execSQL(query, params);
        onCreate(sqLiteDatabase);
    }

    public void save(String name, String hobby){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FIELD_NAME, name);
        values.put(FIELD_HOBBY, hobby);

        db.insert(TABLE, null, values);
    }

    public int delete(String name){
        SQLiteDatabase db = getWritableDatabase();
        String clause = FIELD_NAME + " = ?";
        String[] args = {name + " "};
        return db.delete(
                TABLE,
                clause,
                args
        );
    }

    public String find(String name){
        SQLiteDatabase db = getReadableDatabase();
        String clause = FIELD_NAME + " = ?";
        String[] args = {name};

        Cursor c = db.query(TABLE, null, clause, args, null, null, null, null);

        String result = "Nope";

        if (c.moveToFirst()){
            result = c.getString(2);
        }

        return result;
    }
}
