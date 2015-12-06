package com.example.EstimApp;

import android.test.ActivityInstrumentationTestCase2;
import org.junit.Test;

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

    @Test
    public void test1(){
        assertTrue(true);
    }
}
