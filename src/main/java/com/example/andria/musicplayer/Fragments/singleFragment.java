package com.example.andria.musicplayer.Fragments;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.andria.musicplayer.R;

/**
 * Created by Andria on 25/02/2018.
 */

public abstract class singleFragment extends AppCompatActivity {
    protected abstract Fragment createNewFragment();




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){

System.out.println("is this even being used?");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutses);

        FragmentManager fm=getSupportFragmentManager();
        Fragment fragment= fm.findFragmentById(R.id.fragment_container);

        System.out.println("inside the onCreate for single Fragment");

        if(fragment==null)
        {


            fragment=createNewFragment();
            fm.beginTransaction().add(R.id.fragment_container,fragment).commit();
        }

// Replace the contents of the container with the new fragment
    }
}
