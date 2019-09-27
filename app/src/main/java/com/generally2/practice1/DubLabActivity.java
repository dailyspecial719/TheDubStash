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
import android.widget.Toast;

public class DubLabActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dub_lab);

        String[] growTopics;
        int[] growImages = {R.drawable.seedling, R.drawable.veg, R.drawable.bud, R.drawable.harvest, R.drawable.mites};

        Resources res = getResources();

        growTopics = res.getStringArray(R.array.grow_topics);

        ListAdapter myAdapter = new LabAdapter(this, growTopics, growImages);
        ListView listView = (ListView)findViewById(R.id.dubLabList);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String topics = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(DubLabActivity.this, topics, Toast.LENGTH_SHORT).show();


                        if (position == 0){
                            Intent intent = new Intent(DubLabActivity.this, Propagation.class); //propagation
                            startActivity(intent);
                        }
                        if (position == 1){
                            Intent intent = new Intent(DubLabActivity.this, VegetativeStage.class); //vegetative stage
                            startActivity(intent);
                        }
                        if (position == 2){
                            Intent intent = new Intent(DubLabActivity.this, FloweringStage.class);//flowering stage
                            startActivity(intent);
                        }
                        if (position == 3){
                            Intent intent = new Intent(DubLabActivity.this, Harvest.class);//harvesting and curring
                            startActivity(intent);
                        }
                        if (position == 4){
                            Intent intent = new Intent(DubLabActivity.this, Pest.class); //pests and diseases
                            startActivity(intent);
                        }

                    }
                }
        );

    }
}
