package com.example.todohidromiel.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.example.todohidromiel.R;

import java.util.Collections;
import java.util.List;

public class CustomSpinnerAdapter extends ArrayAdapter<String> {

    private LayoutInflater inflater;
    private List<String> items;

    public CustomSpinnerAdapter(Context context, List<String> items) {
        super(context, android.R.layout.simple_spinner_item, items);
        this.inflater = LayoutInflater.from(context);
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(android.R.layout.simple_spinner_item, parent, false);
        }

        // Get and set view
        TextView textView = view.findViewById(android.R.id.text1);
        textView.setText(items.get(position));

        // Change color
        textView.setTextColor(ContextCompat.getColor(getContext(), R.color.btnText));

        return view;
    }

    // Change droDownView
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View dropdownView = convertView;
        if (dropdownView == null) {
            dropdownView = inflater.inflate(android.R.layout.simple_spinner_dropdown_item, parent, false);
        }

        // Get dropdown view
        TextView textView = dropdownView.findViewById(android.R.id.text1);
        textView.setText(items.get(position));

        // Change dropdown: background color and text color
        textView.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.stroke_background));
        textView.setTextColor(ContextCompat.getColor(getContext(), R.color.btnText));


        return dropdownView;
    }



}

