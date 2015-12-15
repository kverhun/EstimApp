package com.example.EstimApp;

import android.support.v4.app.Fragment;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.EstimApp.PersonalDataStorage.PersonalDataStorage;
import com.example.EstimApp.PersonalDataStorage.UserItemEstim;
import com.example.EstimApp.Server.Server;

import java.util.ArrayList;

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

    public void testShouldLastStoredItemBeTheLastOneInTheReturnedHistory(){
        PersonalDataStorage storageInstance = PersonalDataStorage.getInstance(getActivity());
        final String LOGIN = "testAdmin";
        final String WORK_ITEM_TITLE = "testTitle";
        final int ESTIM = 6;
        storageInstance.StoreUserItemEstim(new UserItemEstim(LOGIN, WORK_ITEM_TITLE, ESTIM));
        ArrayList<UserItemEstim> history = storageInstance.GetStoredUserItemEstims();
        final UserItemEstim LAST_HISTORY_ITEM = history.get(history.size() - 1);

        assertEquals(LOGIN, LAST_HISTORY_ITEM.GetLogin());
        assertEquals(WORK_ITEM_TITLE, LAST_HISTORY_ITEM.GetItemName());
        assertEquals(ESTIM, LAST_HISTORY_ITEM.GetEstim());
    }
    private Activity4 activity;

}