package com.generally2.practice1;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;


public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1, button2, button3, button4, button5, button6;

        button1 = findViewById(R.id.b1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LogoActivity.class);
                startActivity(intent);
            }
        });

        button2 = findViewById(R.id.b2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FindDubActivity.class);
                startActivity(intent);
            }
        });

        button3 = findViewById(R.id.b3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LogoActivity.class);
                startActivity(intent);
            }
        });

        button4 = findViewById(R.id.b4);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DubGrub.class);
                startActivity(intent);
            }
        });

        button5 = findViewById(R.id.b5);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DubLabActivity.class);
                startActivity(intent);
            }
        });

        button6 = findViewById(R.id.b6);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LogoActivity.class);
                startActivity(intent);
            }
        });



    }




}
