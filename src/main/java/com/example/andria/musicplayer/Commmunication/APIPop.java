package com.example.andria.musicplayer.Commmunication;

import com.example.andria.musicplayer.Model.Classic;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Andria on 25/02/2018.
 */

public interface APIPop {


    @GET("search")
    Call<List<Classic>> getAlbums(@Query("term") String genre);

}
