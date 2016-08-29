package com.example.deftsoft.second.model;

import android.support.annotation.NonNull;

/**
 * Created by mukul_sharma on 29/08/16.
 * Project UniLive, Built with love
 */
public class Item {

    @NonNull
    private String name;

    public Item(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Item i = (Item) obj;
        return this.name.equals(i.name);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int hash = prime;
        hash = prime * hash + name.hashCode();
        return hash;
    }
}
