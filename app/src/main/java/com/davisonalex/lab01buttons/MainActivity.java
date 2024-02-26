package com.davisonalex.lab01buttons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button incrementButton;
    TextView greetingDisplay;
    TextView countDisplay;
    Button surprise;
    Button pull;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        incrementButton=findViewById(R.id.increment_button);
        greetingDisplay=findViewById(R.id.greetingtextview);
        countDisplay=findViewById(R.id.count_a);
        countDisplay.setText(""+count);
        surprise = findViewById(R.id.gacha);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                System.out.println("incrementing: "+count);
                Log.i("incrementing",""+count);
                countDisplay.setText(""+count);
            }
        });
        surprise.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Gacha.class);
                startActivity(intent);
                finish();

            }

        });

    }


}