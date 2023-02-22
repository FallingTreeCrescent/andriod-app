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

public class ForthFragment extends Fragment {

    private ForthViewModel mViewModel;
    public Button bnm;

    public static ForthFragment newInstance() {
        return new ForthFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_forth, container, false);
        bnm = v.findViewById(R.id.bnm);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ForthViewModel.class);
        // TODO: Use the ViewModel

        startActivity(new Intent(getActivity(),Rgb_Activity.class));
   }

}