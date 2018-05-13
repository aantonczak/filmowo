package com.example.aga.filmowo;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddMovie extends AppCompatActivity {


    private FilmowoDbAdapter filmowoDbAdapter;
    private Button button;
    private Cursor moviesCursor;
    private EditText name;
    private EditText yearOfProduction;
    private EditText dateOfPremiere;
    private EditText description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);


        initUiElements();
        initButtonsOnClickListeners();

      //  filmowoDbAdapter = new FilmowoDbAdapter(getApplicationContext());
      //  filmowoDbAdapter.open();
     //   filmowoDbAdapter.insertFilmowo("Psy", "Franz Maurer, były funkcjonariusz Służby Bezpieczeństwa, zaczyna pracę w policji. Tymczasem jego kolega oferuje swoje usługi przestępcom. ", "data");
     //   filmowoDbAdapter.insertFilmowo("Psy", "Franz Maurer, były funkcjonariusz Służby Bezpieczeństwa, zaczyna pracę w policji. Tymczasem jego kolega oferuje swoje usługi przestępcom. ", "19000");
     //   filmowoDbAdapter.insertFilmowo("Psy II: Ostatnia krew", "Franz Maurer po wyjściu z więzienia przystaje do grupy zajmującej się nielegalnym handlem bronią.","2222");
      //  filmowoDbAdapter.insertFilmowo("Shrek", "By odzyskać swój dom, brzydki ogr z gadatliwym osłem wyruszają uwolnić piękną księżniczkę.","1290");
       // filmowoDbAdapter.insertFilmowo("Filadelfia ", "Chorujący na AIDS prawnik zostaje zwolniony z pracy. Walcząc o godność, podaje do sądu byłych pracodawców.","1290");

    }

    private void initUiElements() {
        button = (Button) findViewById(R.id.bSave);
        name = (EditText) findViewById(R.id.edName);
        yearOfProduction = (EditText) findViewById(R.id.edYearOfProduction);
        dateOfPremiere = (EditText) findViewById(R.id.edDateOfPremiere);
        description = (EditText) findViewById(R.id.edDescription);
    }

    private void initButtonsOnClickListeners() {
        //klikanie w przycisk dodaj film

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
               addMovie();
            }
        });



    }
    private void addMovie(){

        filmowoDbAdapter = new FilmowoDbAdapter(getApplicationContext());
        filmowoDbAdapter.open();
        filmowoDbAdapter.insertFilmowo(name.getText().toString(), description.getText().toString(), yearOfProduction.getText().toString());
        Toast msg = Toast.makeText(getBaseContext(),"Dodano film",Toast.LENGTH_LONG);

    }

}
