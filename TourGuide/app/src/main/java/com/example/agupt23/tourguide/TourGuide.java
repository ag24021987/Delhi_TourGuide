package com.example.agupt23.tourguide;

/**
 * Created by agupt23 on 2/12/17.
 */

public class TourGuide {

    private String mTitle;

    private String mLocation;

    private int mImageResourceId;

    private double mLatitude;

    private double mLongitude;

    public TourGuide(String title, String location, int imageResourceId, double latitude, double longitude) {
        mTitle = title;
        mLocation = location;
        mImageResourceId = imageResourceId;
        mLatitude = latitude;
        mLongitude = longitude;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmLocation() {
        return mLocation;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public double getmLatitude() {
        return mLatitude;
    }

    public double getmLongitude() {
        return mLongitude;
    }
}
