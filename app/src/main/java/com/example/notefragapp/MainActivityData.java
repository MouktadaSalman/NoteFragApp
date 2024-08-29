package com.example.notefragapp;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityData extends ViewModel {
    public MutableLiveData<Integer> clickedValue;
    public MutableLiveData<String> noteString;
    public MutableLiveData<String> titleString;
    public MutableLiveData<Integer> state; // is there an existing note or not. if no it's 0, if yes then
                                          // it's set to 1. when it's 1 it changes the names of the buttons

    public MainActivityData(){
        clickedValue = new MediatorLiveData<Integer>();
        noteString = new MediatorLiveData<>();
        titleString = new MediatorLiveData<>();
        state = new MediatorLiveData<>();
        clickedValue.setValue(0);
        titleString.setValue("");
        noteString.setValue("");
        state.setValue(0);
    }

    public int getClickedValue(){
        return clickedValue.getValue();
    }
    public void setClickedValue(int value){ clickedValue.setValue(value); }

    public String getTitleString(){ return titleString.getValue(); }
    public void setTitleString(String inString) { titleString.setValue(inString); }

    public String getNoteString() { return noteString.getValue(); }
    public void setNoteString(String inString){
        noteString.setValue(inString);
    }

    public int getState(){
        return state.getValue();
    }
    public void setState(int value){ state.setValue(value); }
}
