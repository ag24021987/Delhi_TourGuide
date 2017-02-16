package com.example.agupt23.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class ShoppingFragment extends Fragment {

    public ShoppingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_resource,container,false);

        final ArrayList<TourGuide> tourGuides = new ArrayList<TourGuide>();
        tourGuides.add(new TourGuide(getString(R.string.connaught_place),getString(R.string.central_delhi),R.drawable.connaught_place_shopping,28.632869, 77.219493));
        tourGuides.add(new TourGuide(getString(R.string.chandni_chowk),getString(R.string.old_delhi),R.drawable.chandni_chowk_shopping,28.653307, 77.230281));
        tourGuides.add(new TourGuide(getString(R.string.dilli_haat),getString(R.string.south_delhi),R.drawable.dilli_haat_shopping,28.622198, 77.097106));
        tourGuides.add(new TourGuide(getString(R.string.palika_bazaar),getString(R.string.connaught_place),R.drawable.palika_bazaar_shopping,28.631489, 77.218053));
        tourGuides.add(new TourGuide(getString(R.string.karol_bagh),getString(R.string.old_delhi),R.drawable.karol_bagh_shopping,28.647880, 77.192809));
        tourGuides.add(new TourGuide(getString(R.string.lajpat_nagar),getString(R.string.south_delhi),R.drawable.lajpat_nagar_shopping,28.569101, 77.241868));
        tourGuides.add(new TourGuide(getString(R.string.sarojini_nagar),getString(R.string.south_delhi),R.drawable.sarojini_nagar_shopping,28.577397, 77.196220));

        TourGuideAdapter adapter = new TourGuideAdapter(getActivity(),tourGuides);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TourGuide tourGuide = tourGuides.get(position);
                Uri gmmIntentUri = Uri.parse("google.navigation:q=" + tourGuide.getmLatitude() + "," + tourGuide.getmLongitude());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });



        return rootView;
    }
}
