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
import static android.test.ViewAsserts.*;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.FrameLayout.LayoutParams;

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
    private TextView mCelsiusLabel;
    private TextView mFahrenheitLabel;

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
        mCelsiusLabel = (TextView)mActivity.findViewById(com.example.aatg.tc.R.id.celsius_label);
        mFahrenheitLabel = (TextView)mActivity.findViewById(com.example.aatg.tc.R.id.fahrenheit_label);
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

    /**
     * Empty Fields
     */
    public final void testInputFieldsは空ではじまる() {
        assertEquals("", mCelsius.getText().toString());
        assertEquals("", mFahrenheit.getText().toString());
    }

    /**
     * View Properties
     */
    public final void testInputFieldsがスクリーン上にある() {
        final Window window = mActivity.getWindow();
        final View origin = window.getDecorView(); // top-level window decor viewをとってくる．
        assertOnScreen(origin, mCelsius); // assertOnScreenは，static importしたViewAssertより．
        assertOnScreen(origin, mFahrenheit); // assertOnScreenは，visibilityがgoneでもパスしてしまう……
    }

    public final void test表示している位置がそろっている() {
        // | mClesiusLable
        // | mCelsius         |
        // | mFahrenheitLabel
        // | mFahrenheit      |
        assertLeftAligned(mCelsiusLabel, mCelsius);
        assertLeftAligned(mFahrenheitLabel, mFahrenheit);
        assertLeftAligned(mCelsius, mFahrenheit);

        assertRightAligned(mCelsius, mFahrenheit);
    }

    public final void testCelsiusInputFieldの幅が画面幅いっぱい() {
        final int expected = LayoutParams.MATCH_PARENT;
        final ViewGroup.LayoutParams lp = mCelsius.getLayoutParams();
        assertEquals("mCelsius layout widht is not MATCH_PARENT", expected, lp.width);
    }

    public final void testFahrenheitInputFieldの幅が画面幅いっぱい() {
        final int expected = LayoutParams.MATCH_PARENT;
        final ViewGroup.LayoutParams lp = mFahrenheit.getLayoutParams();
        assertEquals("mFahrenheit layout widht is not MATCH_PARENT", expected, lp.width);
    }

    public final void testFontSizes() {
        final float expected =
                getActivity().getResources().getDimensionPixelSize(com.example.aatg.tc.test.R.dimen.text_size_24_sp); // in pixels.
        assertEquals(expected, mCelsiusLabel.getTextSize());
        assertEquals(expected, mFahrenheitLabel.getTextSize());
    }

    public final void testMarginsが正しくなっている() {
        LinearLayout.LayoutParams lp;
        final int expected =
                getActivity().getResources().getDimensionPixelSize(com.example.aatg.tc.test.R.dimen.margin_6_dp); // in pixels.
        lp = (LinearLayout.LayoutParams) mCelsius.getLayoutParams();
        assertEquals(expected, lp.leftMargin);
        assertEquals(expected, lp.rightMargin);
        lp = (LinearLayout.LayoutParams) mFahrenheit.getLayoutParams();
        assertEquals(expected, lp.leftMargin);
        assertEquals(expected, lp.rightMargin);
    }

}
