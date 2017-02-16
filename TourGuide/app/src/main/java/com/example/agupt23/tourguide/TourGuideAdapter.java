package com.example.agupt23.tourguide;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by agupt23 on 2/12/17.
 */

public class TourGuideAdapter extends ArrayAdapter<TourGuide> {


    public TourGuideAdapter(Activity context, ArrayList<TourGuide> tourGuides) {
        super(context,0,tourGuides);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_element_custom_layout,parent,false);
        }

        final TourGuide currentTourGuide = getItem(position);

        TextView currentTextView = (TextView) listItemView.findViewById(R.id.title);
        currentTextView.setText(currentTourGuide.getmTitle());

        TextView currentTextView2 = (TextView) listItemView.findViewById(R.id.location);
        currentTextView2.setText(currentTourGuide.getmLocation());

        ImageView currentImageView = (ImageView) listItemView.findViewById(R.id.image_place);
        currentImageView.setImageResource(currentTourGuide.getmImageResourceId());

        return listItemView;
    }
}

