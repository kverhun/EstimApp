package com.example.EstimApp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by Kostiantyn on 27.11.2015.
 */
public class Activity6 extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new Fragment6(), "FRAGMENT_6")
                    .commit();
        }
    }

}