/**
 * TemperatureConverter.java
 * TemperatureConverter
 *
 * Created by 株式会社 Appirits on 2012/07/19
 * Copyright (c) 2012 Appirits. All rights reserved.
 *
 */
package com.example.aatg.tc;

/**
 * @author kwatanabe
 *
 */
public class TemperatureConverter {

    public static final double ABSOLUTE_ZERO_C = -273.15d;
    public static final double ABSOLUTE_ZERO_F = -459.67d;

    private static final String ERROR_MESSAGE_BELOW_ZERO_FMT =
            "Invalid temperature: %.2f%c below absolute zero";


    public static double fahrenheitToCelsius(double fahrenheit) {
        if (fahrenheit < ABSOLUTE_ZERO_F) {
            throw new InvalidTemperatureException(String.format(ERROR_MESSAGE_BELOW_ZERO_FMT, fahrenheit, 'F'));
        }
        return ((fahrenheit - 32) / 1.8d);
    }

}
