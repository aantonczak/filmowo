package com.example.aga.filmowo;

import android.app.Activity;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MoviesAdapter extends ArrayAdapter<Movie> {

    private Activity context;
    private List<Movie> movies;
    public MoviesAdapter(Activity context, List<Movie> movies) {
        super(context, R.layout.list_of_movies_item, movies);
        this.context = context;
        this.movies = movies;
    }

    static class ViewHolder {
        public TextView tvNameMovie;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        View rowView = convertView;
        if(rowView == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            rowView = layoutInflater.inflate(R.layout.activity_movies_list, null, true);
            viewHolder = new ViewHolder();
            viewHolder.tvNameMovie = (TextView) rowView.findViewById(R.id.tvNameMovie);
            rowView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) rowView.getTag();
        }
        Movie task = movies.get(position);
        viewHolder.tvNameMovie.setText(task.getName());
  //      viewHolder.tvNameMovie.setPaintFlags(viewHolder.tvNameMovie.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        return rowView;
    }

}
