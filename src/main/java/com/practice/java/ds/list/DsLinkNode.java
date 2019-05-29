package com.practice.java.ds.list;

@SuppressWarnings("WeakerAccess")
public class DsLinkNode<X> {

    private DsLinkNode<X> nextNode;
    private X nodeItem;

    public DsLinkNode(X item) {
        this.nodeItem = item;
    }

    public DsLinkNode<X> getNextNode() {
        return nextNode;
    }

    public void setNextNode(DsLinkNode<X> nextNode) {
        this.nextNode = nextNode;
    }

    public X getNodeItem() {
        return nodeItem;
    }
}
