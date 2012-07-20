/**
 * TemperatureConvertTestv.java
 * TemperatureConverterTest
 *
 * Created by 株式会社 Appirits on 2012/07/19
 * Copyright (c) 2012 Appirits. All rights reserved.
 *
 */
package com.example.aatg.tc.test;

import java.util.HashMap;

import com.example.aatg.tc.InvalidTemperatureException;
import com.example.aatg.tc.TemperatureConverter;

import junit.framework.TestCase;

/**
 * @author kwatanabe
 *
 */
public class TemperatureConvertTest extends TestCase {

    /**
     * @param name
     */
    public TemperatureConvertTest(String name) {
        super(name);
    }

    /* (非 Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
    }

    /* (非 Javadoc)
     * @see junit.framework.TestCase#tearDown()
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test method for {@link com.example.aatg.tc.TemperatureConverter#fahrenheitToCelsius(double)} .
     */
    public final void test華氏Fから摂氏Cに変換できる() {
        for (double c: conversionTableDouble.keySet()) {
            final double f = conversionTableDouble.get(c);
            final double ca = TemperatureConverter.fahrenheitToCelsius(f);
            final double delta = Math.abs(ca - c);
            final StringBuilder msg = new StringBuilder();
            msg.append(f).append("F -> ").append(c).append("C but was ").append(ca).append("C (delta ").append(delta).append(")");
            assertTrue(msg.toString(), delta < 0.0001);
        }
    }

    private static final HashMap<Double, Double> conversionTableDouble =
            new HashMap<Double, Double>();
    static {
        // initialize (c, f) pairs
        conversionTableDouble.put(0.0, 32.0);
        conversionTableDouble.put(100.0, 212.0);
        conversionTableDouble.put(-1.0, 30.20);
        conversionTableDouble.put(-100.0, -148.0);
        conversionTableDouble.put(32.0, 89.60);
        conversionTableDouble.put(-40.0, -40.0);
        conversionTableDouble.put(-273.0, -459.40);
    }

    /**
     * Test method for {@link com.example.aatg.tc.TemperatureConverter#celsiusToFahrenehit(double)} .
     */
    public final void test摂氏Cから華氏Fに変換できる() {
        for (double c: conversionTableDouble.keySet()) {
            final double f = conversionTableDouble.get(c);
            final double fa = TemperatureConverter.celsiusToFahrenheit(c);
            final double delta = Math.abs(fa - f);
            final StringBuilder msg = new StringBuilder();
            msg.append(c).append("C -> ").append(f).append("F but was ").append(fa).append("(delta ").append(delta).append(")");
            assertTrue(msg.toString(), delta < 0.0001);
        }
    }

    public final void test絶対零度_華氏で例外が飛ぶ() {
        try {
            TemperatureConverter.fahrenheitToCelsius(TemperatureConverter.ABSOLUTE_ZERO_F - 1);
            fail();
        } catch (InvalidTemperatureException ignore) {
            // この例外が正しくでることを期待
        }
    }

}
