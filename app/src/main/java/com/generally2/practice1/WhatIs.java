package com.generally2.practice1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
