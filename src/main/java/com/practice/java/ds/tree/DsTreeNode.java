package com.practice.java.ds.tree;

@SuppressWarnings("WeakerAccess")
public class DsTreeNode<X> {

    private DsTreeNode<X> left;
    private DsTreeNode<X> right;
    private DsTreeNode<X> parent;
    private X item;

    public DsTreeNode(X item) {
        this.item = item;
    }

    public DsTreeNode<X> getLeft() {
        return left;
    }

    public void setLeft(DsTreeNode<X> left) {
        this.left = left;
    }

    public DsTreeNode<X> getRight() {
        return right;
    }

    public void setRight(DsTreeNode<X> right) {
        this.right = right;
    }

    public DsTreeNode<X> getParent() {
        return parent;
    }

    public void setParent(DsTreeNode<X> parent) {
        this.parent = parent;
    }

    public X getItem() {
        return item;
    }

    public void setItem(X item) {
        this.item = item;
    }
}
