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

/**
 * @author kwatanabe
 *
 */
public class TemperatureConverterActivityTest extends
        ActivityInstrumentationTestCase2<TemperatureConverterActivity> {

    /** Creating Fixture */
    private TemperatureConverterActivity mActivity;

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
    }

}
