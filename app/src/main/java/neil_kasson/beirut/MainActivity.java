package neil_kasson.beirut;

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

        p1Name = findViewById(R.id.p1Name);
        p2Name = findViewById(R.id.p2Name);
        readyB = findViewById(R.id.readyB);

        readyB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                g = new Game(p1Name.getText().toString(), p2Name.getText().toString());
                openActivity2();
            }
        });
    }

    public void openActivity2(){
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("game", g);
        startActivity(intent);
    }
}
