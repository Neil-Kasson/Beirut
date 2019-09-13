package neil_kasson.beirut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityFinal extends AppCompatActivity {

    static Game g;

    TextView top;
    TextView n1;
    TextView n2;
    TextView k1;
    TextView k2;
    TextView s1;
    TextView s2;
    TextView h1;
    TextView h2;
    TextView l1;
    TextView l2;
    Button again;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Intent lastInt = getIntent();
        g = (Game)lastInt.getSerializableExtra("game");

        top = findViewById(R.id.top);
        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        k1 = findViewById(R.id.k1);
        k2 = findViewById(R.id.k2);
        s1 = findViewById(R.id.s1);
        s2 = findViewById(R.id.s2);
        h1 = findViewById(R.id.h1);
        h2 = findViewById(R.id.h2);
        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);
        again = findViewById(R.id.again);

        String s;

        if (g.p1makes==10)
            s = (g.p1+" Wins!!!");
        else
            s = (g.p2+" Wins!!!");

        top.setText(s);
        n1.setText(g.p1);
        n2.setText(g.p2);
        k1.setText(String.valueOf(g.p1makes));
        k2.setText(String.valueOf(g.p2makes));
        s1.setText(String.valueOf(g.p1misses));
        s2.setText(String.valueOf(g.p2misses));
        h1.setText(String.valueOf(g.p1head));
        h2.setText(String.valueOf(g.p2head));
        l1.setText(String.valueOf(g.p1last));
        l2.setText(String.valueOf(g.p2last));

        again.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity();
            }
        });

    }

    public void openActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
