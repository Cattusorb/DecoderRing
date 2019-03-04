package com.example.decoderring;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.InputMismatchException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buildTable(View view) {

        int padding = (int) (getResources().getDimension(R.dimen.padding)
                / getResources().getDisplayMetrics().density);
        float tableFont = getResources().getDimension(R.dimen.smaller_font);
        // Get Shift value from EditText
        EditText input = findViewById(R.id.shift_input);
        int shift;
        try {
            shift = Integer.parseInt(input.getText().toString());
        } catch (InputMismatchException ime){
            shift = 0;
        }
        // Build table
        TableLayout table = findViewById(R.id.table);
        table.removeAllViews();

        // Build header row
        TableRow rowHeader = new TableRow(this);
        TextView plain = new TextView(this);
        plain.setText(getString(R.string.plain_label));
        plain.setTextSize(TypedValue.COMPLEX_UNIT_PX, tableFont);
        plain.setPadding(0, 0, padding, 0);

        TextView cipher = new TextView(this);
        cipher.setText(getString(R.string.cipher_label));
        cipher.setTextSize(TypedValue.COMPLEX_UNIT_PX, tableFont);

        rowHeader.addView(plain);
        rowHeader.addView(cipher);
        table.addView(rowHeader);

        for (int n = 0; n < 26; n++) {
            char plainLetter = (char) ('A' + n);
            char cipherLetter = (char) ('A' + (n + shift) % 26);

            String plainLetterStr = Character.toString(plainLetter);
            String cipherLetterStr = Character.toString(cipherLetter);

            TableRow row = new TableRow(this);
            TextView plainText = new TextView(this);
            plainText.setText(plainLetterStr);
            plainText.setTextSize(TypedValue.COMPLEX_UNIT_PX, tableFont);
            plainText.setPadding(0, 0, padding, 0);

            TextView cipherText = new TextView(this);
            cipherText.setText(cipherLetterStr);
            cipherText.setTextSize(TypedValue.COMPLEX_UNIT_PX, tableFont);

            row.addView(plainText);
            row.addView(cipherText);
            table.addView(row);
        }

        // Profit!
    }
}
