package com.example.deftsoft.first.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.deftsoft.R;

import java.util.ArrayList;

/**
 * Created by mukul_sharma on 29/08/16.
 * Project UniLive, Built with love
 */
public class ColorsAdapter extends ArrayAdapter {

    private ArrayList<RedMarker> markers = new ArrayList<>();
    private int count;

    private int lastRedEnd;
    private int nextRedStart = 1;
    private int nextRed = 1;
    private int redDone = 0;

    private RedMarker currentMarker;

    public ColorsAdapter(Context context, int itemCount) {
        super(context, 0);
        this.count = itemCount;
        createRedMarkers();
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ColorViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.color_item, parent, false);
            holder = new ColorViewHolder();
            holder.view = convertView.findViewById(R.id.text);
            convertView.setTag(holder);
        } else {
            holder = (ColorViewHolder) convertView.getTag();
        }

        setHolderColor(holder, position);
        return convertView;
    }

    private void setHolderColor(ColorViewHolder colorViewHolder, int position) {
        View viewToColor = colorViewHolder.view;
//        TODO check condition
        if (isRedTurn(position)) {
            viewToColor.setBackgroundColor(Color.RED);
            redDone++;
            if (redDone == nextRed) {
                updateRedPositions(position);
                nextRed++;
                redDone = 0;
            }
        } else {
            viewToColor.setBackgroundColor(Color.GRAY);
        }
    }

    private boolean isRedTurn(int position) {
        return position >= nextRedStart && position <= nextRedStart + nextRed && redDone <= nextRed;
    }

    private void updateRedPositions(int position) {
        nextRedStart = nextRedStart + redDone + 1;
    }

    private void createRedMarkers() {
        int lastStop = 1;
        int expected = 1;
        for (int i = 0; i <= count; i++) {
            markers.add(new RedMarker(lastStop + 1, lastRedEnd + expected, expected));
        }
    }

    public static class ColorViewHolder {
        public View view;
    }

    private static class RedMarker {
        protected int start;
        protected int end;

        private int expected;
        protected int done;

        public RedMarker(int start, int end, int expected) {
            this.expected = expected;
            this.end = end;
            this.start = start;
        }

        protected boolean isRedTurn(int position) {
            if (position >= start && position <= end && expected <= done) {
                expected++;
                return true;
            }
            return false;
        }


    }

}
