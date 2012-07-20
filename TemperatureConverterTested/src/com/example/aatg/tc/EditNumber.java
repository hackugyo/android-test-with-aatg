/**
 * EditNumber.java
 * TemperatureConverter
 *
 *
 */
package com.example.aatg.tc;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
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
        init();
    }

    /**
     * @param context
     * @param attrs
     */
    public EditNumber(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * @param context
     * @param attrs
     * @param defStyle
     */
    public EditNumber(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        final InputFilter[] filters = new InputFilter[] {
                DigitsKeyListener.getInstance(true, true)
        };
        setFilters(filters);
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
