package com.lazday.fanlistview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lazday.fanlistview.R;
import com.lazday.fanlistview.data.Api;
import com.lazday.fanlistview.data.model.Movie;
import com.lazday.fanlistview.utils.DownloadImage;

import java.util.List;

public class MainAdapter extends ArrayAdapter<Movie> {

    public MainAdapter(@NonNull Context context, @NonNull List<Movie> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Movie movie = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.adapter_main, parent, false
            );
        }

        ImageView imgPoster     = convertView.findViewById(R.id.imgPoster);
        TextView txtTitle     = convertView.findViewById(R.id.txtTitle);

        Log.i("_poster", Api.POSTER_PATH + movie.getPoster());
        DownloadImage.picasso(Api.POSTER_PATH + movie.getPoster(), imgPoster);
        txtTitle.setText( movie.getTitle() );

        return convertView;
    }
}
