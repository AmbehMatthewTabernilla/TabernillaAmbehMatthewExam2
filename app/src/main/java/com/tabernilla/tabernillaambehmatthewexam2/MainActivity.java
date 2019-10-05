package com.tabernilla.tabernillaambehmatthewexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class MainActivity extends AppCompatActivity {

    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    CheckBox checkBox5;
    CheckBox checkBox6;
    CheckBox checkBox7;
    CheckBox checkBox8;
    EditText commentBox;
    Button nextBtn;

    private static final String fileName = "Activities.txt";
    private static final String comment = "Comments.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);
        checkBox7 = findViewById(R.id.checkBox7);
        checkBox8 = findViewById(R.id.checkBox8);
        commentBox = findViewById(R.id.commentBox);
        nextBtn = findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                nextBtn();
            }
        });
    }

    public void Save(View v) {
        String activityString = "";

        if (checkBox1.isChecked()) {
            String text = checkBox1.getText().toString();
            activityString = activityString + "\n" + text + "\n";
        }
        if (checkBox2.isChecked()) {
            String text = checkBox2.getText().toString();
            activityString = activityString + text + "\n";
        }
        if (checkBox3.isChecked()) {
            String text = checkBox3.getText().toString();
            activityString = activityString + text + "\n";
        }
        if (checkBox4.isChecked()) {
            String text = checkBox4.getText().toString();
            activityString = activityString + text + "\n";
        }
        if (checkBox5.isChecked()) {
            String text = checkBox5.getText().toString();
            activityString = activityString + text + "\n";
        }
        if (checkBox6.isChecked()) {
            String text = checkBox6.getText().toString();
            activityString = activityString + text + "\n";
        }
        if (checkBox7.isChecked()) {
            String text = checkBox7.getText().toString();
            activityString = activityString + text + "\n";
        }
        if (checkBox8.isChecked()) {
            String text = checkBox8.getText().toString();
            activityString = activityString + text;
        }

        String comment = commentBox.getText().toString();

        FileOutputStream activityStream;
        FileOutputStream commentStream;

        try {
            activityStream = openFileOutput("subjects.txt", MODE_PRIVATE);
            OutputStreamWriter out = new OutputStreamWriter(activityStream);
            out.write(activityString);
            out.close();
            activityStream.close();
            commentStream = openFileOutput("comment.txt", MODE_PRIVATE);
            OutputStreamWriter out2 = new OutputStreamWriter(commentStream);
            out2.write(comment);
            out2.close();
            commentStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "data is saved!", Toast.LENGTH_LONG).show();

    }
    public void nextBtn()
    {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

}
