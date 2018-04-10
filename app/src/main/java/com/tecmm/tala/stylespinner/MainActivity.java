package com.tecmm.tala.stylespinner;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txt;
    private Spinner mySpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.txt);
        mySpinner = (Spinner) findViewById(R.id.mySpinner);
        String Options[] = {"Bold","Italic","Bold & Italic"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, Options);
        mySpinner.setAdapter(adapter);
        //Event for spinner
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String option = mySpinner.getSelectedItem().toString();
                if (option.equals("Bold"))
                    txt.setTypeface(null, Typeface.BOLD);
                else if(option.equals("Italic"))
                    txt.setTypeface(null, Typeface.ITALIC);
                else if(option.equals("Bold & Italic"))
                    txt.setTypeface(null,Typeface.BOLD_ITALIC);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
