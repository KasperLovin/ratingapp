package com.example.rateingapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SubmitPage extends AppCompatActivity {

    TextView textViewThanks;
    EditText editTextSend;
    Button buttonSend;
    String courseName;
    String resultRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_page);

        Intent intent = getIntent();
        courseName = intent.getStringExtra("Course");
        System.out.println("submit" + courseName);
        resultRating = intent.getStringExtra("Result");

        textViewThanks = findViewById(R.id.textView9);
        textViewThanks.setText(courseName);
        editTextSend = findViewById(R.id.editText);

        buttonSend = findViewById(R.id.button6);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = new String(editTextSend.getText().toString());
                if (email.endsWith("stud.kea.dk")) {
                    sendEmail();
                }
                else
                    Toast.makeText(SubmitPage.this,
                            "You have to be a student at KEA\n" +
                                    "Or use your KEA-mail", Toast.LENGTH_SHORT).show();
            }
        });
    }
    protected void sendEmail() {
        Log.i("Send email", "");

        String[] TO = {"kasperlovin13@gmail.com"};
        String[] CC = {};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, courseName );
        emailIntent.putExtra(Intent.EXTRA_TEXT, "You gave the rating " + resultRating );

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(SubmitPage.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
