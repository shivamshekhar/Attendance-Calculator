package com.spirallightning.shivam.attendancecalculator;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.icu.text.IDNA;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Locale;

import static com.spirallightning.shivam.attendancecalculator.R.id.editDate;

public class AddSubject extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText subText;
    EditText codeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);

        subText = (EditText) findViewById(R.id.editSubject);
        codeText = (EditText) findViewById(editDate);

        /*Spinner[] sparray = new Spinner[7];

        for(int i=0;i<7;i++)
        {
            String spinnerID = "s" + (i+1);
            int resID = getResources().getIdentifier(spinnerID, "id", getPackageName());

            Spinner spinner = (Spinner) findViewById(resID);

            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.timeSlot, android.R.layout.simple_spinner_item);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner.setAdapter(adapter);

            spinner.setOnItemSelectedListener(this);

            sparray[i] = spinner;
        }*/
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        //Spinner sp = (Spinner) parent;


    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    public void AddSubjectClick(View view)
    {
        String ErrMsg = "Lol! You got an Error!";

        if (subText.getText().length() == 0 || codeText.getText().length() == 0)
        {
            if (subText.getText().length() == 0)
            {
                ErrMsg = "Please enter the name of the subject!";
            }

            if (codeText.getText().length() == 0)
            {
                ErrMsg = "Please enter the date!";
            }

            new AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage(ErrMsg)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .show();
        }

        else
        {


        }

    }

    int year = 2017;
    int month = 0;
    int day = 1;

    public void calendarPopup(View view)
    {
        showDialog(999);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year,month,day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            EditText edt = (EditText) findViewById(R.id.editDate);
            edt.setText(Integer.toString(arg3) + "/" + Integer.toString(arg2 + 1) + "/" + Integer.toString(arg1));
        }
    };

}
