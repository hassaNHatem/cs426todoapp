package com.example.todolist;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
TextView txt;
Intent intent;
Button back;
CheckBox check;
Boolean ischecked;
TextView desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        back = findViewById(R.id.back);
        txt = findViewById(R.id.todotitle);
        intent = getIntent();
        txt.setText(intent.getStringExtra("todoname"));
        check = findViewById(R.id.check);
        ischecked = intent.getBooleanExtra("check",false);
        check.setChecked(ischecked);
        desc = findViewById(R.id.disc);
        desc.setText(intent.getStringExtra("tododis"));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               finish();
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ischecked==true){
                    check.setChecked(false);
                    ischecked=false;
                }else{
                    check.setChecked(true);
                    ischecked=true;
                }

            }
        });

    }
}