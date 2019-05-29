package com.practice.java.ds.hash.table;

@SuppressWarnings({"unchecked", "UnusedReturnValue"})
public class DsHashTable<X, Y> {

    private DsHashEntry<X, Y>[] dsHashEntries;
    private int hashTableCapacity;
    private int totalItems;


    public int size() {
        return this.totalItems;
    }

    public DsHashTable(int initialHashTableCapacity) {
        this.hashTableCapacity = initialHashTableCapacity;
        this.dsHashEntries = new DsHashEntry[initialHashTableCapacity];
        this.totalItems = 0;
    }

    private int calculateHash(X key) {
        int hash = (key.hashCode() % this.hashTableCapacity);
        while (dsHashEntries[hash] != null && !dsHashEntries[hash].getKey().equals(key)) {
            hash = (hash + 1) % this.hashTableCapacity;
        }
        return hash;
    }

    public Y get(X key) {
        int hash = calculateHash(key);
        DsHashEntry<X, Y> hashItem = dsHashEntries[hash];
        if (hashItem == null) {
            return null;
        }
        return hashItem.getItem();
    }

    public void put(X key, Y item) {
        int hash = calculateHash(key);
        dsHashEntries[hash] = new DsHashEntry<>(key, item);
        totalItems++;
    }

    public Y delete(X key) {
        Y value = get(key);

        if (value == null) {
            return null;
        }

        // shift the remaining hash items
        int hash = calculateHash(key);
        dsHashEntries[hash] = null;
        totalItems--;
        hash = (hash + 1) % hashTableCapacity;

        while (dsHashEntries[hash] != null) {
            DsHashEntry<X, Y> hashItem = dsHashEntries[hash];
            dsHashEntries[hash] = null;
            put(hashItem.getKey(), hashItem.getItem());
            totalItems--;
            hash = (hash + 1) % hashTableCapacity;
        }

        return value;
    }

    public boolean hasKey(X key) {
        int hash = calculateHash(key);

        DsHashEntry<X, Y> hashItem = dsHashEntries[hash];

        return hashItem != null && hashItem.getKey().equals(key);
    }

    public boolean hasValue(Y item) {
        for (int index = 0; index < this.hashTableCapacity; index++) {
            DsHashEntry<X, Y> hashItem = dsHashEntries[index];

            if (hashItem != null && hashItem.getItem().equals(item)) {
                return true;
            }
        }
        return false;
    }
}
