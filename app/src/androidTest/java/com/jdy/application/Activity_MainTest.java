package com.jdy.application;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class Activity_MainTest {

    @Rule
    public ActivityTestRule<Activity_Main> mActivityTestRule = new ActivityTestRule<>(Activity_Main.class);

    @Test
    public void activity_MainTest() {
    }

}
