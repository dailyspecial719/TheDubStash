package com.generally2.practice1;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Pest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pest);

        String[] pestTopics;
        int[] pestImages = {R.drawable.mites, R.drawable.bad_flower};

        Resources res = getResources();

        pestTopics = res.getStringArray(R.array.pest_topics);

        ListAdapter myAdapter = new LabAdapter(this, pestTopics, pestImages);
        ListView listView = (ListView)findViewById(R.id.pestView);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String topics = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(Pest.this, topics, Toast.LENGTH_SHORT).show();

                        if (position == 0){
                            Intent intent = new Intent(Pest.this, LogoActivity.class); //Pests
                            startActivity(intent);
                        }
                        if (position == 1){
                            Intent intent = new Intent(Pest.this, LogoActivity.class); //Diseases and Fungus
                            startActivity(intent);
                        }

                    }
                }
        );
    }
}
