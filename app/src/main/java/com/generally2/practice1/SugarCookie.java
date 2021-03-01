package com.generally2.practice1;



import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.github.barteksc.pdfviewer.PDFView;

public class SugarCookie extends AppCompatActivity {
    PDFView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);

        view = findViewById(R.id.pdf_viewer);
        view.fromAsset("sugar_cookies.pdf").load();
    }
}
