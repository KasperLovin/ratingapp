package com.example.rateingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class RatingPage extends AppCompatActivity {

    TextView textViewTitle;
    RatingBar ratingBar1;
    RatingBar ratingBar2;
    RatingBar ratingBar3;
    RatingBar ratingBar4;
    RatingBar ratingBar5;
    RatingBar ratingBar6;
    Button submitButton;
    Course courseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_rating_page);

        Intent intent = getIntent();
        courseName = intent.getParcelableExtra("Course");
        System.out.println("Rating PAGE" + courseName.getName());

        textViewTitle = findViewById(R.id.textView8);
        textViewTitle.setText(courseName.getName());

        ratingBar1 = findViewById(R.id.ratingBar4);
        ratingBar2 = findViewById(R.id.ratingBar3);
        ratingBar3 = findViewById(R.id.ratingBar2);
        ratingBar4 = findViewById(R.id.ratingBar);
        ratingBar5 = findViewById(R.id.ratingBar5);
        ratingBar6 = findViewById(R.id.ratingBar6);

        submitButton = findViewById(R.id.button5);


        ratingBar1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            }
        });
        ratingBar2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            }
        });
        ratingBar3.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            }
        });
        ratingBar4.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            }
        });
        ratingBar5.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            }
        });
        ratingBar6.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultRating();
                Intent intent = new Intent(RatingPage.this, SubmitPage.class);
                intent.putExtra("Course","Thanks for rating: " + courseName.getName());
                System.out.println("rating 2" + courseName.getName());
                intent.putExtra("Result", resultRating());
                startActivity(intent);
            }
        });
    }
        private String resultRating() {
            double totalRating = (ratingBar1.getRating() + ratingBar2.getRating() + ratingBar3.getRating()
                    + ratingBar4.getRating() + ratingBar5.getRating() + ratingBar6.getRating()) * 20 / 6;
            if (totalRating >= 90)
                return "A ";

            else if (totalRating >= 80 && totalRating < 90)
                return "B ";

            else if (totalRating >= 70 && totalRating < 80)
                return "C ";

            else if (totalRating >= 60 && totalRating < 70)
                return "D ";

            else if (totalRating >= 50 && totalRating < 60)
                return "E ";

            else if (totalRating < 50)
                return "GET A NEW JOB ";

        return "";
    }
}
