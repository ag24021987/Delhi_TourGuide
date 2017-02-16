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

public class TouristAttractionsFragment extends Fragment {

    public TouristAttractionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_resource, container, false);
        // Inflate the layout for this fragment
        final ArrayList<TourGuide> tourGuides = new ArrayList<TourGuide>();
        tourGuides.add(new TourGuide(getString(R.string.red_fort),getString(R.string.chandni_chowk),R.drawable.red_fort,28.657458, 77.237124));
        tourGuides.add(new TourGuide(getString(R.string.india_gate), getString(R.string.rajpath),R.drawable.india_gate,28.612893, 77.229478));
        tourGuides.add(new TourGuide(getString(R.string.qutab_minar), getString(R.string.mehrauli),R.drawable.qutub_minar,28.524421, 77.185470));
        tourGuides.add(new TourGuide(getString(R.string.lotus_temple),getString(R.string.kalkaji),R.drawable.lotus_temple,28.553520, 77.258826));
        tourGuides.add(new TourGuide(getString(R.string.akshardham),getString(R.string.pandav_nagar),R.drawable.akshardham,28.612711, 77.277262));
        tourGuides.add(new TourGuide(getString(R.string.jantar_mantar),getString(R.string.connaught_place),R.drawable.jantar_mantar,28.626774, 77.215882));
        tourGuides.add(new TourGuide(getString(R.string.humayun_tomb),getString(R.string.mathura_road),R.drawable.humayun_tomb,28.592965, 77.251022));

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
