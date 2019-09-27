package com.generally2.practice1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.github.barteksc.pdfviewer.PDFView;

public class SeedGermination extends AppCompatActivity {
    PDFView seed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);

        seed = (PDFView)findViewById(R.id.pdf_viewer);

        seed.fromAsset("seed_germination.pdf").load();

    }
}
