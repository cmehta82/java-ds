package com.practice.java.ds.list;

@SuppressWarnings("WeakerAccess")
public class LinkNode<X> {

    private LinkNode<X> nextNode;
    private X nodeItem;

    public LinkNode(X item) {
        this.nodeItem = item;
    }

    public LinkNode<X> getNextNode() {
        return nextNode;
    }

    public void setNextNode(LinkNode<X> nextNode) {
        this.nextNode = nextNode;
    }

    public X getNodeItem() {
        return nodeItem;
    }
}
