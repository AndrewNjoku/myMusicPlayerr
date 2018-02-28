package com.example.andria.musicplayer.Fragments;


import android.os.Bundle;


import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

//import com.example.andria.musicplayer.Adapter.AlbumsAdapter;
import com.example.andria.musicplayer.Model.Results;
import com.example.andria.musicplayer.R;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Andria on 24/02/2018.
 */



public class fragmentClass extends Fragment{


    Realm realm;
    RealmResults <Results> RockResults;
    RealmResults <Results> PopResults;






    private CardView mCardView;
    protected RecyclerView mRecyclerView;
    // protected AlbumsAdapter adapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    private static final int SPAN_COUNT = 2;
    private static final int DATASET_COUNT = 60;
    public ArrayList<Results> resultsList;


    public List<Results> resultsListR;
    public ArrayList<Results> resultsListC;
    public ArrayList<Results> resultsListP;
    int layoutversion = R.layout.recyclerview;
    int recyclerversion;
    View rootView;
    ViewGroup parent;
    String stringFrag ="Rock";


    public fragmentClass() {


    }

    public String getFraf() {

        return stringFrag;
    }


    public void setLayout(int lv) {

        this.layoutversion = lv;
    }


    public static Fragment newInstance() {


        return new fragmentClass();
    }

    // public void setStringFrag

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //initialise realm database

        realm=Realm.getDefaultInstance();

        // Initialize dataset, this data would usually come from a local content provider or
        // remote server.

        //instanciate the main ArrayList

        resultsList = new ArrayList<>();

        //instanciate the arrasys  to hold the three genres of music lists


        resultsListR = new ArrayList<>();
        resultsListC = new ArrayList<>();
        resultsListP = new ArrayList<>();


        /*

        Results albumone = new Results();
        albumone.setArtistName("Micheal Jackson");
        albumone.setCollectionName("Greatest hits");
        albumone.setTrackPrice(500.00);


        Results albumtwo = new Results();
        albumtwo.setArtistName("Dido");
        albumtwo.setCollectionName("Shittest hits");
        albumtwo.setTrackPrice(0.54);

        Results albumthree = new Results();
        albumthree.setArtistName("BOB MARLEY");
        albumthree.setCollectionName("Stoner Session");
        albumthree.setTrackPrice(500.00);


        Results albumfour = new Results();
        albumfour.setArtistName("Travis Scott");
        albumfour.setCollectionName("Club Bangers");
        albumfour.setTrackPrice(0.54);

        Results albumfive = new Results();
        albumone.setArtistName("Micheal Jackson");
        albumone.setCollectionName("Greatest hits");
        albumone.setTrackPrice(500.00);


        Results albumsix = new Results();
        albumtwo.setArtistName("Mavado");
        albumtwo.setCollectionName("Depressing music");
        albumtwo.setTrackPrice(0.54);


        resultsListC.add(albumone);
        resultsListC.add(albumtwo);

        resultsListC.add(albumthree);
        resultsListC.add(albumfour);

        resultsListP.add(albumfive);
        resultsListP.add(albumsix);

*/
        // System.out.println(" this is the elemts in the list of Albums"+resultsList.size() );


        initDataset();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        for (Results r:RockResults){

            resultsListR.add(r);
        }

        System.out.println("i have now added the realmresults for rock to the arrayList to display, the size is:"+resultsListR.size());


        for (Results r:PopResults){

            resultsListP.add(r);
        }
        System.out.println("i have now added the realmresults for pop to the arrayList to display, the size is:"+resultsListP.size());

        //container=R.id.r_view;
        System.out.println(" about to inflate the recycle");

        try {
            rootView = inflater.inflate(layoutversion, container, false);
        } catch (InflateException i) {

            System.out.println("Exception caught in inflator:" + i.getMessage());
            ;
        }

        System.out.println("its been inflated");

        if (layoutversion == R.layout.recyclerview) {
            recyclerversion = R.id.r_view;


        } else if (layoutversion == R.layout.recyclerview2) {

            recyclerversion = R.id.r_view2;
        } else if (layoutversion == R.layout.recyclerview3) {


            recyclerversion = R.id.r_view3;
        }

        mRecyclerView = rootView.findViewById(recyclerversion);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // adapter=new AlbumsAdapter(mDataset);


        //find out which fragment is being displayed

        Fragment awesome;
        try {
            awesome = getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_container);

        } catch (NullPointerException n) {

            System.out.println(n.getMessage());
            // awesome
            //System.out.println("awesome.getTag())


        }


if(stringFrag.equals("Rock")) {

    mRecyclerView.setAdapter(new RecyclerAdapter(resultsListR));
    System.out.println("attaching Rock list adapter now");

}
else if(stringFrag.equals("Classic")){

            mRecyclerView.setAdapter(new RecyclerAdapter(resultsListC));
    System.out.println("attaching classical list adapter now");
}

else if(stringFrag.equals("Pop")) {

    mRecyclerView.setAdapter(new RecyclerAdapter(resultsListP));
    System.out.println("attaching Pop list adapter now");


}

        return rootView;

    }


    private void initDataset( ) {


        //initialise data for all 3 arraylists

        //first Rock
      realm.beginTransaction();

        RealmQuery<Results>query=realm.where(Results.class).contains("primaryGenreName","Rock");
        RealmQuery<Results>query2=realm.where(Results.class).contains("primaryGenreName","Pop");

       RockResults=query.findAll();
       PopResults=query.findAll();


       realm.commitTransaction();










    }

    public void addMusicR(List<Results> r) {

      //  System.out.println("before"+resultsListR.size());

       // r=resultsListR;


        ArrayList<Results>newList2 = new ArrayList<>();



        //System.out.println( "test in add music brah" +newList.get(0).getTrackName());

        for(Results res:r){

            newList2.add(res);

            System.out.println("resoirces being added to arrayList"+res.getCollectionName());


        }

        System.out.println(newList2.size());



     //   System.out.println("after"+r.));



                //System.out.println("Track has been added to rock" + res.getTrackName() + "there are " + r.size() + "tracks in Rock");



    }


    public void addMusicC(List<Results> r) {



           // System.out.println("before"+resultsListC.size());

            //r=resultsListC;

         //   System.out.println("after"+resultsListC.size());




                //System.out.println("Track has been added to Classic" + res.getTrackName() + "there are " + r.size() + "tracks in Classic");




    }



    public void setStringFrag(String stringFrag) {

        this.stringFrag = stringFrag;
    }





    public void updateUi(){



    }




    private class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private CardView mCardView;
        private TextView mTextView;

        public TextView collection, Song, price, aname;
        public ImageView AlbumCover;
        public CardView view;


        public RecyclerViewHolder(View itemView) {

            super(itemView);
        }

        public RecyclerViewHolder(LayoutInflater inflator, ViewGroup container) {

            super(inflator.inflate(R.layout.album_card, container, false));

            collection = itemView.findViewById(R.id.collectionTItle);
            Song = itemView.findViewById(R.id.trackTitle);
            price = itemView.findViewById(R.id.trackPrice);
            AlbumCover = itemView.findViewById(R.id.AlbumCover);
            aname = itemView.findViewById(R.id.artist_name);


            mCardView = itemView.findViewById(R.id.card_view);
            ;
            Song.setText("this is a cardview test bitches");

            /*

            .setText(album.getArtistName());
            holder.Song.setText(album.getTrackName());
            holder.price.setText(album.getTrackName());
            System.out.println(" inflating the damn adapter");collection.setText(album.getArtistName());
            holder.Song.setText(album.getTrackName());
            holder.price.setText(album.getTrackName());
            System.out.println(" inflating the damn adapter");
           */
        }


    }


   public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

          private List<Results> resultsList;



        public RecyclerAdapter(List<Results> resultsListpew) {
            this.resultsList = resultsListpew;

System.out.println(" inside the RecyclerAdapter");




        }


        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new RecyclerViewHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {


            holder.collection.setText(resultsList.get(position).getCollectionName());
            holder.Song.setText(resultsList.get(position).getTrackName());




        }

        @Override
        public int getItemCount() {

            int size=0;

         if(stringFrag.equals("Rock")) {

             size= resultsListR.size();
             System.out.println("bumbavclat size"+resultsListR.size());
         }

         else if(stringFrag.equals("Classic")){

             size= resultsListC.size();

         }
         else if(stringFrag.equals("Pop")){

             size= resultsListP.size();

         }

             return size;


        }

    }
}
