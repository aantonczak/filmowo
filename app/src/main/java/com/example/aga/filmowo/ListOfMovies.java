package com.example.aga.filmowo;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;


public class ListOfMovies extends AppCompatActivity {

   private ListView lvMovies;
    
    private FilmowoDbAdapter filmowoDbAdapter;
    private Cursor filmowoCursor;
    private List<Movie> movies;
    private MoviesAdapter listAdapter;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);
        initUiElements();
        initListView();
        
    }

    private void initUiElements() {
        
        lvMovies = (ListView) findViewById(R.id.lvMovies);
        
    }

    private void initListView() {
        fillListViewData();
        initListViewOnItemClick();
    }

    private void fillListViewData() {
        filmowoDbAdapter = new FilmowoDbAdapter(getApplicationContext());
        filmowoDbAdapter.open();
        getAllMovies();
        listAdapter = new MoviesAdapter(this, movies);
        lvMovies.setAdapter(listAdapter);
    }

    private void getAllMovies() {
        movies = new ArrayList<Movie>();
        filmowoCursor = getAllEntriesFromDb();
        updateTaskList();
    }

    private Cursor getAllEntriesFromDb() {
        filmowoCursor = filmowoDbAdapter.getAllFilmowo();
        if(filmowoCursor != null) {
            startManagingCursor(filmowoCursor);
            filmowoCursor.moveToFirst();
        }
        return filmowoCursor;
    }

    private void updateTaskList() {
        if(filmowoCursor != null && filmowoCursor.moveToFirst()) {
            do {
                long id = filmowoCursor.getLong(FilmowoDbAdapter.ID_COLUMN);
                String name = filmowoCursor.getString(FilmowoDbAdapter.NAME_COLUMN);
                String description = filmowoCursor.getString(FilmowoDbAdapter.DESCRIPTION_COLUMN);
                String date = filmowoCursor.getString(FilmowoDbAdapter.DATE_COLUMN);
                //boolean completed = filmowoCursor.getInt(FilmowoDbAdapter.COMPLETED_COLUMN) > 0 ? true : false;
                movies.add(new Movie(id,name, description, date));
            } while(filmowoCursor.moveToNext());
        }
    }

 //   @Override
   /* protected void onDestroy() {
        if(FilmowoDbAdapter != null)
            FilmowoDbAdapter.close();
        super.onDestroy();
    }*/

    private void initListViewOnItemClick() {
        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position,
                                    long id) {
                Movie task = movies.get(position);
               // if(task.isCompleted()){
                 //   FilmowoDbAdapter.updateTodo(task.getId(), task.getDescription(), false);
               // } else {
                //    FilmowoDbAdapter.updateTodo(task.getId(), task.getDescription(), true);
               // }
                updateListViewData();
            }
        });
    }

    private void updateListViewData() {
        filmowoCursor.requery();
        movies.clear();
        updateTaskList();
        listAdapter.notifyDataSetChanged();
    }








}
