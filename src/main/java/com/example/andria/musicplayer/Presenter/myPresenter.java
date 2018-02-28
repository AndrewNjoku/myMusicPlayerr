package com.example.andria.musicplayer.Presenter;

import com.example.andria.musicplayer.Interactor.RockInteractor;
import com.example.andria.musicplayer.Model.Classic;
import com.example.andria.musicplayer.View.view;

import io.realm.Realm;

/**
 * Created by Andria on 25/02/2018.
 */

public class myPresenter implements view {

    Realm realm;


    // private ClassicInteractor interactor;
    RockInteractor rinter;
    Classic myClassicTest;


    public myPresenter() {

        realm = Realm.getDefaultInstance();

        System.out.println("presenter has started");

        //interactor = new ClassicInteractor();
        rinter = new RockInteractor();
        //interactor.updateRockResultsAutomatically();

    }


    @Override
    public void updateUi() {







/*


        realm.beginTransaction();

        RealmQuery<Results> query=realm.where(Results.class);
        RealmResults<Results> iwantResylts=query.findAllAsync();

        realm.commitTransaction();


        if(iwantResylts.isLoaded())
        {

            for(Results r:iwantResylts){

                System.out.println("these are the realmresults after update ui is called"+r);
            }
        }


        else{
            System.out.println("be patient the query hasnt finished yet");
        }

        interactor.updateClassicResultsAutomatically(realm);


    }

    public List<Results> updateRecycleViewRock()
    {

        realm.beginTransaction();
        RealmQuery<Results> query=realm.where(Results.class);
        RealmResults<Results>theseResults=query.findAll();
        List<Results> newarray=realm.copyFromRealm(theseResults);
        realm.commitTransaction();

        return newarray;

    }
    */

    }
}
