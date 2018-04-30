package com.school.optimstudy.scheduler_activity;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.school.optimstudy.R;

public class SchedulerConfirmationPage extends Fragment {

    public static SchedulerConfirmationPage newInstance() {
        return new SchedulerConfirmationPage();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_scheduler_confirmation_page, container, false);
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
