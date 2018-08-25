package com.lazday.fanlistview.data;

/**
 * Created by Lazday Indonesia on 17/05/18.
 * Get More : https://lazday.com
 */

public class Api {

    /**
     * get api_key at
     * https://www.themoviedb.org/documentation/api
     */

    private static String KEY           = "<<api_key>>";
    public static String MOVIE_POPULAR  = "http://api.themoviedb.org/3/movie/popular?api_key=" + KEY + "&language=en-US&page=1";
    public static String POSTER_PATH    = "http://image.tmdb.org/t/p/w600_and_h900_bestv2";
}
