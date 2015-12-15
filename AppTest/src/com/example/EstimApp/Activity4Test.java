package com.example.EstimApp;

import android.support.v4.app.Fragment;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.EstimApp.Server.Server;

import static org.junit.Assert.*;

/**
 * Created by Kostya on 14.12.2015.
 */

public class Activity4Test extends ActivityInstrumentationTestCase2<Activity4> {

    public Activity4Test() {
        super("com.example.EstimApp", Activity4.class);
    }

    @Override
    public void setUp() throws Exception {
        Server.Instance().getNextWorkItem();
        Server.Instance().makeEstimation(4);
        activity = this.getActivity();
    }

    public void testShouldGetActivity(){
        assertNotNull(activity);
    }

    public void testShouldFindFragmentByTag(){
        Fragment fragment = activity.getSupportFragmentManager().findFragmentByTag("FRAGMENT_4");
        assertNotNull(fragment);
    }

    public void testShouldGetMainContainer(){
        View fragmentContainer = activity.findViewById(R.id.container);
        assertNotNull(fragmentContainer);
    }

    public void testShouldCreateLayoutElements(){
        TextView textViewTitle = (TextView)activity.findViewById(R.id.textViewLayout4WorkItemTitle);
        TextView textViewDescription = (TextView)activity.findViewById(R.id.textViewLayout4WorkItemDesciption);
        TextView textViewWaitingText = (TextView)activity.findViewById(R.id.textViewLayout4WaitingText);
        ProgressBar progressBar = (ProgressBar)activity.findViewById(R.id.progressBarWaitEndSession);

        assertNotNull(textViewTitle);
        assertNotNull(textViewDescription);
        assertNotNull(textViewWaitingText);
        assertNotNull(progressBar);
    }

    private Activity4 activity;

}