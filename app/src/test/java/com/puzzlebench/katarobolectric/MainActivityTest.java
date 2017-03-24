package com.puzzlebench.katarobolectric;

import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Java6Assertions.*;
import static org.junit.Assert.assertNotNull;


/**
 * Created by andresdavid on 23/03/17.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainActivityTest {
    private MainActivity activity;
    private TextView textView;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(MainActivity.class).create().get();
        textView = (TextView)activity.findViewById(R.id.texview);

    }

    @Test
    public void onCreate() throws Exception {

        assertNotNull(activity);
        assertThat(textView.getText().toString()).isEqualTo("Hola");

    }

}