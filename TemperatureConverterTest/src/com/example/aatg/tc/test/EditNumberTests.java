/**
 * EditNumberTests.java
 * TemperatureConverterTest
 *
 * Created by 株式会社 Appirits on 2012/07/19
 * Copyright (c) 2012 Appirits. All rights reserved.
 *
 */
package com.example.aatg.tc.test;

import com.example.aatg.tc.EditNumber;

import android.test.AndroidTestCase;

/**
 * @author kwatanabe
 *
 */
public class EditNumberTests extends AndroidTestCase {

    public EditNumber mEditNumber;

    /**
     * @param name
     */
    public EditNumberTests() {
        this("EditNumberTests");
    }

    /**
     * @param name
     */
    public EditNumberTests(String name) {
        setName(name);
    }

    /* (非 Javadoc)
     * @see android.test.AndroidTestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        mEditNumber = new EditNumber(mContext);
        mEditNumber.setFocusable(true);
    }

    /* (非 Javadoc)
     * @see android.test.AndroidTestCase#tearDown()
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * {@link com.example.aatg.tc.EditNumber#clear()} のためのテスト・メソッド。
     */
    public final void testClear() {
        final String value = "123.45";
        mEditNumber.setText(value);
        mEditNumber.clear();
        String expectedString = "";
        String actualString = mEditNumber.getText().toString();
        assertEquals(expectedString, actualString);
    }

    /**
     * {@link com.example.aatg.tc.EditNumber#setNumber(double)} のためのテスト・メソッド。
     */
    public final void testSetNumber() {
        mEditNumber.setNumber(123.45);
        final String expected = "123.45";
        final String actual = mEditNumber.getText().toString();
        assertEquals(expected, actual);
    }

    /**
     * {@link com.example.aatg.tc.EditNumber#getNumber()} のためのテスト・メソッド。
     */
    public final void testGetNumber() {
        mEditNumber.setNumber(123.45);
        final double expected = 123.45;
        final double actual = mEditNumber.getNumber();
        assertEquals(expected, actual);
    }

}
