package com.example.EstimApp;

import android.support.v4.app.Fragment;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

import static org.junit.Assert.*;

/**
 * Created by Kostya on 14.12.2015.
 */

public class Activity6Test extends ActivityInstrumentationTestCase2<Activity6> {

    public Activity6Test() {
        super("com.example.EstimApp", Activity6.class);
    }

    @Override
    public void setUp() throws Exception {
        activity = this.getActivity();
    }

    public void testShouldGetActivity(){
        assertNotNull(activity);
    }

    public void testShouldFindFragmentByTag(){
        Fragment fragment = activity.getSupportFragmentManager().findFragmentByTag("FRAGMENT_6");
        assertNotNull(fragment);
    }

    public void testShouldGetMainContainer(){
        View fragmentContainer = activity.findViewById(R.id.container);
        assertNotNull(fragmentContainer);
    }

    public void testShouldCreateLayoutElements(){

    }

    private Activity6 activity;

}