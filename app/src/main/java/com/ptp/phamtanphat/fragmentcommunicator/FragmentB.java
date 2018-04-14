package com.ptp.phamtanphat.fragmentcommunicator;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by KhoaPhamPC on 14/4/2018.
 */

public class FragmentB extends Fragment {
    TextView txtB;
    RatingBar ratingBar;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_b,container,false);
        txtB = view.findViewById(R.id.textviewtitleB);
        ratingBar = view.findViewById(R.id.ratingbarB);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                FragmentA fragmentA = (FragmentA) getActivity().getFragmentManager().findFragmentById(R.id.fragmenta);
                fragmentA.GetRatingbar(rating);
            }
        });
        return view;
    }
}
