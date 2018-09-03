package com.whiteturtlestudio.oneplus5twalls;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


/**
 * A simple {@link Fragment} subclass.
 */
public class GridFragment extends Fragment {
    AdView mAdview;

    public GridFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_grid, container, false);
        //Display Banner Ad in HomeScreen
        MobileAds.initialize(this.getActivity(),"\n" +
                "ca-app-pub-3940256099942544/6300978111");
        mAdview = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        GridView gridView = (GridView) rootView.findViewById(R.id.grdview1);
        gridView.setAdapter(new ImageAdapterT(getActivity()));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent i = new Intent(getActivity().getApplicationContext(), SetWallpaper.class);
                i.putExtra("id", position);
                startActivity(i);

            }
        });
        return rootView;
    }

}
