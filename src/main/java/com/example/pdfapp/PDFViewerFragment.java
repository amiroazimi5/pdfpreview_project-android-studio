package com.example.pdfapp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.barteksc.pdfviewer.PDFView;

public class PDFViewerFragment extends Fragment {
    private static final String ARG_PDF_FILE = "pdf_file";
    private String pdfFileName;
    public PDFViewerFragment() {}
    public static PDFViewerFragment newInstance(String pdfFile) {
        PDFViewerFragment fragment = new PDFViewerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PDF_FILE, pdfFile);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            pdfFileName = getArguments().getString(ARG_PDF_FILE);
        }
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pdf_viewer, container, false);
        PDFView pdfView = view.findViewById(R.id.pdfView);
        pdfView.fromAsset(pdfFileName)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .load();
        return view;
    }
}
