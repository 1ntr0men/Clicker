package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Store extends AppCompatActivity implements View.OnTouchListener {

    ImageView drill, drill_machine, big_drill_machine, enter_item;
    Dialog store_dialog;
    Button yes_btn, cancel_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        drill.findViewById(R.id.drill);
        drill_machine.findViewById(R.id.drill_machine);
        big_drill_machine.findViewById(R.id.big_drill_machine);

        //Диалоговое окно подтверждения покупки - начало
        store_dialog = new Dialog(this);
        store_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        store_dialog.setContentView(R.layout.storedialog);
        store_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        yes_btn = (Button) store_dialog.findViewById(R.id.yes);
        cancel_btn = (Button) store_dialog.findViewById(R.id.cancel);

        yes_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                } catch (Exception e) {
                    // здесь кода не будет
                }
            }
        });
        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        enter_item = (ImageView) store_dialog.findViewById(R.id.enter_item);
        drill.setOnTouchListener(this);
        drill_machine.setOnTouchListener(this);
        big_drill_machine.setOnTouchListener(this);
        //Диалоговое окно подтверждения покупки - конец
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v.getId() == house1.getId()) {
            house_dialog.setImageResource(R.drawable.house_one);

            store_dialog.show();
        } else {
            house_dialog.setImageResource(R.drawable.house_two);
            store_dialog.show();
        }
        return true;
    }
}
