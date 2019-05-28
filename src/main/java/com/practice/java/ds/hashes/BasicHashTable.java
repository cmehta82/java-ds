package com.practice.java.ds.hashes;

@SuppressWarnings({"unchecked", "UnusedReturnValue"})
public class BasicHashTable<X, Y> {

    private HashEntry<X, Y>[] hashTableItems;
    private int hashTableCapacity;
    private int totalItems;


    public int size() {
        return this.totalItems;
    }

    public BasicHashTable(int initialHashTableCapacity) {
        this.hashTableCapacity = initialHashTableCapacity;
        this.hashTableItems = new HashEntry[initialHashTableCapacity];
        this.totalItems = 0;
    }

    private int calculateHash(X key) {
        int hash = (key.hashCode() % this.hashTableCapacity);
        while (hashTableItems[hash] != null && !hashTableItems[hash].getKey().equals(key)) {
            hash = (hash + 1) % this.hashTableCapacity;
        }
        return hash;
    }

    public Y get(X key) {
        int hash = calculateHash(key);
        HashEntry<X, Y> hashItem = hashTableItems[hash];
        if (hashItem == null) {
            return null;
        }
        return hashItem.getItem();
    }

    public void put(X key, Y item) {
        int hash = calculateHash(key);
        hashTableItems[hash] = new HashEntry<>(key, item);
        totalItems++;
    }

    public Y delete(X key) {
        Y value = get(key);

        if (value == null) {
            return null;
        }

        // shift the remaining hash items
        int hash = calculateHash(key);
        hashTableItems[hash] = null;
        totalItems--;
        hash = (hash + 1) % hashTableCapacity;

        while (hashTableItems[hash] != null) {
            HashEntry<X, Y> hashItem = hashTableItems[hash];
            hashTableItems[hash] = null;
            put(hashItem.getKey(), hashItem.getItem());
            totalItems--;
            hash = (hash + 1) % hashTableCapacity;
        }

        return value;
    }

    public boolean hasKey(X key) {
        int hash = calculateHash(key);

        HashEntry<X, Y> hashItem = hashTableItems[hash];

        return hashItem != null && hashItem.getKey().equals(key);
    }

    public boolean hasValue(Y item) {
        for (int index = 0; index < this.hashTableCapacity; index++) {
            HashEntry<X, Y> hashItem = hashTableItems[index];

            if (hashItem != null && hashItem.getItem().equals(item)) {
                return true;
            }
        }
        return false;
    }
}
