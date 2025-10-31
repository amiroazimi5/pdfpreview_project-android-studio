package com.example.pdfapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements PDFListFragment.OnPDFSelectedListener {
    boolean isLandscape = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isLandscape = findViewById(R.id.list_container) != null;
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (isLandscape) {
            ft.replace(R.id.list_container, new PDFListFragment());
        } else {
            ft.replace(R.id.fragment_container, new PDFListFragment());
        }   ft.commit();
    }

    @Override
    public void onPDFSelected(String pdfFile) {
        PDFViewerFragment viewerFragment = PDFViewerFragment.newInstance(pdfFile);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (isLandscape) {
            ft.replace(R.id.pdf_container, viewerFragment);
        } else {
            ft.replace(R.id.fragment_container, viewerFragment);
            ft.addToBackStack(null);
        }   ft.commit();
    }
}