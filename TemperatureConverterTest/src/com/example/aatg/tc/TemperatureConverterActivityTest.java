/**
 * TemperatureConverterActivityTest.java
 * TemperatureConverterTest
 *
 * Created by 株式会社 Appirits on 2012/07/18
 * Copyright (c) 2012 Appirits. All rights reserved.
 *
 */
package com.example.aatg.tc;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

/**
 * @author kwatanabe
 *
 */
public class TemperatureConverterActivityTest extends
        ActivityInstrumentationTestCase2<TemperatureConverterActivity> {

    /** Creating Fixture */
    private TemperatureConverterActivity mActivity;
    private EditText mCelsius;
    private EditText mFahrenheit;

    /**
     */
    public TemperatureConverterActivityTest() {
       this("TemperatureConverterActivityTest");
    }

    /**
     * @param name
     */
    public TemperatureConverterActivityTest(String name) {
        super(TemperatureConverterActivity.class);
        setName(name);
    }

    /* (非 Javadoc)
     * @see android.test.ActivityInstrumentationTestCase2#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        mActivity = getActivity();
        mCelsius    = (EditText)mActivity.findViewById(com.example.aatg.tc.R.id.celsius);
        mFahrenheit = (EditText)mActivity.findViewById(com.example.aatg.tc.R.id.fahrenheit);
    }

    /* (非 Javadoc)
     * @see android.test.ActivityInstrumentationTestCase2#tearDown()
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test preconditions
     */
    public final void testPreconditions() {
        assertNotNull(mActivity);
        // assertThat()だと，Matcherクラスが取得できなかった．JUnit 3.0だからいかんのか
        // Matcher<Object> matcher = is(not(nullValue()));
        // assertThat(mActivity, matcher);
    }


    /**
     * Testing the existence of the UI components
     * 日本語のテスト名は利用できる．@Testアノテーションはだめだった
     */
    public final void testInputFieldsを持っている() {
        assertNotNull(mCelsius);
        assertNotNull(mFahrenheit);
    }


    /******************************************************************************
     * Translating requirements to tests
     ******************************************************************************/

    public final void testInputFieldsは空ではじまる() {
        assertEquals("", mCelsius.getText().toString());
        assertEquals("", mFahrenheit.getText().toString());
    }

}
