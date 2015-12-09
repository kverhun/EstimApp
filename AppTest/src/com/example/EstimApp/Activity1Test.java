package com.example.EstimApp;

import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.EditText;
import com.example.EstimApp.Activity1;
import com.example.EstimApp.Fragment1;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runners.model.FrameworkField;

import com.example.EstimApp.R;

import static com.example.EstimApp.R.id.container;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class com.example.EstimApp.Activity1Test \
 * com.example.EstimApp.tests/android.test.InstrumentationTestRunner
 */
public class Activity1Test extends ActivityInstrumentationTestCase2<Activity1> {

    public Activity1Test() {
        super("com.example.EstimApp", Activity1.class);
    }

    @Override
    public void setUp() throws Exception {
        activity = this.getActivity();
    }

    public void testShouldGetActivity(){
        assertNotNull(activity);
    }

    public void testShouldFindFragmentByTag(){
        Fragment fragment = activity.getSupportFragmentManager().findFragmentByTag("FRAGMENT_1");
        assertNotNull(fragment);
    }

    public void testShouldGetMainContainer(){
        View fragmentContainer = activity.findViewById(R.id.container);
        assertNotNull(fragmentContainer);
    }

    public void testShouldCreateLayoutElements(){
        EditText editTextUserName = (EditText)activity.findViewById(R.id.editTextNickName);
        EditText editTextPassword = (EditText)activity.findViewById(R.id.editTextPassword);

        Button buttonLogin = (Button)activity.findViewById(R.id.buttonLogin);
        Button buttonCancel = (Button)activity.findViewById(R.id.buttonCancel);

        assertNotNull(editTextUserName);
        assertNotNull(editTextPassword);
        assertNotNull(buttonLogin);
        assertNotNull(buttonCancel);
    }

    private Activity1 activity;



}
