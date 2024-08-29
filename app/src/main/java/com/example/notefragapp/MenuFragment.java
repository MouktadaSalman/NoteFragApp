package com.example.notefragapp;

import android.os.Bundle;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuFragment extends Fragment {

    private MainActivityData mainActivityDataViewModel;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        mainActivityDataViewModel = new ViewModelProvider(getActivity()).
                get(MainActivityData.class);

        Button addNewNoteButton = view.findViewById(R.id.addNoteButton);

        addNewNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityDataViewModel.setClickedValue(1);
            }
        });

        mainActivityDataViewModel.state.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if (mainActivityDataViewModel.getState() == 1){
                    addNewNoteButton.setText("Edit Note");
                }
            }
        });

        return view;
    }
}