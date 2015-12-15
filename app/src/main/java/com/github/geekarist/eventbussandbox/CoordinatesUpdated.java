package com.github.geekarist.eventbussandbox;

public class CoordinatesUpdated {
    final double latitude;
    final double longitude;

    public CoordinatesUpdated(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
