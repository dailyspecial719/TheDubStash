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

public class VegetativeStage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetative_stage);

        String[] vegTopics;
        int[] vegImages = {R.drawable.lighting3, R.drawable.veglighting, R.drawable.nutes, R.drawable.deficiency };

        Resources res = getResources();

        vegTopics = res.getStringArray(R.array.veg_topics);

        ListAdapter myAdapter = new LabAdapter(this, vegTopics, vegImages);
        ListView listView = (ListView)findViewById(R.id.vegetationView);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String topics = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(VegetativeStage.this, topics, Toast.LENGTH_SHORT).show();

                        if (position == 0){
                            Intent intent = new Intent(VegetativeStage.this, VegLightingActivity.class); //Veg Lighting
                            startActivity(intent);
                        }
                        if (position == 1){
                            Intent intent = new Intent(VegetativeStage.this, LogoActivity.class); //Environment control
                            startActivity(intent);
                        }
                        if (position == 2){
                            Intent intent = new Intent(VegetativeStage.this, LogoActivity.class); //Nutrients
                            startActivity(intent);
                        }
                        if (position == 3){
                            Intent intent = new Intent(VegetativeStage.this, LogoActivity.class);//Common Problems
                            startActivity(intent);
                        }

                    }
                }
        );

    }
}
