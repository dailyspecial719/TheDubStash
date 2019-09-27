package com.generally2.practice1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.github.barteksc.pdfviewer.PDFView;

public class CloneLab extends AppCompatActivity {

    PDFView clone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);

        clone = (PDFView)findViewById(R.id.pdf_viewer);
        clone.fromAsset("clone_lab.pdf").load();
    }
}
