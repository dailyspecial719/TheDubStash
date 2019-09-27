package com.generally2.practice1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.github.barteksc.pdfviewer.PDFView;

public class Transplant extends AppCompatActivity {

    PDFView plant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);

        plant = (PDFView)findViewById(R.id.pdf_viewer);
        plant.fromAsset("transplanting.pdf").load();
    }
}
