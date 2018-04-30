package com.school.optimstudy.scheduler_activity;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.school.optimstudy.R;

public class SchedulerPage2 extends Fragment {

    public static SchedulerPage2 newInstance() {
        return new SchedulerPage2();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_scheduler_page2, container, false);
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
