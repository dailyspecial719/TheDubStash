package com.generally2.practice1;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Propagation extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propagation);

        String[] propTopics;
        int[] propImages ={R.drawable.seed_sprout,R.drawable.lighting3, R.drawable.seed, R.drawable.clone1, R.drawable.transplant};

        Resources res = getResources();

        propTopics = res.getStringArray(R.array.prop_topics);

        ListAdapter myAdapter = new LabAdapter(this, propTopics, propImages );
        ListView listView = (ListView)findViewById(R.id.propagationView);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String topics = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(Propagation.this, topics, Toast.LENGTH_SHORT).show();

                        if (position == 0){
                            Intent intent = new Intent(Propagation.this, WhatIs.class);//what is propagation
                            startActivity(intent);
                        }
                        if (position == 1){
                            Intent intent = new Intent(Propagation.this, PropEnvironment.class);//Environment
                            startActivity(intent);
                        }
                        if (position == 2){
                            Intent intent = new Intent(Propagation.this, SeedGermination.class);//Seeds
                            startActivity(intent);
                        }
                        if (position == 3){
                            Intent intent = new Intent(Propagation.this, CloneLab.class);//clones
                            startActivity(intent);
                        }
                        if (position == 4){
                            Intent intent = new Intent(Propagation.this, Transplant.class);//Transplanting
                            startActivity(intent);
                        }

                    }
                }
        );

    }
}
