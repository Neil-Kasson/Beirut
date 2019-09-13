package neil_kasson.beirut;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent = getIntent();
        g = (Game)intent.getSerializableExtra("game");

        round = true;
        s1 = g.p1+"'s Shot: ";
        s2 = g.p2+"'s Shot: ";

        txt = findViewById(R.id.txt);
        txt.setText(s1);
        make = findViewById(R.id.make);
        miss = findViewById(R.id.miss);
        head = findViewById(R.id.head);
        cup2 = findViewById(R.id.cup2);
        cup3 = findViewById(R.id.cup3);

        make.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (round) {
                    if(g.p1makes==9)
                        g.p1last++;
                    g.p1makes++;
                    round = false;
                    if (g.p1makes == 10)
                        loadFinal();
                    else
                        txt.setText(s2);
                } else {
                    if(g.p2makes==9)
                        g.p2last++;
                    g.p2makes++;
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
                    round = false;
                    txt.setText(s2);
                } else {
                    if(g.p2makes==9)
                        g.p2last++;
                    g.p2misses++;
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
                    if(g.p1makes==8)
                        g.p1last++;
                    g.p1makes += 2;
                    round = false;
                    if (g.p1makes == 10)
                        loadFinal();
                    else
                        txt.setText(s2);
                } else {
                    if(g.p2makes==8)
                        g.p2last++;
                    g.p2makes += 2;
                    round = true;
                    if (g.p2makes == 10)
                        loadFinal();
                    else
                        txt.setText(s1);
                }
            }
        });

        cup3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (round) {
                    if(g.p1makes==7)
                        g.p1last++;
                    g.p1makes += 3;
                    round = false;
                    if (g.p1makes == 10)
                        loadFinal();
                    else
                        txt.setText(s2);
                } else {
                    if(g.p2makes==7)
                        g.p2last++;
                    g.p2makes += 3;
                    round = true;
                    if (g.p2makes == 10)
                        loadFinal();
                    else
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
