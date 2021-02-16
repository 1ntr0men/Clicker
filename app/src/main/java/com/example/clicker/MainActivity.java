package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView house;
    TextView money;
    ProgressBar progressBar;
    Button store;
    ConstraintLayout root;
    int m = 0;
    String[] houses;
    private float x1,x2;
    static final int MIN_DISTANCE = 150;

    public int getResId(ImageView iv, String name) {
        return iv.getContext().getResources().getIdentifier(name, "drawable", iv.getContext().getPackageName());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        house = findViewById(R.id.house);
        money = findViewById(R.id.money);

        root = findViewById(R.id.root);
        store = findViewById(R.id.store);

        house.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    m += 1;
                    money.setText("$ " + Integer.toString(m));
                }
                return true;
            }
        });
        root.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        x1 = event.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        x2 = event.getX();
                        float deltaX = x2 - x1;
                        if (Math.abs(deltaX) > MIN_DISTANCE)
                        {
                            money.setText("УРА БЛЯТЬ");
                        }
                        else
                        {
                            money.setText("УРА БЛЯТЬвафыв");// consider as something else - a screen tap for example
                        }
                        break;
                }
                return true;
            }
        });
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Store.class);
                startActivity(intent);

            }
        });
    }
}
