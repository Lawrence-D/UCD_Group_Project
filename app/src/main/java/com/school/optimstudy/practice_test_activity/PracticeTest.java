package com.school.optimstudy.practice_test_activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.school.optimstudy.R;

public class PracticeTest extends Fragment {
    public static PracticeTest newInstance() {
        return new PracticeTest();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_new_test, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        Button newOptionButton = view.findViewById(R.id.newOption);
        Button newQuestionButton = view.findViewById(R.id.newQuestionButton);

        final LinearLayout layout = view.findViewById(R.id.newTestLayoutVertical);

        newQuestionButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                EditText newEditText = new EditText(getContext());
                Button newOptionButton = new Button(getContext());
                RadioGroup radioGroup = new RadioGroup(getContext());
                newOptionButton.setText("New Option");

                Button newQuestion = new Button(getContext());
                newQuestion.setOnClickListener(this);
                newQuestion.setText("New Question");

                LinearLayout horizontalLayout = new LinearLayout(getContext());
                horizontalLayout.setOrientation(LinearLayout.HORIZONTAL);
                horizontalLayout.addView(newOptionButton);
                horizontalLayout.addView(newQuestion);
                layout.addView(radioGroup,3);
                layout.addView(horizontalLayout, 3);
                layout.addView(newEditText, 3);
                newOptionButton.setOnClickListener(new OptionHandler(radioGroup));
            }
        });

        newOptionButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(getContext());
                View promptView = layoutInflater.inflate(R.layout.new_option, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setView(promptView);
                final EditText optionText = (EditText) promptView.findViewById(R.id.optiontext);
                builder.setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                RadioButton radioButton = new RadioButton(getContext());
                                radioButton.setText(optionText.getText());
                                RadioGroup group = view.findViewById(R.id.radiogroupoptions);
                                group.addView(radioButton);
                            }
                        })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();

                                    }
                                });
                AlertDialog dialog = builder.create();
                dialog.show();

            }

        });
    }

    public class OptionHandler implements View.OnClickListener{
        private RadioGroup new_group;

        public OptionHandler(RadioGroup radioGroup){
            new_group = radioGroup;
        }


        public void onClick(View v) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            View promptView = layoutInflater.inflate(R.layout.new_option, null);
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setView(promptView);
            final EditText optionText = (EditText) promptView.findViewById(R.id.optiontext);
            builder.setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            RadioButton radioButton = new RadioButton(getContext());
                            radioButton.setText(optionText.getText());
                            new_group.addView(radioButton);
                        }
                    })
                    .setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
}



