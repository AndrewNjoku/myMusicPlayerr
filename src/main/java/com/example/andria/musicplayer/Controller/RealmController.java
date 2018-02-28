package com.example.andria.musicplayer.Controller;


import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

import com.example.andria.musicplayer.Model.Results;

import io.realm.Realm;
import io.realm.RealmResults;


public class RealmController {

    private static RealmController instance;
    private final Realm realm;

    public RealmController(Application application) {
        realm = Realm.getDefaultInstance();
    }

    public static RealmController with(Fragment fragment) {

        if (instance == null) {
            instance = new RealmController(fragment.getActivity().getApplication());
        }
        return instance;
    }

    public static RealmController with(Activity activity) {

        if (instance == null) {
            instance = new RealmController(activity.getApplication());
        }
        return instance;
    }

    public static RealmController with(Application application) {

        if (instance == null) {
            instance = new RealmController(application);
        }
        return instance;
    }

    public static RealmController getInstance() {

        return instance;
    }

    public Realm getRealm() {

        return realm;
    }

    //Refresh the realm istance
    public void refresh() {

        realm.refresh();
    }

    //clear all objects from Results.class
    public void clearAll() {

        realm.deleteAll();

        realm.commitTransaction();
    }

    //find all objects in the Book.class
    public RealmResults<Results> getMusic() {

        return realm.where(Results.class).findAll();
    }

    //query a single item with the given id
    public Results getUser(String id) {

        return realm.where(Results.class).equalTo("trackName", id).findFirst();
    }

    //check if Book.class is empty
    public boolean hasTracks() {

        return !realm.where(Results.class).findAll().isEmpty();
    }

    //query example
    public RealmResults<Results>queryUser(String trackName) {

        return realm.where(Results.class)
                .contains("trackName", trackName)
                .findAll();

    }
}
