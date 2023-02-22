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

public class FirstFragment extends Fragment {
    private Button first_2;
    private Button first_1;
    private Button first_3;


    private FirstViewModel mViewModel;

    public static FirstFragment newInstance() {
        return new FirstFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        first_2 = view.findViewById(R.id.first_2);
        first_1 = view.findViewById(R.id.firsr_1);
        first_3 = view.findViewById(R.id.first_3);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FirstViewModel.class);
        // TODO: Use the ViewModel

        first_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),loginActivity.class));
            }
        });

        first_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),Create_model_Activity.class));
            }
        });

        first_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),Check_Activity.class));
            }
        });
    }

}