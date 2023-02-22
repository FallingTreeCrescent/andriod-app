package com.example.unionpplication;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ThirdFragment extends Fragment {

    private ThirdViewModel mViewModel;
    private Button third_1;
    private Button third_2;

    public static ThirdFragment newInstance() {
        return new ThirdFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_third, container, false);
        third_1 = v.findViewById(R.id.third_1);
        third_2 = v.findViewById(R.id.third_2);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ThirdViewModel.class);
        // TODO: Use the ViewModel

        third_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),Use_introActivity.class));
            }
        });

        third_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),About_usActivity.class));
           }
        });
    }

}