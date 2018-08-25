package com.lazday.fanlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.lazday.fanlistview.adapter.MainAdapter;
import com.lazday.fanlistview.data.Api;
import com.lazday.fanlistview.data.model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listView)
    ListView listView;

    List<Movie> movies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fastAndroidNetworking();
    }

    private void fastAndroidNetworking(){
        AndroidNetworking.get(Api.MOVIE_POPULAR)
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("results");
                            for (int i = 0; i < jsonArray.length(); i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                Movie movie = new Movie();
                                movie.setPoster(jsonObject.optString("poster_path"));
                                movie.setTitle(jsonObject.optString("title"));
                                movies.add(movie);
                            }

                            MainAdapter mainAdapter = new MainAdapter(MainActivity.this, movies);
                            listView.setAdapter(mainAdapter);
                        } catch (JSONException e){

                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }
}
