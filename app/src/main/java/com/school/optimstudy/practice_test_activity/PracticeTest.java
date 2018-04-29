package com.school.optimstudy.practice_test_activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.app.Activity;

import com.school.optimstudy.MainActivity;
import com.school.optimstudy.R;
import com.school.optimstudy.activity_new_test;

public class PracticeTest extends Fragment {
    Button newTestButton;
    Button newOptionButton;
    public static PracticeTest newInstance() {
        return new PracticeTest();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.activity_practice_test, container, false);
        newTestButton = (Button) fragment.findViewById(R.id.NewTestButton);
        newTestButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),activity_new_test.class);
                startActivity(intent);
            }
        });

        return fragment;
    }
}
