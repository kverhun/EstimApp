package com.example.EstimApp;

import android.support.v4.app.Fragment;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import static org.junit.Assert.*;

/**
 * Created by Kostya on 14.12.2015.
 */
public class Activity2Test extends ActivityInstrumentationTestCase2<Activity2> {

    public Activity2Test() {
        super("com.example.EstimApp", Activity2.class);
    }

    @Override
    public void setUp() throws Exception {
        activity = this.getActivity();
    }

    public void testShouldGetActivity(){
        assertNotNull(activity);
    }

    public void testShouldFindFragmentByTag(){
        Fragment fragment = activity.getSupportFragmentManager().findFragmentByTag("FRAGMENT_2");
        assertNotNull(fragment);
    }

    public void testShouldGetMainContainer(){
        View fragmentContainer = activity.findViewById(R.id.container);
        assertNotNull(fragmentContainer);
    }

    public void testShouldCreateLayoutElements(){
        TextView textViewTitle = (TextView)activity.findViewById(R.id.textViewLayout2Title);
        TextView textViewPreviousEstim = (TextView)activity.findViewById(R.id.textViewLayout2PreviousEstim);
        ProgressBar progressBar = (ProgressBar)activity.findViewById(R.id.progressBarWaitForWorkItem);

        assertNotNull(textViewTitle);
        assertNotNull(textViewPreviousEstim);
        assertNotNull(progressBar);
    }
    
    private Activity2 activity;

}