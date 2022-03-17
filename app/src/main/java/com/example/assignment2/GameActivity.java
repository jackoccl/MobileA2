package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Random;

import Connector.Celebrity;
import Connector.CelebrityImageService;
import Connector.CelebrityService;
import Connector.VolleyCallBack;

public class GameActivity extends AppCompatActivity {
    CelebrityService celebService;
    CelebrityImageService celebImageService;
    ArrayList<Celebrity> allCelebs;
    Celebrity correctCeleb;

    ArrayList<Button> QuestionButtons;
    View.OnClickListener answerClickListener;

    int score;

    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_game);
        image = findViewById(R.id.celebImage);
        QuestionButtons = new ArrayList<Button>();
        QuestionButtons.add((Button)findViewById(R.id.b1));
        QuestionButtons.add((Button)findViewById(R.id.b2));
        QuestionButtons.add((Button)findViewById(R.id.b3));
        QuestionButtons.add((Button)findViewById(R.id.b4));



        celebService = new CelebrityService(this);
        celebService.Search(new VolleyCallBack() {
            @Override
            public void onSuccess() {
                allCelebs = celebService.getCelebs();
                StartGame();
            }
        });

    }

    private void StartGame() {
        Random r = new Random();
        celebImageService = new CelebrityImageService(getApplicationContext());
        score = 0;

        correctCeleb = allCelebs.get(0);

        celebImageService.ChangeCeleb(correctCeleb);
        correctCeleb.setImage(celebImageService);

        Glide.with(image).load(correctCeleb.imageURL).centerCrop().into(image);


        answerClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btn = (Button)view;
                Toast t;
                if(btn.getText()==correctCeleb.name){
                    t=Toast.makeText(getApplicationContext(),"Correct!",Toast.LENGTH_SHORT);
                    score++;
                    btn.setBackgroundColor(Color.GREEN);

                }else{
                    t=Toast.makeText(getApplicationContext(),"Incorrect!",Toast.LENGTH_SHORT);
                    btn.setBackgroundColor(Color.RED);
                }
                t.show();


            }
        };

        for(Button b:QuestionButtons){
            b.setText(allCelebs.get(r.nextInt(allCelebs.size()-0)).name);
            b.setOnClickListener(answerClickListener);
        }

        QuestionButtons.get(r.nextInt(3-0)-0).setText(correctCeleb.name);
    }

    private void GenerateQuestion(){
        Random r = new Random();
    }
}