package com.example.moderngpa_calculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AboutAppFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v= inflater.inflate(R.layout.fragment_aboutapp,container,false);

        TextView content=v.findViewById (R.id.content);
        TextView contentTitle=v.findViewById (R.id.contentTitle);

       String ContentTitle="About Modern GPA-calculator";
        contentTitle.setText (ContentTitle);

        String Content="this app  was created to help students keep track of their academic scores " +
                "and generate a cumulative grade point per semester, easy to use, user-friendly and much more";
        content.setText (Content);

       return  v;

    }
}
