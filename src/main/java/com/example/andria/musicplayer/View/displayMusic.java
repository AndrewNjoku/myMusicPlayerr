package com.example.andria.musicplayer.View;



//import android.app.Fragment;

//import android.app.FragmentManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;


//import com.example.andria.musicplayer.Adapter.AlbumsAdapter;
import com.example.andria.musicplayer.Commmunication.APIRock;
import com.example.andria.musicplayer.Controller.RealmController;
import com.example.andria.musicplayer.Fragments.fragmentClass;
import com.example.andria.musicplayer.Fragments.singleFragment;
import com.example.andria.musicplayer.Interactor.MusicInteractor;
import com.example.andria.musicplayer.Model.Classic;
import com.example.andria.musicplayer.Model.Results;
import com.example.andria.musicplayer.Presenter.myPresenter;
import com.example.andria.musicplayer.R;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class displayMusic extends singleFragment implements MusicInteractor {

  //  Realm realm;
    RealmResults<Results> results;
    OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS).build();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://itunes.apple.com/").client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    fragmentClass Rock;
    fragmentClass Classic;
    fragmentClass Pop;
    fragmentClass defult;

    myPresenter presenter;

    public boolean tabReselected_rock;
    public boolean tabReselected_pop;
    public boolean tabReselected_vlasic;


    private FrameLayout mContainer;
    private TabLayout mTabLayout;
    private RecyclerView recyclerView;
    // private AlbumsAdapter adapter;
    private fragmentClass fragment_1;
    private List<Results> classicList;
    private List<Results> popList;
    private List<Results> RockList;
    RealmResults<Results> r;

    @Override
    protected Fragment createNewFragment() {
        return new fragmentClass().newInstance();
    }


    RealmChangeListener realmChangeListener = new RealmChangeListener() {

        @Override
        public void onChange(Object o) {


        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Rock = new fragmentClass();

        //

        //here initialise your initial data set

        updateRockResultsAutomatically();
        //updatePopResultsAutomatically();
        //updateClassicResultsAutomatically();



        super.onCreate(savedInstanceState);


        setContentView(R.layout.layoutses);







      //  defult= new fragmentClass();
      //  defult.getSupportFragmentManager().beginTransaction()
           //     .replace(R.id.fragment_container, defult)
             //   .commit();



// or ft.add(R.id.your_placeholder, new FooFragment());
// Comp


        //mContainer=findViewById(R.id.FRAME_LAYOUT);
        mTabLayout = findViewById(R.id.Tab_Layout);

        // Click listener for tab layout


        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {


            @Override
            public void onTabSelected(TabLayout.Tab tab) {


                switch (tab.getPosition()) {
                    case 0:  //replaceFragment(Rock);
                        System.out.println(" You have selected Rock");


                        if (tabReselected_rock != true) {

                            Rock.setStringFrag("Rock");
                            updateRockResultsAutomatically();
                        }





                        Rock.setStringFrag("Rock");
                        Rock.getFraf();

                        Rock.setLayout(R.layout.recyclerview);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, Rock, "rock_fragment")
                                .commit();

                        break;


                    case 1: //replaceFragment(Classic);
                        System.out.println(" You have selected classic");


                        if (tabReselected_vlasic != true) {
                            Classic = new fragmentClass();
                            Classic.setStringFrag("Classic");

                        }

                        Classic.setStringFrag("Classic");

                        Classic.getFraf();
                        Classic.setLayout(R.layout.recyclerview2);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, Classic, "classic_fragment")
                                .commit();

                        break;

                    case 2: //replaceFragment(Pop);
                        System.out.println(" You have selected pop");

                        if (tabReselected_pop != true) {
                            Pop = new fragmentClass();
                            Pop.setStringFrag("Pop");
                        }
                        Pop.setStringFrag("Pop");
                        Pop.getFraf();
                        Pop.setLayout(R.layout.recyclerview3);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, Pop, "pop_fragment")
                                .commit();

                        break;


                }
                int position = tab.getPosition();

                System.out.println(" the position id is as follows" + position);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

                switch (tab.getPosition())

                {

                    case 0:
                        tabReselected_rock = true;

                        break;

                    case 1:
                        tabReselected_vlasic = true;

                        break;

                    case 2:
                        tabReselected_pop = true;


                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
        });

/*
        recyclerView = findViewById(R.id.r_view);

        this.realm = RealmController.with(this).getRealm();
        realm.addChangeListener(realmChangeListener);
        results = realm.where(Results.class).findAllAsync();
        results.addChangeListener(realmChangeListener);

        for (Results r : results) {

            System.out.println("track name:" + r.getTrackName());
        }
        */


       presenter = new myPresenter();
        presenter.updateUi();


    }


    public final void copyToRealm(final Results results) {

        realm.executeTransaction(new Realm.Transaction() {


            @Override
            public void execute(Realm realm) {


                Results realmUser = realm.copyFromRealm(results);
            }
        });

        RealmQuery<Results> query = realm.where(Results.class);
        RealmResults<Results> test = query.findAllAsync();


        for (Results results1 : test) {

            System.out.println("Testing Data has been copied to the realm database:" + results1.getTrackName());

        }
    }

    @Override
    public void receiveJson(List<Results> myData) {


    }


    Realm realm;


    public void updateRockResultsAutomatically() {

        // final ArrayList<Classic>mylist = new ArrayList<>();

        //final Classic classicMan = new Classic();


        // realm = Realm.getDefaultInstance();

        APIRock apiRock = retrofit.create(APIRock.class);

        Call<Classic> myRockList = apiRock.getResultsplz();//("rock");
        myRockList.enqueue(new Callback<Classic>() {
            @Override
            public void onResponse(Call<Classic> call, Response<Classic> response) {
                System.out.println("gotten a callback yay");
                System.out.println("this is the important pRT");
                if (!response.isSuccessful()) {
                    System.out.println(response.message());
                }

                Classic c = response.body();

                List<Results> ty;


                ty = c.geResults();

                for (Results r : ty) {

                    System.out.println("fingers crossed we have some track names" + r.getTrackName());
                }

                if (Rock != null) {
                    Rock.addMusicR(ty);
                }



                    System.out.println("this is the important pRT" + c.geResults().get(1).getTrackName());
//                        Rock.addMusicR(r);
                    // presenter.updateUi();
                }
                // System.out.println("inside the important bit");


                //r = c.getResults();

                    /*
                    realm.beginTransaction();

                    for (Results y : r) {
                        realm.copyToRealm(y);
                        realm.commitTransaction();
                        System.out.println("IM COPYING TO REALM BITCHES");

                    }

                    */


            @Override
            public void onFailure(Call<Classic> call, Throwable t) {


            }
        });
    }

    public void updatePopResultsAutomatically() {

        // final ArrayList<Classic>mylist = new ArrayList<>();

        //final Classic classicMan = new Classic();


        // realm = Realm.getDefaultInstance();

        APIRock apiRock = retrofit.create(APIRock.class);

        Call<Classic> myRockList = apiRock.getResultsplz();//("rock");
        myRockList.enqueue(new Callback<Classic>() {
            @Override
            public void onResponse(Call<Classic> call, Response<Classic> response) {
                System.out.println("gotten a callback yay");
                System.out.println("this is the important pRT");
                if (!response.isSuccessful()) {
                    System.out.println(response.message());
                }


                Classic c = response.body();

               List<Results> ty;


                ty = c.geResults();

                for (Results r : ty) {

                    System.out.println("fingers crossed we have some track names" + r.getTrackName());

                    Classic.addMusicC(ty);


                    System.out.println("this is the important pRT" + c.geResults().get(1).getTrackName());

//                        Rock.addMusicR(r);
                    // presenter.updateUi();
                }
                // System.out.println("inside the important bit");


                //r = c.getResults();

                    /*
                    realm.beginTransaction();

                    for (Results y : r) {
                        realm.copyToRealm(y);
                        realm.commitTransaction();
                        System.out.println("IM COPYING TO REALM BITCHES");

                    }

                    */

            }

            @Override
            public void onFailure(Call<Classic> call, Throwable t) {


            }
        });
    }
}

