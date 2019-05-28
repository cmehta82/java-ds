package com.practice.java.ds.hashes;

@SuppressWarnings("WeakerAccess")
public class HashEntry<X, Y> {

    private X key;
    private Y item;

    public HashEntry(X key, Y item) {
        this.key = key;
        this.item = item;
    }

    public X getKey() {
        return key;
    }

    public void setKey(X key) {
        this.key = key;
    }

    public Y getItem() {
        return item;
    }

    public void setItem(Y item) {
        this.item = item;
    }
}
