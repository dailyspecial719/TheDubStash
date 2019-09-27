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

public class Harvest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harvest);

        String[] harvestTpoics;
        int[] harvestImages = {R.drawable.harvest2, R.drawable.trimming, R.drawable.drying, R.drawable.curing};

        Resources res = getResources();

        harvestTpoics = res.getStringArray(R.array.harvest_topics);

        ListAdapter myAdapter = new LabAdapter(this, harvestTpoics, harvestImages);
        ListView listView = (ListView)findViewById(R.id.harvestView);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String topics = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(Harvest.this, topics, Toast.LENGTH_SHORT).show();

                        if (position == 0){
                            Intent intent = new Intent(Harvest.this, LogoActivity.class); //Harvesting
                            startActivity(intent);
                        }
                        if (position == 1){
                            Intent intent = new Intent(Harvest.this, LogoActivity.class); //Trimming
                            startActivity(intent);
                        }
                        if (position == 2){
                            Intent intent = new Intent(Harvest.this, LogoActivity.class); //Drying
                            startActivity(intent);
                        }
                        if (position == 3){
                            Intent intent = new Intent(Harvest.this, LogoActivity.class);//Curing and Storage
                            startActivity(intent);
                        }
                    }
                }
        );


    }
}
