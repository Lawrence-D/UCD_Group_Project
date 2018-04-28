package com.school.optimstudy.create_study_group;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.school.optimstudy.R;


public class Create_Study_Group_Main extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__study__group__main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            //To continue to the create_study_group_meeting_days
            @Override
            public void onClick(View view) {
                OpenLocation();
            }
        });
    }

    public void OpenLocation()
    {
        //Opens Create_Study_Group_Location
        Intent intent = new Intent(this, Create_Study_Group_Location.class);
        startActivity(intent);
    }
}
