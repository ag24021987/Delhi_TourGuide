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


public class HotelsFragment extends Fragment {

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_resource, container, false);
        // Inflate the layout for this fragment
        final ArrayList<TourGuide> tourGuides = new ArrayList<TourGuide>();
        tourGuides.add(new TourGuide(getString(R.string.wood_castle),getString(R.string.tagore_garden),R.drawable.the_wood_castle,28.647709, 77.113720));
        tourGuides.add(new TourGuide(getString(R.string.the_leela),getString(R.string.chanakyapuri),R.drawable.the_leela_palace,28.580038, 77.189102));
        tourGuides.add(new TourGuide(getString(R.string.the_oberoi),getString(R.string.zh_marg),R.drawable.the_oberoi_delhi,28.596274, 77.239642));
        tourGuides.add(new TourGuide(getString(R.string.shanti_home),getString(R.string.janakpuri),R.drawable.the_shanti_home,28.623631, 77.068701));
        tourGuides.add(new TourGuide(getString(R.string.the_taj_palace),getString(R.string.diplomatic_enclave),R.drawable.the_taj_palace,28.595434, 77.170887));
        tourGuides.add(new TourGuide(getString(R.string.the_taj_mahal),getString(R.string.mansingh_road),R.drawable.the_taj_mahal_hotel,28.604719, 77.223495));
        tourGuides.add(new TourGuide(getString(R.string.the_imperial),getString(R.string.janpath),R.drawable.the_imperial_hotel,28.625505, 77.218253));


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
