package com.example.deftsoft.second.model;

/**
 * Created by mukul_sharma on 29/08/16.
 * Project UniLive, Built with love
 */
public class ItemCountVersion {

    private int old;
    private int current;

    public boolean hasChanged() {
        return old != current;
    }

    public void up() {
        current++;
    }

    public void down() {
        current--;
        if (current < 0) {
            current = 0;
        }
    }

    public void update() {
        old = current;
    }

    public int getCurrent() {
        return current;
    }
}
