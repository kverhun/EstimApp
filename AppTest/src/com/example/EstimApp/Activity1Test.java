package com.example.EstimApp;

import android.support.v4.app.Fragment;
import com.example.EstimApp.Activity1;
import com.example.EstimApp.Fragment1;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
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

    @Test
    public void test1(){
        assertTrue(true);
    }

    @Test
    public void testShouldFindFragmentByTag(){
        assertNotNull(activity);

        Fragment fragment = activity.getSupportFragmentManager().findFragmentByTag("FRAGMENT_1");
        assertNotNull(fragment);
    }

    public void testShouldGetMainContainer(){
        View fragmentContainer = activity.findViewById(R.id.container);
        assertNotNull(fragmentContainer);
    }

    private Activity1 activity;



}
