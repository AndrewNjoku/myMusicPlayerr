package com.example.andria.musicplayer.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Andria on 25/02/2018.
 */

public class MusicSearchResults {


    @SerializedName(("results"))
    private List<Results> results;

    public List<Results> getResults(){

    return results;
    }

    public void setAlbum(List<Results> results){

        this.results = results;
    }

}
