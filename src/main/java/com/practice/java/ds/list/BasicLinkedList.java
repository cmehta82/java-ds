package com.practice.java.ds.list;

@SuppressWarnings("UnusedReturnValue")
public class BasicLinkedList<X> {

    private LinkNode<X> headNode;
    private LinkNode<X> tailNode;
    private int nodeCount;

    public BasicLinkedList() {
        nodeCount = 0;
    }

    public int size() {
        return nodeCount;
    }

    public void add(X item) {
        LinkNode<X> newNode = new LinkNode<>(item);
        if (headNode == null) {
            headNode = newNode;
        } else {
            tailNode.setNextNode(newNode);
        }
        tailNode = newNode;
        nodeCount++;
    }

    public X remove() {
        if (headNode == null) {
            return null;
        }

        X item = headNode.getNodeItem();
        headNode = headNode.getNextNode();
        nodeCount--;

        return item;
    }

    public boolean insert(X item, int position) {
        if (position > size()) {
            return false;
        }

        LinkNode<X> insertAfterNode = headNode;
        for (int index = 1; index < position; index++) {
            insertAfterNode = insertAfterNode.getNextNode();
        }

        LinkNode<X> newNode = new LinkNode<>(item);
        LinkNode<X> nextNode = insertAfterNode.getNextNode();
        insertAfterNode.setNextNode(newNode);

        // re-attach the rest of the list;
        newNode.setNextNode(nextNode);

        nodeCount++;

        return true;
    }

    public X removeAt(int position) {
        if (position > size()) {
            return null;
        }

        LinkNode<X> previousToRemovedNode = headNode;
        LinkNode<X> toBeRemovedNode = headNode;

        for (int index = 1; index < position; index++) {
            previousToRemovedNode = toBeRemovedNode;
            toBeRemovedNode = toBeRemovedNode.getNextNode();
        }

        X nodeItem = toBeRemovedNode.getNodeItem();
        previousToRemovedNode.setNextNode(toBeRemovedNode.getNextNode());

        nodeCount--;
        return nodeItem;
    }


    public X get(int position) {
        if (position > size()) {
            return null;
        }

        LinkNode<X> currentNode = headNode;
        for (int index = 1; index < position; index++) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode.getNodeItem();
    }

    public int find(X item) {
        if (size() == 0 || item == null) {
            return -1;
        }

        LinkNode<X> currentNode = headNode;
        for (int index = 1; index < size(); index++) {
            if (item.equals(currentNode.getNodeItem())) {
                return index;
            }
            currentNode = currentNode.getNextNode();
        }
        return -1;
    }


}
