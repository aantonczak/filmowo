package com.example.aga.filmowo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Aga on 11.05.2018.
 */

class DatebaseHelper extends SQLiteOpenHelper {

    public DatebaseHelper(Context context) {
        super(context, "filmowo", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table filmowo(" +
                        "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "NAZWA_FILMU TEXT," +
                        "ROK_POWSTANIA DATE," +
                        "OPIS TEXT," +
                        "OCENY INTEGER," +
                        "KOMENATRZE TEXT);" +
                        "");

    }
    //tu jeszcze nie wiem co to, ale sie dowiemy
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS filmowo");
        onCreate(db);
    }
    //wstawianie do bazy nowego filmu
    public void dodajFilm(String nazwaFilmu, String opis){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues wartosci = new ContentValues();
        wartosci.put("NAZWA_FILMU", nazwaFilmu); //musi byc taka sama nazwa jak w bazie
        wartosci.put("OPIS", opis);
        try{
            db.insertOrThrow("filmowo", null,wartosci);
        }
        catch (SQLException e){
            System.out.println("Problem z przypisaniem do bazy");
        }

    }
    //pobieranie danych z bazy
    /*public Cursor wyswietlWszystkie(){
        String[] kolumny={"id", "nazwa","opis"};
        SQLiteDatabase db = getReadableDatabase();
        Cursor kursor = db.query("filmy",kolumny,null,null,null,null,null);
        return kursor;
    }*/

    public SQLiteCursor getAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteCursor kursor = (SQLiteCursor) db.rawQuery("SELECT * FROM "+"filmowo",null);
        return kursor;
    }
    public Cursor getAll1(){
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteCursor kursor = (SQLiteCursor) db.rawQuery("SELECT * FROM "+"filmowo",null);
        return kursor;
    }


}
