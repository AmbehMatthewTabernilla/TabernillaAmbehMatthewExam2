package com.tabernilla.tabernillaambehmatthewexam2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecondActivity  extends AppCompatActivity {

    private static final String fileName = "Activities.txt";
    private static final String comment = "Comments.txt";
    TextView activityView;
    TextView commentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityView = findViewById(R.id.activityView);
        commentView = findViewById((R.id.commentView));

        FileInputStream inputStream = null;
        try {
            inputStream = openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null)
            {
                sb.append(text).append("\n");
            }

            activityView.setText(sb.toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            inputStream = openFileInput(comment);
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null)
            {
                sb.append(text).append("\n");
            }

            commentView.setText(sb.toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void previousBtn (View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void sendBtn (View view)
    {
        Toast.makeText(this, "Registration Sent... " , Toast.LENGTH_LONG).show();
    }


}


