package com.example.decoderring;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        // Build header row
        TableRow rowHeader = new TableRow(this);
        TextView plain = new TextView(this);
        plain.setText(R.string.plain_label);
        plain.setTextSize(getResources().getDimension(R.dimen.smaller_font));
        plain.setPadding(0, 0, (int) getResources().getDimension(R.dimen.padding), 0);

        TextView cipher = new TextView(this);
        plain.setText(R.string.cipher_label);
        plain.setTextSize(getResources().getDimension(R.dimen.smaller_font));

        rowHeader.addView(plain);
        rowHeader.addView(cipher);
        table.addView(rowHeader);
        // Profit!
    }
}
