package com.example.deftsoft.second;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.deftsoft.R;
import com.example.deftsoft.second.model.Item;
import com.example.deftsoft.second.model.ItemCountVersion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class CartActivity extends AppCompatActivity {

    ArrayList<Item> items;
    HashMap<Item, ItemCountVersion> itemsMap;

    private Item editItem;
    private RadioButton editItemButton;

    int itemsCount;
    TextView countText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        countText = (TextView) findViewById(R.id.total_count);

        itemsMap = new HashMap<>();
        Item one = new Item("One");
        ItemCountVersion v1 = new ItemCountVersion();
        Item two = new Item("Two");
        ItemCountVersion v2 = new ItemCountVersion();
        Item three = new Item("Three");
        ItemCountVersion v3 = new ItemCountVersion();

        items = new ArrayList<>();
        items.add(one);
        items.add(two);
        items.add(three);

        itemsMap.put(one, v1);
        itemsMap.put(two, v2);
        itemsMap.put(three, v3);
    }

    public void cartItemSelected(View view) {
        RadioButton b = (RadioButton) view;
        editItemButton = b;
        boolean checked = b.isChecked();

        if (!checked) return;

        switch (b.getId()) {
            case R.id.first_item:
                editItem = items.get(0);
                break;
            case R.id.second_item:
                editItem = items.get(1);
                break;
            case R.id.third_item:
                editItem = items.get(2);
                break;
            default:
                break;
        }
    }

    public void addItem(View view) {
        itemsMap.get(editItem).up();
        updateItemText();
        itemsCount++;
    }

    public void removeItem(View view) {
        itemsMap.get(editItem).down();
        updateItemText();
        itemsCount--;
    }

    private void updateItemText() {
//        Can use quantity string also
        int count = itemsMap.get(editItem).getCurrent();
        String text = String.format(Locale.getDefault(), "%d %s", count, editItem.getName());
        editItemButton.setText(text);
    }

    public void add(View view) {
        if (shouldUpdate()) {
            updateCountText();
            itemsMap.get(editItem).update();
        }
    }

    private boolean shouldUpdate() {
        ItemCountVersion version = itemsMap.get(editItem);
        return version.hasChanged();
    }

    private void updateCountText() {
        String text = String.format(Locale.getDefault(), "%d total", itemsCount);
        countText.setText(text);
    }

}
