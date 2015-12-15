package com.github.geekarist.eventbussandbox;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.greenrobot.event.EventBus;

public class LatitudeFragment extends Fragment {

    private TextView textView;
    private final EventBus mEventBus;
    private double mLatitude;

    public LatitudeFragment() {
        mEventBus = EventBus.getDefault();
        mEventBus.register(this);
    }

    public void onEvent(CoordinatesUpdated message) {
        this.mLatitude = message.latitude;
        updateTextView();
    }

    private void updateTextView() {
        textView.setText(getString(R.string.latitude_label, mLatitude));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_latitude, container, false);
        textView = (TextView) view.findViewById(R.id.text_latitude);
        updateTextView();
        return view;
    }
}
