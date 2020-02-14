package com.example.beirut;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    static Game g;
    boolean round;
    String s1;
    String s2;
    TextView txt;
    Button make;
    Button miss;
    Button head;
    Button cup2;
    Button cup3;
    Button undo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        getSupportActionBar().hide();


        Log.v("Act2", "onCreate A");
        Intent intent = getIntent();
        Log.v("Act2", "onCreate B");
        g = (Game)intent.getSerializableExtra("game");
        Log.v("Act2", "onCreate C");

        round = true;
        s1 = g.p1+"'s Shot: ";
        s2 = g.p2+"'s Shot: ";
        Log.v("Act2", "onCreate D");

        txt = findViewById(R.id.txt);
        txt.setText(s1);
        Log.v("Act2", "onCreate E");
        make = findViewById(R.id.make);
        miss = findViewById(R.id.miss);
        head = findViewById(R.id.head);
        cup2 = findViewById(R.id.cup2);
        cup3 = findViewById(R.id.cup3);
        undo = findViewById(R.id.undo);
        Log.v("Act2", "onCreate F");

        make.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (round) {
                    if(g.p1makes==9)
                        g.p1last++;
                    g.p1makes++;
                    g.p1List.add(1);
                    round = false;
                    if (g.p1makes == 10)
                        loadFinal();
                    else
                        txt.setText(s2);
                } else {
                    if(g.p2makes==9)
                        g.p2last++;
                    g.p2makes++;
                    g.p2List.add(1);
                    round = true;
                    if (g.p2makes == 10)
                        loadFinal();
                    else
                        txt.setText(s1);
                }
            }
        });

        miss.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (round) {
                    if(g.p1makes==9)
                        g.p1last++;
                    g.p1misses++;
                    g.p1List.add(0);
                    round = false;
                    txt.setText(s2);
                } else {
                    if(g.p2makes==9)
                        g.p2last++;
                    g.p2misses++;
                    g.p2List.add(0);
                    round = true;
                    txt.setText(s1);
                }
            }
        });

        head.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (round) {
                    if(g.p1makes==9)
                        g.p1last++;
                    g.p1makes++;
                    g.p1List.add(1);
                    g.p1head++;
                    round = false;
                    if (g.p1makes == 10)
                        loadFinal();
                    else
                        txt.setText(s2);
                } else {
                    if(g.p2makes==9)
                        g.p2last++;
                    g.p2makes++;
                    g.p2List.add(1);
                    g.p2head++;
                    round = true;
                    if (g.p2makes == 10)
                        loadFinal();
                    else
                        txt.setText(s1);
                }
            }
        });

        cup2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (round) {
                    if(g.p1makes<=8) {
                        if (g.p1makes == 8)
                            g.p1last++;
                        g.p1makes += 2;
                        g.p1List.add(2);
                        round = false;
                        if (g.p1makes == 10)
                            loadFinal();
                        else
                            txt.setText(s2);
                    }
                } else {
                    if (g.p2makes<=8) {
                        if (g.p2makes == 8)
                            g.p2last++;
                        g.p2makes += 2;
                        g.p2List.add(2);
                        round = true;
                        if (g.p2makes == 10)
                            loadFinal();
                        else
                            txt.setText(s1);
                    }
                }
            }
        });

        cup3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (round) {
                    if(g.p1makes<8) {
                        if (g.p1makes == 7)
                            g.p1last++;
                        g.p1makes += 3;
                        g.p1List.add(3);
                        round = false;
                        if (g.p1makes == 10)
                            loadFinal();
                        else
                            txt.setText(s2);
                    }
                } else {
                    if(g.p2makes<8) {
                        if (g.p2makes == 7)
                            g.p2last++;
                        g.p2makes += 3;
                        g.p2List.add(3);
                        round = true;
                        if (g.p2makes == 10)
                            loadFinal();
                        else
                            txt.setText(s1);
                    }
                }
            }
        });

        undo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(round && g.p2makes+g.p2misses>1){
                   int a =  g.p2List.remove(g.p2List.size()-1);
                   g.p2makes -= a;
                   round = false;
                   txt.setText(s2);
                } else if(!round && g.p1makes+g.p1misses>1){
                    int a =  g.p1List.remove(g.p1List.size()-1);
                    g.p1makes -= a;
                    round = true;
                    txt.setText(s1);
                }
            }
        });
    }

    public void loadFinal(){
        Intent lastInt = new Intent(this, ActivityFinal.class);
        lastInt.putExtra("game", g);
        startActivity(lastInt);
    }
}
