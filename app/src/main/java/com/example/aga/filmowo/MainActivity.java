package com.example.aga.filmowo;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView ranking0 = (TextView)findViewById(R.id.textView0); //pierwszy z TOP 5
        TextView ranking1 = (TextView)findViewById(R.id.textView1); //drugi
        TextView ranking2 = (TextView)findViewById(R.id.textView2);
        TextView ranking3 = (TextView)findViewById(R.id.textView3);
        TextView ranking4 = (TextView)findViewById(R.id.textView4);
        TextView trzyKropeczki = (TextView)findViewById(R.id.textView6); //trzy kropki do nowej aktywnosci ktora pokaze cala bazę filmow

        DatebaseHelper dh = new DatebaseHelper(this);
        Cursor k = dh.getAll();

        int i = 0;
        while (k.moveToNext() && i != 5){

            int id = k.getInt(0);
            String nazwa = k.getString(1);
            if(i == 0)
            {
                ranking0.setText(id +". "+ nazwa); //wyeswietlanie pierwszego z TOP 5
            }
            else if(i == 1){
                ranking1.setText(id+". "+nazwa);
            }
            else if(i == 2){
                ranking2.setText(id+". "+nazwa);
            }
            else if(i == 3){
                ranking3.setText(id+". "+nazwa);
            }
            else if(i == 4){
                ranking4.setText(id+". "+nazwa);
            }
            i++;
        }
//klikanie w przycisk dodaj film
        button = (Button) findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Context context;
                context = getApplicationContext();
                Intent intent = new Intent(context, dodajFilm.class);
                startActivity(intent);

            }
        });
//zeby mozna bylo kliknac w poszczegolne filmy z rankingu, ale to do zmieny, bo powielanie kodu
        ranking0.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Context context;
                context = getApplicationContext();
                Intent intent = new Intent(context, film.class);
                startActivity(intent);
            }
        });
        ranking1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Context context;
                context = getApplicationContext();
                Intent intent = new Intent(context, film.class);
                startActivity(intent);
            }
        });
        ranking2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Context context;
                context = getApplicationContext();
                Intent intent = new Intent(context, film.class);
                startActivity(intent);
            }
        });
        ranking3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Context context;
                context = getApplicationContext();
                Intent intent = new Intent(context, film.class);
                startActivity(intent);
            }
        });
        ranking4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Context context;
                context = getApplicationContext();
                Intent intent = new Intent(context, film.class);
                startActivity(intent);
            }
        });
        trzyKropeczki.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Context context;
                context = getApplicationContext();
                Intent intent = new Intent(context, listaFilmow.class);
                startActivity(intent);
            }
        });

    }


}
