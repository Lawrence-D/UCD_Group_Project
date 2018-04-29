package com.school.optimstudy.scheduler_activity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.school.optimstudy.R;

public class SchedulerConfirmationPage extends AppCompatActivity {

    public static SchedulerConfirmationPage newInstance() {
        return new SchedulerConfirmationPage();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduler_confirmation_page);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        view.findViewById(R.id.schedulerHome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start over i guess lol
                getFragmentManager().beginTransaction()
                        .replace(R.id.frame_layout, Scheduler.newInstance())
                        .commit();
            }
        });
    }
}
