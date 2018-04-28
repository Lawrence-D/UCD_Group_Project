package com.school.optimstudy.create_study_group;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.school.optimstudy.R;

public class Create_Study_Group_Meeting_Days extends Fragment {
    public static Create_Study_Group_Meeting_Days newInstance() {
        return new Create_Study_Group_Meeting_Days();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_create__study__group__meeting__days, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        view.findViewById(R.id.days_continue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.frame_layout, Create_Study_Group_Congratulations.newInstance())
                        .commit();
            }
        });
    }
}
