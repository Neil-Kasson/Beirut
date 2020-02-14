package com.example.beirut;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    static Game g;

    EditText p1Name;
    EditText p2Name;
    Button readyB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        p1Name = findViewById(R.id.p1Name);
        p2Name = findViewById(R.id.p2Name);
        readyB = findViewById(R.id.readyB);

        readyB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.v("Main", "setOnClick A");
                g = new Game(p1Name.getText().toString(), p2Name.getText().toString());
                Log.v("Main", "setOnClick B");
                openActivity2();
                Log.v("Main", "setOnClick C");
            }
        });
    }

    public void openActivity2(){
        Log.v("Main", "openActiv A");
        Intent intent = new Intent(this, Activity2.class);
        Log.v("Main", "openActiv B");
        intent.putExtra("game", g);
        Log.v("Main", "openActiv C");
        startActivity(intent);
        Log.v("Main", "openActiv D");
    }
}
