package com.generally2.practice1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PropEnvironment extends AppCompatActivity {
   // TextView textView;

    PDFView page;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);


        page = (PDFView)findViewById(R.id.pdf_viewer);
        page.fromAsset("prop_environment.pdf").load();


        /*textView = (TextView)findViewById(R.id.propEnvTxt);

        String text = "";

        try{
            InputStream is = getAssets().open("propEnvironment.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text = new String(buffer);

        }catch (Exception e){
            e.printStackTrace();
        }
        textView.setText(text);*/
    }
}
