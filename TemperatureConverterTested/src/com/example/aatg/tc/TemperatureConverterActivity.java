package com.example.aatg.tc;

import com.example.aatg.tc.TemperatureConverter.Operation;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

public class TemperatureConverterActivity extends Activity {
    EditNumber mCelsius;
    EditNumber mFahrenheit;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temperature_converter_main);
        mCelsius = (EditNumber)findViewById(R.id.celsius);
        mFahrenheit = (EditNumber) findViewById(R.id.fahrenheit);
        mCelsius.addTextChangedListener(new TemperatureChangedWatcher(Operation.C2F));
        mFahrenheit.addTextChangedListener(new TemperatureChangedWatcher(Operation.F2C));

    }

    /**
     * @author kwatanabe
     *
     */
    public class TemperatureChangedWatcher implements TextWatcher {
        private final EditNumber mSource;
        private final EditNumber mDest;
        private final Operation mOp;

        public TemperatureChangedWatcher(TemperatureConverter.Operation op) {
            if ( op == Operation.C2F ) {
                this.mSource = mCelsius;
                this.mDest = mFahrenheit;
            } else {
                this.mSource = mFahrenheit;
                this.mDest = mCelsius;
            }
            this.mOp = op;
        }

        /* (非 Javadoc)
         * @see android.text.TextWatcher#beforeTextChanged(java.lang.CharSequence, int, int, int)
         */
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                int after) {
            // TODO 自動生成されたメソッド・スタブ

        }

        /* (非 Javadoc)
         * @see android.text.TextWatcher#onTextChanged(java.lang.CharSequence, int, int, int)
         */
        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                int count) {
            if (!mDest.hasWindowFocus() || mDest.hasFocus() || s == null) {
                return;
            }
            final String str = s.toString();
            if ("".equals(str)) {
                mDest.setText("");
                return;
            }
            try {
                final double temp = Double.parseDouble(str);
                final double result = (mOp == Operation.C2F) ? TemperatureConverter.celsiusToFahrenheit(temp) : TemperatureConverter.fahrenheitToCelsius(temp);
                final String resultString = String.format("%.2f", result);
                mDest.setNumber(result);
                mDest.setSelection(resultString.length());

            } catch (NumberFormatException ignore) {
                // 数でないものが入力されたときのエラー．何もしたくないので無視
            } catch (Exception e) {
                mSource.setError("ERROR: " + e.getLocalizedMessage());
            }

        }

        /* (非 Javadoc)
         * @see android.text.TextWatcher#afterTextChanged(android.text.Editable)
         */
        @Override
        public void afterTextChanged(Editable s) {
            // TODO 自動生成されたメソッド・スタブ

        }

    }
}