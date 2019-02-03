package com.example.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText input;
    TextView txtResult;
    Spinner currencyFrom;
    Spinner currencyTo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = this.findViewById(R.id.numberInput);
        currencyFrom = this.findViewById(R.id.currencyFrom);
        currencyTo = this.findViewById(R.id.currencyTo);
        txtResult = this.findViewById(R.id.txtResult);
        Button btnConvert = this.findViewById(R.id.btnConvert);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.currencies));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currencyFrom.setAdapter(myAdapter);
        currencyTo.setAdapter(myAdapter);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCurrency();
            }
        });


    }

    private void convertCurrency() {

        String charInput = input.getText().toString();
        if(charInput.trim().length() > 0)
        {
            int parsedInput = Integer.parseInt(input.getText().toString().trim());
            double sum = 0;

            String fromCurrency = currencyFrom.getSelectedItem().toString();
            String toCurrency = currencyTo.getSelectedItem().toString();

            if(fromCurrency.equals("DKK") && toCurrency.equals("DKK")) {
                sum = parsedInput;
            }
            if (fromCurrency.equals("DKK") && toCurrency.equals("USD")) {
                sum = parsedInput * 0.15 ;
            }
            if (fromCurrency.equals("DKK") && toCurrency.equals("EURO")) {
                sum = parsedInput * 0.13 ;
            }

            if (fromCurrency.equals("USD") && toCurrency.equals("USD")) {
                sum = parsedInput;
            }
            if (fromCurrency.equals("USD") && toCurrency.equals("DKK")) {
                sum = parsedInput * 6.52;
            }
            if (fromCurrency.equals("USD") && toCurrency.equals("EURO")) {
                sum = parsedInput * 0.87;
            }

            if (fromCurrency.equals("EURO") && toCurrency.equals("EURO")) {
                sum = parsedInput;
            }
            if (fromCurrency.equals("EURO") && toCurrency.equals("DKK")) {
                sum = parsedInput * 7.47;
            }
            if (fromCurrency.equals("EURO") && toCurrency.equals("USD")) {
                sum = parsedInput * 1.15;
            }

            String result = Double.toString(sum);
            txtResult.setText(result);
        }

    }
}
