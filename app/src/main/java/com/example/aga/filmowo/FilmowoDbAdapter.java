package com.example.aga.filmowo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class FilmowoDbAdapter {

    private static final String DEBUG_TAG = "SqLiteFilmowoManager";

    private static final int DB_VERSION = 1; //wersja bazy danych
    private static final String DB_NAME = "database.db"; //nazwa pliku, w ktorym przechowywana jest baza
    private static final String DB_FILMOWO_TABLE = "filmowo"; //nazwa tabeli

    public static final String KEY_ID = "_id";
    public static final String ID_OPTIONS = "INTEGER PRIMARY KEY AUTOINCREMENT";
    public static final int ID_COLUMN = 0;
    public static final String KEY_NAME = "name";
    public static final String NAME_OPTIONS = "TEXT NOT NULL";
    public static final int NAME_COLUMN = 1;
    public static final String KEY_DESCRIPTION = "description";
    public static final String DESCRIPTION_OPTIONS = "TEXT NOT NULL";
    public static final int DESCRIPTION_COLUMN = 2;
    public static final String KEY_DATE = "date";
    public static final String DATE_OPTIONS = "TEXT DEFAULT 0";
    public static final int DATE_COLUMN = 3;

    private static final String DB_CREATE_FILMOWO_TABLE =
            "CREATE TABLE " + DB_FILMOWO_TABLE + "( " +
                    KEY_ID + " " + ID_OPTIONS + ", " +
                    KEY_NAME + " " + NAME_OPTIONS +  ", " +
                    KEY_DESCRIPTION + " " + DESCRIPTION_OPTIONS + ", " +
                    KEY_DATE + " " + DATE_OPTIONS +
                    ");";
    private static final String DROP_FILMOWO_TABLE =
            "DROP TABLE IF EXISTS " + DB_FILMOWO_TABLE;
    private SQLiteDatabase db;
    private Context context;
    private DatabaseHelper dbHelper;
    private static class DatabaseHelper extends SQLiteOpenHelper {
        public DatabaseHelper(Context context, String name,
                              SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DB_CREATE_FILMOWO_TABLE);

            Log.d(DEBUG_TAG, "Database creating...");
            Log.d(DEBUG_TAG, "Table " + DB_FILMOWO_TABLE + " ver." + DB_VERSION + " created");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DROP_FILMOWO_TABLE);

            Log.d(DEBUG_TAG, "Database updating...");
            Log.d(DEBUG_TAG, "Table " + DB_FILMOWO_TABLE + " updated from ver." + oldVersion + " to ver." + newVersion);
            Log.d(DEBUG_TAG, "All data is lost.");

            onCreate(db);
        }
    }
    public FilmowoDbAdapter(Context context) {
        this.context = context;
    }

    public FilmowoDbAdapter open(){
        dbHelper = new DatabaseHelper(context, DB_NAME, null, DB_VERSION);
        try {
            db = dbHelper.getWritableDatabase();
        } catch (SQLException e) {
            db = dbHelper.getReadableDatabase();
        }
        return this;
    }
    public void close() {
        dbHelper.close();
    }
    public long insertFilmowo(String name, String description, String date) {
        ContentValues newFilmowoValues = new ContentValues();
        newFilmowoValues.put(KEY_NAME, name);
        newFilmowoValues.put(KEY_DESCRIPTION, description);
        newFilmowoValues.put(KEY_DATE, date);
        return db.insert(DB_FILMOWO_TABLE, null, newFilmowoValues);
    }
    public boolean updateFilmowo(Movie task) {
        long id = task.getId();
        String name = task.getName();
        String description = task.getDescription();
        String date = task.getDate();
        return updateFilmowo(id,name, description, date);
    }

    public boolean updateFilmowo(long id,String name, String description, String date) {
        String where = KEY_ID + "=" + id;
      //  int completedTask = completed ? 1 : 0;
        ContentValues updateTodoValues = new ContentValues();
        updateTodoValues.put(KEY_NAME, name);
        updateTodoValues.put(KEY_DESCRIPTION, description);
        updateTodoValues.put(KEY_DATE, date);
        return db.update(DB_FILMOWO_TABLE, updateTodoValues, where, null) > 0;
    }
    public boolean deleteFilmowo(long id){
        String where = KEY_ID + "=" + id;
        return db.delete(DB_FILMOWO_TABLE, where, null) > 0;
    }
    public Cursor getAllFilmowo() {
        String[] columns = {KEY_ID,KEY_NAME, KEY_DESCRIPTION, KEY_DATE};
        return db.query(DB_FILMOWO_TABLE, columns, null, null, KEY_NAME, null, KEY_NAME);
    }

    public Movie getFilmowo(long id) {
        String[] columns = {KEY_ID,KEY_NAME, KEY_DESCRIPTION, KEY_DATE};
        String where = KEY_ID + "=" + id;
        Cursor cursor = db.query(DB_FILMOWO_TABLE, columns, where, null, null, null, null);
        Movie task = null;
        if(cursor != null && cursor.moveToFirst()) {
            String name = cursor.getString(NAME_COLUMN);
            String description = cursor.getString(DESCRIPTION_COLUMN);
            String date = cursor.getString(DATE_COLUMN);
           // boolean completed = cursor.getInt(COMPLETED_COLUMN) > 0 ? true : false;
            task = new Movie(id,name, description, date);
        }
        return task;
    }
}

