package com.example.pdfapp;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PDFListFragment extends Fragment {
    String[] pdfFiles = {"pdf/pdf1.pdf", "pdf/pdf2.pdf", "pdf/pdf3.pdf", "pdf/pdf4.pdf"};
    OnPDFSelectedListener listener;
    public interface OnPDFSelectedListener {
        void onPDFSelected(String pdfFile);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pdf_list, container, false);
        ListView listView = view.findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_list_item_1,
                pdfFiles
        );
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, itemView, position, id) -> listener.onPDFSelected(pdfFiles[position]));
        return view;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnPDFSelectedListener) {
            listener = (OnPDFSelectedListener) context;
        } else {
            throw new RuntimeException(context
                    + " must implement OnPDFSelectedListener");
        }
    }
}

