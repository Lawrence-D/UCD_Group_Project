package com.school.optimstudy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class activity_new_test extends AppCompatActivity {
    Button newOptionButton;
    Button newQuestionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_test);
        newOptionButton = (Button) findViewById(R.id.newOption);
        newQuestionButton = (Button) findViewById(R.id.newQuestionButton);

        newQuestionButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                LinearLayout layout = findViewById(R.id.newTestLayoutVertical);
                    EditText newEditText = new EditText(activity_new_test.this);
                    Button newOptionButton = new Button(activity_new_test.this);
                    RadioGroup radioGroup = new RadioGroup(activity_new_test.this);
                    newOptionButton.setText("New Option");

                    Button newQuestion = new Button(activity_new_test.this);
                    newQuestion.setOnClickListener(this);
                    newQuestion.setText("New Question");
                    LinearLayout horizontalLayout = new LinearLayout(activity_new_test.this);
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
                LayoutInflater layoutInflater = LayoutInflater.from(activity_new_test.this);
                View promptView = layoutInflater.inflate(R.layout.new_option, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(activity_new_test.this);
                builder.setView(promptView);
                final EditText optionText = (EditText) promptView.findViewById(R.id.optiontext);
                builder.setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                RadioButton radioButton = new RadioButton(activity_new_test.this);
                                radioButton.setText(optionText.getText());
                                RadioGroup group = findViewById(R.id.radiogroupoptions);
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
            LayoutInflater layoutInflater = LayoutInflater.from(activity_new_test.this);
            View promptView = layoutInflater.inflate(R.layout.new_option, null);
            AlertDialog.Builder builder = new AlertDialog.Builder(activity_new_test.this);
            builder.setView(promptView);
            final EditText optionText = (EditText) promptView.findViewById(R.id.optiontext);
            builder.setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            RadioButton radioButton = new RadioButton(activity_new_test.this);
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



