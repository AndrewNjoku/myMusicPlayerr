package com.example.andria.musicplayer.Interactor;

import com.example.andria.musicplayer.Model.Classic;
import com.example.andria.musicplayer.Model.Results;

import java.util.List;

import javax.xml.transform.Result;

/**
 * Created by Andria on 25/02/2018.
 */

public class RockInteractor {

    List<Results> results;
    Classic c;

    public RockInteractor(){

        c=new Classic();


    }




    public void setValue(Classic c ){

        this.c=c;
    }

    public Classic getValue(){

        return c;
    }
}
