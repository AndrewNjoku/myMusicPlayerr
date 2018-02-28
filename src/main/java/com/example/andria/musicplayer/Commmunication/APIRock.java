package com.example.andria.musicplayer.Commmunication;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import com.example.andria.musicplayer.Model.Classic;
import com.example.andria.musicplayer.Model.Results;

import java.util.List;

/**
 * Created by Andria on 25/02/2018.
 */

public interface APIRock {


    @GET("search?term=rock")

    Call<Classic>getResultsplz();//@Query("term") String genre);


}
