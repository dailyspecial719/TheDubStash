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

public class FloweringStage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowering_stage);

        String[] flowerTopics;
        int[] flowerImages = {R.drawable.lighting, R.drawable.flower2, R.drawable.nutes, R.drawable.bad_flower };

        Resources res = getResources();

        flowerTopics = res.getStringArray(R.array.flower_topics);

        ListAdapter myAdapter = new LabAdapter(this, flowerTopics, flowerImages);
        ListView listView = (ListView)findViewById(R.id.floweringView);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String topics = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(FloweringStage.this, topics, Toast.LENGTH_SHORT).show();

                        if (position == 0){
                            Intent intent = new Intent(FloweringStage.this, LogoActivity.class); //Lighting
                            startActivity(intent);
                        }
                        if (position == 1){
                            Intent intent = new Intent(FloweringStage.this, LogoActivity.class); //Environment control
                            startActivity(intent);
                        }
                        if (position == 2){
                            Intent intent = new Intent(FloweringStage.this, LogoActivity.class); //Nutrients
                            startActivity(intent);
                        }
                        if (position == 3){
                            Intent intent = new Intent(FloweringStage.this, LogoActivity.class);//Common Problems
                            startActivity(intent);
                        }

                    }
                }
        );


    }
}
