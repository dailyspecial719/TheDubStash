package com.generally2.practice1;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.github.barteksc.pdfviewer.PDFView;

public class VegLightingActivity extends AppCompatActivity {

    PDFView veg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);

        veg = (PDFView)findViewById(R.id.pdf_viewer);
        veg.fromAsset("veg_lighting.pdf").load();
    }
}
