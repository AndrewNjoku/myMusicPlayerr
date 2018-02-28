package com.example.andria.musicplayer.Commmunication;

import com.example.andria.musicplayer.Model.Classic;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Andria on 25/02/2018.
 */

public interface APIclassic {


    @GET("search?term=classic")
    Call<Classic>getResultsplz2();//@Query("term") String genre);

}
