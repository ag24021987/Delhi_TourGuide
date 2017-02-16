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


public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.list_resource,container,false);

        final ArrayList<TourGuide> tourGuides = new ArrayList<TourGuide>();
        tourGuides.add(new TourGuide(getString(R.string.indian_accent),getString(R.string.friends_colony),R.drawable.indian_accent,28.570532, 77.256540));
        tourGuides.add(new TourGuide(getString(R.string.tamra),getString(R.string.connaught_place),R.drawable.tamra,28.620979, 77.218194));
        tourGuides.add(new TourGuide(getString(R.string.dakshin),getString(R.string.kalkaji),R.drawable.dakshin,28.528377, 77.218289));
        tourGuides.add(new TourGuide(getString(R.string.k3_restaurant),getString(R.string.aerocity),R.drawable.k3mariott,28.553042, 77.121531));
        tourGuides.add(new TourGuide(getString(R.string.dum_pukht),getString(R.string.diplomatic_enclave),R.drawable.dum_pukht,28.596954, 77.173706));
        tourGuides.add(new TourGuide(getString(R.string.bukhara),getString(R.string.diplomatic_enclave),R.drawable.bukhara,28.597183, 77.173709));
        tourGuides.add(new TourGuide(getString(R.string.oriental_octopus),getString(R.string.lodhi_road),R.drawable.oriental_octopus,28.589951, 77.225602));

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
