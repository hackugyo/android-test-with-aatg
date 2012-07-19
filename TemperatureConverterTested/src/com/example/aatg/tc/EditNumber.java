/**
 * EditNumber.java
 * TemperatureConverter
 *
 * Created by 株式会社 Appirits on 2012/07/19
 * Copyright (c) 2012 Appirits. All rights reserved.
 *
 */
package com.example.aatg.tc;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * @author kwatanabe
 *
 */
public class EditNumber extends EditText {

    private static final String DEFAULT_FORMAT = "%.2f";

    /**
     * @param context
     */
    public EditNumber(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public EditNumber(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyle
     */
    public EditNumber(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void clear() {
       setText("");
    }

    public void setNumber(double number) {
        super.setText(String.format(DEFAULT_FORMAT, number));
    }

    public double getNumber() {
        return Double.valueOf(getText().toString());
    }

}
