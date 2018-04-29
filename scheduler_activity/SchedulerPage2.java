package com.school.optimstudy.scheduler_activity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.school.optimstudy.R;

public class SchedulerPage2 extends AppCompatActivity {

    public static SchedulerPage2 newInstance() {
        return new SchedulerPage2();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduler_page2);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        view.findViewById(R.id.finishConfirmation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.frame_layout, SchedulerConfirmationPage.newInstance())
                        .commit();
            }
        });
    }
}
