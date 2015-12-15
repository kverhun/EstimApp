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

public class Activity3Test extends ActivityInstrumentationTestCase2<Activity3> {

    public Activity3Test() {
        super("com.example.EstimApp", Activity3.class);
    }

    @Override
    public void setUp() throws Exception {
        activity = this.getActivity();
    }

    public void testShouldGetActivity(){
        assertNotNull(activity);
    }

    public void testShouldFindFragmentByTag(){
        Fragment fragment = activity.getSupportFragmentManager().findFragmentByTag("FRAGMENT_3");
        assertNotNull(fragment);
    }

    public void testShouldGetMainContainer(){
        View fragmentContainer = activity.findViewById(R.id.container);
        assertNotNull(fragmentContainer);
    }

    public void testShouldCreateLayoutElements(){
        TextView workitemTitle = (TextView)activity.findViewById(R.id.textViewLayout3WorkItemTitle);
        TextView workItemDescription = (TextView)activity.findViewById(R.id.textViewLayout3WorkItemDesciption);
        ProgressBar progressBar = (ProgressBar)activity.findViewById(R.id.progressBarEstimMaking);

        assertNotNull(workitemTitle);
        assertNotNull(workItemDescription);
        assertNotNull(progressBar);
    }

    private Activity3 activity;



}