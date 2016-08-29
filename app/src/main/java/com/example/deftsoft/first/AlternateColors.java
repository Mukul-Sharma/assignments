package com.example.deftsoft.first;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.deftsoft.R;
import com.example.deftsoft.first.adapter.ColorsAdapter;

public class AlternateColors extends AppCompatActivity {

    private final static int ITEM_COUNT = 20;

    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alternate_colors);
        ListView listView = (ListView) findViewById(R.id.colors_list);
        createAdapter();
        listView.setAdapter(adapter);
    }

    private void createAdapter() {
        adapter = new ColorsAdapter(this, ITEM_COUNT);
    }
}
