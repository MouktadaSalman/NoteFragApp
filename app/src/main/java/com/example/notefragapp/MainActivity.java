package com.example.notefragapp;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    MenuFragment menuFragment = new MenuFragment();
    NoteTakingFragment noteTakingFragment = new NoteTakingFragment();
    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            loadMenuFragmentLandscape();
        } else {
            loadMenuFragment();
        }

        MainActivityData mainActivityDataViewModel = new ViewModelProvider(this)
                .get(MainActivityData.class);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

            mainActivityDataViewModel.clickedValue.observe(this, new Observer<Integer>() {
                @Override
                public void onChanged(Integer integer) {
                    if (mainActivityDataViewModel.getClickedValue() == 1) {
                        loadNoteTakingFragment();
                    }
                    if (mainActivityDataViewModel.getClickedValue() == 2){
                        loadMenuFragment();
                    }
                }
            });
        }
        else{
            mainActivityDataViewModel.clickedValue.observe(this, new Observer<Integer>() {
                @Override
                public void onChanged(Integer integer) {
                    if (mainActivityDataViewModel.getClickedValue() == 1) {
                        loadNoteTakingFragmentLandscape();
                    }
                    if (mainActivityDataViewModel.getClickedValue() == 2){
                        loadMenuFragmentLandscape();
                    }
                }
            });

        }
    }

    private void loadMenuFragment(){

        Fragment frag = fm.findFragmentById(R.id.fragment_container);
        if(frag==null){
            fm.beginTransaction().add(R.id.fragment_container,menuFragment).commit();
        }
        else{
            fm.beginTransaction().replace(R.id.fragment_container,menuFragment).commit();
        }
    }

    private void loadNoteTakingFragment(){

        Fragment frag = fm.findFragmentById(R.id.fragment_container);
        if(frag==null){
            fm.beginTransaction().add(R.id.fragment_container, noteTakingFragment).commit();
        }
        else{
            fm.beginTransaction().replace(R.id.fragment_container, noteTakingFragment).commit();
        }
    }

    private void loadMenuFragmentLandscape() {
        Fragment frag = fm.findFragmentById(R.id.menu_container);
        if (frag == null) {
            fm.beginTransaction().add(R.id.menu_container, menuFragment).commit();
        } else {
            fm.beginTransaction().replace(R.id.menu_container, menuFragment).hide(noteTakingFragment).commit();
        }
    }

    private void loadNoteTakingFragmentLandscape() {
        Fragment frag = fm.findFragmentById(R.id.note_container);
        if (frag == null) {
            fm.beginTransaction().add(R.id.note_container, noteTakingFragment).commit();
        } else {
            fm.beginTransaction().replace(R.id.note_container, noteTakingFragment).show(noteTakingFragment).commit();
        }
    }
}