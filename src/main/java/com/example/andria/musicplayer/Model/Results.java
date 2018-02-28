package com.example.andria.musicplayer.Model;

/**
 * Created by Andria on 24/02/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Results extends RealmObject{


    @SerializedName("artistName")
    @Expose
    private String artistName;
    @SerializedName("collectionName")
    @Expose
    private String collectionName;

    @SerializedName("artworkUrl60")
    @Expose
    private String artworkUrl60;

    @SerializedName("trackPrice")
    @Expose
    private Double trackPrice;

    @PrimaryKey
    @SerializedName("trackName")
    @Expose
    private String trackName;

    @SerializedName("primaryGenreName")
    @Expose
    private String primaryGenreName;

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }


    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }



    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }


    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    public Double getTrackPrice() {
        return trackPrice;
    }

    public void setTrackPrice(Double trackPrice) {
        this.trackPrice = trackPrice;
    }

    public String getTrackName()
    {

        return trackName;
    }

    public void setTrackName( String trackName)
    {

        this.trackName=trackName;
    }




}

