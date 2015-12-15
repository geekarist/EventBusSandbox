package com.github.geekarist.eventbussandbox;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LongitudeFragment extends Fragment {

    private TextView textView;
    private double mLongitude;

    public void onEvent(CoordinatesUpdated message) {
        mLongitude = message.longitude;
        updateTextView();
    }

    private void updateTextView() {
        textView.setText(getString(R.string.longitude_label, mLongitude));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View fragmentView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_longitude, container, false);
        textView = (TextView) fragmentView.findViewById(R.id.text_longitude);
        updateTextView();
        return fragmentView;
    }
}
