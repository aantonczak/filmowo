package com.example.aga.filmowo;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;


public class listaFilmow extends AppCompatActivity {

    private ListView filmy;
    ArrayList<String> listItem;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmow);
        DatebaseHelper dh = new DatebaseHelper(this);
        Cursor k = dh.getAll1();
        listItem = new ArrayList<>();
        if(k.getCount() == 0)
        {
            Toast.makeText(this,"Brak filmow do wyswietlenia", Toast.LENGTH_SHORT).show();
        }
        else
        {
                while (k.moveToNext())
                {
                    listItem.add(k.getString(1)); //indeks 1 to nazwa filmu
                }
                adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);

                if(listItem.isEmpty())
                {

                    Toast.makeText(this,"lista pusta", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    Toast.makeText(this,"lista pelna", Toast.LENGTH_SHORT).show();
                }
           // filmy.setAdapter(adapter); //cos to sie krzaczy

        }





    }

}
