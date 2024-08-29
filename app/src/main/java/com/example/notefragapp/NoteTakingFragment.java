package com.example.notefragapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class NoteTakingFragment extends Fragment {

    private MainActivityData mainActivityDataViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_note_taking, container, false);
        mainActivityDataViewModel = new ViewModelProvider(getActivity()).
                get(MainActivityData.class);

        EditText titleText = view.findViewById(R.id.noteTitle);
        EditText noteBodyText = view.findViewById(R.id.noteBody);
        Button saveButton = view.findViewById(R.id.saveButton);

        titleText.setText(mainActivityDataViewModel.getTitleString());
        noteBodyText.setText(mainActivityDataViewModel.getNoteString());

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleText.getText().toString();
                String noteBody = noteBodyText.getText().toString();

                mainActivityDataViewModel.setTitleString(title);
                mainActivityDataViewModel.setNoteString(noteBody);
                mainActivityDataViewModel.setClickedValue(2);

                if (mainActivityDataViewModel.getState() == 0){
                    mainActivityDataViewModel.setState(1);
                }
            }
        });

        return view;
    }
}