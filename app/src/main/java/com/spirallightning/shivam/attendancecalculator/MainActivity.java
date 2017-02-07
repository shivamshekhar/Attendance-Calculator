package com.spirallightning.shivam.attendancecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void aboutClick(View view)
    {
        Intent intent = new Intent(this,About.class);
        startActivity(intent);
    }

    public void AddSubjectClick(View view)
    {
        Intent intent = new Intent(this,AddSubject.class);
        startActivity(intent);
    }

    public void UpdateAttendanceClick(View view)
    {
        Intent intent = new Intent(this,Update.class);
        startActivity(intent);
    }
}
