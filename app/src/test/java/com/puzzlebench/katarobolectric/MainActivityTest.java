package com.puzzlebench.katarobolectric;

import android.content.Intent;

import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowApplication;
import org.robolectric.shadows.ShadowIntent;


import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Java6Assertions.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.robolectric.Shadows.shadowOf;


/**
 * Created by andresdavid on 23/03/17.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainActivityTest {


    private MainActivity activity;
    private TextView textView;
    private Button button;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(MainActivity.class).create().get();
        textView = (TextView)activity.findViewById(R.id.texview);
        button = (Button)activity.findViewById(R.id.button);


    }

    @Test
    public void onCreate() throws Exception {

        assertNotNull(activity);
        assertThat(textView.getText().toString()).isEqualTo("H");



    }
    @Test
    public void openSecondActivity() throws Exception {
        activity.openSecondActivity();
        Intent startedActivity = ShadowApplication.getInstance().peekNextStartedActivity();
        assertEquals(SecondActivity.class.getName(), startedActivity.getComponent().getClassName());

    }



}