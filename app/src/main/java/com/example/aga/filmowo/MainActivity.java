package com.example.aga.filmowo;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button addButton;
    private TextView TOP1;
    private TextView TOP2;
    private TextView TOP3;
    private TextView TOP4;
    private TextView TOP5;
    private TextView allMovies;
    private FilmowoDbAdapter filmowoDbAdapter;
    private Cursor moviesCursor;
   // private List<TodoTask> tasks;
   // private TodoTasksAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUiElements();
        initButtonsOnClickListeners();

        filmowoDbAdapter = new FilmowoDbAdapter(getApplicationContext());
        filmowoDbAdapter.open();
        filmowoDbAdapter.getAllFilmowo();
        moviesCursor = filmowoDbAdapter.getAllFilmowo();

        int i = 0;
        while (moviesCursor.moveToNext() && i != 5){

            int id = moviesCursor.getInt(0);
            String nazwa = moviesCursor.getString(1);
            if(i == 0)
            {
                TOP1.setText(id +". "+ nazwa); //wyeswietlanie pierwszego z TOP 5
            }
            else if(i == 1){
                TOP2.setText(id+". "+nazwa);
            }
            else if(i == 2){
                TOP3.setText(id+". "+nazwa);
            }
            else if(i == 3){
                TOP4.setText(id+". "+nazwa);
            }
            else if(i == 4){
                TOP5.setText(id+". "+nazwa);
            }
            i++;
        }


    }
    private void initUiElements() {
        addButton = (Button) findViewById(R.id.button1);
        TOP1 = (TextView)findViewById(R.id.textView0); //pierwszy z TOP 5
        TOP2 = (TextView)findViewById(R.id.textView1); //drugi
        TOP3 = (TextView)findViewById(R.id.textView2);
        TOP4 = (TextView)findViewById(R.id.textView3);
        TOP5 = (TextView)findViewById(R.id.textView4);
        allMovies = (TextView)findViewById(R.id.textView6); //trzy kropki do nowej aktywnosci ktora pokaze cala bazę filmow
    }


    private void initButtonsOnClickListeners() {
        //klikanie w przycisk dodaj film

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Context context;
                context = getApplicationContext();
                Intent intent = new Intent(context, AddMovie.class);
                startActivity(intent);

            }
        });

//zeby mozna bylo kliknac w poszczegolne filmy z rankingu, ale to do zmieny, bo powielanie kodu
        TOP1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Context context;
                context = getApplicationContext();
                Intent intent = new Intent(context, MovieDetails.class);
                startActivity(intent);
            }
        });
        TOP2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Context context;
                context = getApplicationContext();
                Intent intent = new Intent(context, MovieDetails.class);
                startActivity(intent);
            }
        });
        TOP3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Context context;
                context = getApplicationContext();
                Intent intent = new Intent(context, MovieDetails.class);
                startActivity(intent);
            }
        });
        TOP4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Context context;
                context = getApplicationContext();
                Intent intent = new Intent(context, MovieDetails.class);
                startActivity(intent);
            }
        });
        TOP5.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Context context;
                context = getApplicationContext();
                Intent intent = new Intent(context, MovieDetails.class);
                startActivity(intent);
            }
        });
        allMovies.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Context context;
                context = getApplicationContext();
                Intent intent = new Intent(context, ListOfMovies.class);
                startActivity(intent);
            }
        });

    }



}
