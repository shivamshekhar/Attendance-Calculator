package com.spirallightning.shivam.attendancecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Update extends AppCompatActivity {

    EditText edt;
    static final int READ_BLOCK_SIZE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
    }

    public void readText(View view)
    {
        edt = (EditText) findViewById(R.id.editText2);
        //reading text from file
        try {
            FileInputStream fileIn=openFileInput("subs.txt");
            InputStreamReader InputRead= new InputStreamReader(fileIn);

            char[] inputBuffer= new char[READ_BLOCK_SIZE];
            String s="";
            int charRead;

            while ((charRead=InputRead.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s +=readstring;
            }
            InputRead.close();
            edt.setText(s);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
