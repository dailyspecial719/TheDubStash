package com.generally2.practice1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.github.barteksc.pdfviewer.PDFView;

public class WhatIs extends AppCompatActivity {

    PDFView what;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);

        what = (PDFView)findViewById(R.id.pdf_viewer);

        what.fromAsset("prop_start.pdf").load();
    }
}
