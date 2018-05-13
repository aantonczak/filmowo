package com.example.aga.filmowo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class dodajFilm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_film);
        DatebaseHelper dh = new DatebaseHelper(this);
        dh.dodajFilm("Psy", "Franz Maurer, były funkcjonariusz Służby Bezpieczeństwa, zaczyna pracę w policji. Tymczasem jego kolega oferuje swoje usługi przestępcom. ");
        dh.dodajFilm("Psy II: Ostatnia krew", "Franz Maurer po wyjściu z więzienia przystaje do grupy zajmującej się nielegalnym handlem bronią.");
        dh.dodajFilm("Shrek", "By odzyskać swój dom, brzydki ogr z gadatliwym osłem wyruszają uwolnić piękną księżniczkę.");
        dh.dodajFilm("Filadelfia ", "Chorujący na AIDS prawnik zostaje zwolniony z pracy. Walcząc o godność, podaje do sądu byłych pracodawców.");
    }
}
