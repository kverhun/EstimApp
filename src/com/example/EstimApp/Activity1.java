package com.example.EstimApp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class Activity1 extends FragmentActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new Fragment1(), "FRAGMENT_1")
                    .commit();
        }
    }


}
