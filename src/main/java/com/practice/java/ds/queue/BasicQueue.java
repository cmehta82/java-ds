package com.practice.java.ds.queue;

import static java.lang.System.arraycopy;

@SuppressWarnings({"unchecked", "UnusedReturnValue"})
public class BasicQueue<X> {

    private int queueEndCounter;
    private X[] queueItems;
    private int queueCapacity;

    public BasicQueue(int queueInitialCapacity) {
        this.queueCapacity = queueInitialCapacity;
        this.queueItems = (X[]) new Object[queueInitialCapacity];
        this.queueEndCounter = -1;
    }

    public int size() {
        return queueEndCounter + 1;
    }

    public boolean enQueue(X x) {
        if (size() == queueCapacity) {
            return false;
        }
        queueItems[++queueEndCounter] = x;
        return true;
    }

    public X deQueue() {
        if (size() == 0) {
            return null;
        }
        X x = queueItems[0];
        shiftQueueItems();
        return x;
    }

    private void shiftQueueItems() {
        if (queueEndCounter - 1 >= 0) {
            arraycopy(queueItems, 1, queueItems, 0, queueEndCounter);
        }
        queueItems[queueEndCounter--] = null;
    }

    public boolean contains(X item) {
        if (item == null) {
            return false;
        }
        for (int index = 0; index <= queueEndCounter; index++) {
            if (queueItems[index].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public X access(int position) {
        if (position > queueEndCounter) {
            return null;
        }
        return queueItems[position];
    }
}
