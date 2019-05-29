package com.practice.java.ds.stack;

@SuppressWarnings({"unchecked"})
public class DsStack<X> {

    private int stackCounter;
    private X[] stackItems;
    private int stackCapacity;

    public DsStack(int initialStackCapacity) {
        this.stackCapacity = initialStackCapacity;
        this.stackItems = (X[]) new Object[initialStackCapacity];
        this.stackCounter = -1;
    }

    public boolean push(X x) {
        if (size() == stackCapacity) {
            return false;
        }
        this.stackItems[++this.stackCounter] = x;
        return true;
    }

    public X pop() {
        if (this.stackCounter < 0) {
            return null;
        }
        return this.stackItems[this.stackCounter--];
    }

    public int size() {
        return this.stackCounter + 1;
    }

    public boolean contains(X item) {
        if (item == null) {
            return false;
        }
        for (int index = 0; index < this.stackCounter; index++) {
            if (stackItems[index].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public X access(int position) {
        if (position > this.stackCounter) {
            return null;
        }
        return stackItems[position];
    }
}
