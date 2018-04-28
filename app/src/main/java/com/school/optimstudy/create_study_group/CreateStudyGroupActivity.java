package com.school.optimstudy.create_study_group;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.school.optimstudy.R;

public class CreateStudyGroupActivity extends Fragment {
    public static CreateStudyGroupActivity newInstance() {
        return new CreateStudyGroupActivity();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_create_study_group, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button cont = view.findViewById(R.id.button);

        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.frame_layout, Create_Study_Group_Location.newInstance())
                        .commit();
            }
        });
    }
}
