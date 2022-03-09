package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

import Connectors.CelebrityService;
import Connectors.VolleyCallBack;

public class GameActivity extends AppCompatActivity {
    CelebrityService celebService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //TO DO
        //Get 10 random celebrities and do the request to get their url images
        //https://celebritybucks.com/developers

        celebService = new CelebrityService(this);
        celebService.Search(new VolleyCallBack() {
            @Override
            public void onSuccess() {
                System.out.println("Complete");
            }
        });
    }
}