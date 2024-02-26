package com.davisonalex.lab01buttons;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class Gacha extends Activity {
    Button pull;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gacha_screen);
        pull = findViewById(R.id.roll);

        pull.setOnClickListener(new View.OnClickListener(){
            TextView tv = null;
            TextView tv2 = null;
            TextView tv3 = null;
            int count = 0;
            ConstraintLayout cs = (ConstraintLayout) findViewById(R.id.gacha_screen);
            public void onClick(View v2){
                double val = Math.random();
                count++;
                if(tv != null)
                    tv.setText("Your roll was "+val);
                else {
                    tv = new TextView(Gacha.this);
                    tv.setText("Your roll was " + val);
                    tv.setId(View.generateViewId());
                    ConstraintSet set = new ConstraintSet();
                    cs.addView(tv);
                    set.clone(cs);

                    set.connect(tv.getId(), ConstraintSet.TOP, cs.getId(), ConstraintSet.TOP, 250);
                    set.connect(tv.getId(), ConstraintSet.BOTTOM, cs.getId(), ConstraintSet.BOTTOM);
                    set.connect(tv.getId(), ConstraintSet.RIGHT, cs.getId(), ConstraintSet.RIGHT);
                    set.connect(tv.getId(), ConstraintSet.LEFT, cs.getId(), ConstraintSet.LEFT);
                    set.applyTo(cs);
                }
                if(val<0.004){
                    ImageView iv = new ImageView(Gacha.this);
                    iv.setImageDrawable(getDrawable(R.drawable.res009_no023_normal));
                    iv.setId(View.generateViewId());
                    cs.addView(iv);
                    if(tv2 != null)
                        tv2.setText("");
                    iv.offsetLeftAndRight(50);
                }
                else if(val<0.008){
                    ImageView iv = new ImageView(Gacha.this);
                    iv.setImageDrawable(getDrawable(R.drawable.res010_no022_normal));
                    iv.setId(View.generateViewId());
                    if(tv2 != null)
                        tv2.setText("");
                    cs.addView(iv);
                }
                else{
                    if(tv2!=null)
                        tv2.setText("You got nothing. Try again!");
                    else{
                        tv2 = new TextView(Gacha.this);
                        tv2.setText("You got nothing. Try again!");
                        ConstraintSet set2 = new ConstraintSet();
                        tv2.setId(View.generateViewId());
                        cs.addView(tv2);
                        set2.clone(cs);
                        set2.connect(tv2.getId(), ConstraintSet.TOP, cs.getId(), ConstraintSet.TOP, 500);
                        set2.connect(tv2.getId(), ConstraintSet.BOTTOM, cs.getId(), ConstraintSet.BOTTOM);
                        set2.connect(tv2.getId(), ConstraintSet.RIGHT, cs.getId(), ConstraintSet.RIGHT);
                        set2.connect(tv2.getId(), ConstraintSet.LEFT, cs.getId(), ConstraintSet.LEFT);
                        set2.applyTo(cs);
                    }
                }
                if(tv3 != null)
                    tv3.setText(count+" rolls completed");
                else{
                    tv3 = new TextView(Gacha.this);
                    tv3.setText(count+" rolls completed");
                    ConstraintSet set3 = new ConstraintSet();
                    tv3.setId(View.generateViewId());
                    cs.addView(tv3);
                    set3.clone(cs);
                    set3.connect(tv3.getId(), ConstraintSet.TOP, cs.getId(), ConstraintSet.TOP, 750);
                    set3.connect(tv3.getId(), ConstraintSet.BOTTOM, cs.getId(), ConstraintSet.BOTTOM);
                    set3.connect(tv3.getId(), ConstraintSet.RIGHT, cs.getId(), ConstraintSet.RIGHT);
                    set3.connect(tv3.getId(), ConstraintSet.LEFT, cs.getId(), ConstraintSet.LEFT);
                    set3.applyTo(cs);
                }
            }
        });
    }
}
