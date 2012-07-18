/**
 * TemepratureConverterActivityTests.java
 * TemperatureConverter
 *
 * Created by 株式会社 Appirits on 2012/07/18
 * Copyright (c) 2012 Appirits. All rights reserved.
 *
 */
package com.example.aatg.tc.test;

import com.example.aatg.tc.TemperatureConverterActivity;

import android.test.ActivityInstrumentationTestCase2;

/**
 * @author kwatanabe
 *
 */
public class TemepratureConverterActivityTests extends
        ActivityInstrumentationTestCase2<TemperatureConverterActivity> {

    /**
     * No Argument Constructor
     */
    public TemepratureConverterActivityTests() {
       this("TemperatureConverterActivityTests");
    }

    /**
     * Contructor
     * @param name
     */
    public TemepratureConverterActivityTests(String name) {
        super(TemperatureConverterActivity.class);
        setName(name);
    }

    /* (非 Javadoc)
     * @see android.test.ActivityInstrumentationTestCase2#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
    }

    /* (非 Javadoc)
     * @see android.test.ActivityInstrumentationTestCase2#tearDown()
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

}
