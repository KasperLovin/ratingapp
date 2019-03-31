package com.example.rateingapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.res.Configuration;
import android.widget.Toast;

import java.util.Locale;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Course> courseList = new ArrayList<>();

    Button angularButton;
    Button pythonButton;
    Button androidAppButton;
    Button androidGamesButton;
    Button changeLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courseList.add(new Course("Angular"));
        courseList.add(new Course("Python"));
        courseList.add(new Course("Android App"));
        courseList.add(new Course("Android Games"));

        angularButton = findViewById(R.id.button);
        pythonButton = findViewById(R.id.button2);
        androidAppButton = findViewById(R.id.button3);
        androidGamesButton =findViewById(R.id.button4);
        changeLanguage = findViewById(R.id.button7);

        angularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RatingPage.class);
                intent.putExtra("Course", courseList.get(0));
                startActivity(intent);
            }
        });
        pythonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RatingPage.class);
                intent.putExtra("Course", courseList.get(1));
                startActivity(intent);
            }
        });
        androidAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RatingPage.class);
                intent.putExtra("Course", courseList.get(2));
                startActivity(intent);
            }
        });
        androidGamesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RatingPage.class);
                intent.putExtra("Course", courseList.get(3));
                startActivity(intent);
            }
        });
        changeLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("HER!!!" + getResources().getConfiguration().locale);
                if (getResources().getConfiguration().locale.toString().equals("da"))  {
                    Locale locale = new Locale("en");
                    Locale.setDefault(locale);
                    Resources res = getResources();
                    Configuration config = new Configuration(res.getConfiguration());
                    config.locale = locale;
                    res.updateConfiguration(config, res.getDisplayMetrics());
                    Intent refresh = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(refresh);
                    Toast.makeText(MainActivity.this, "English Language Selected", Toast.LENGTH_LONG).show();
                }
                else{
                    Locale locale = new Locale("da");
                    Locale.setDefault(locale);
                    Resources res = getResources();
                    Configuration config = new Configuration(res.getConfiguration());
                    config.locale = locale;
                    res.updateConfiguration(config, res.getDisplayMetrics());
                    Intent refresh = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(refresh);
                    Toast.makeText(MainActivity.this, "Dansk Sprog Valgt", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
