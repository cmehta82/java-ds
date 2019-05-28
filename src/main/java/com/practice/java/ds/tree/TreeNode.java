package com.practice.java.ds.tree;

public class TreeNode<X> {

    private TreeNode<X> left;
    private TreeNode<X> right;
    private TreeNode<X> parent;
    private X item;

    public TreeNode(X item) {
        this.item = item;
    }

    public TreeNode<X> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<X> left) {
        this.left = left;
    }

    public TreeNode<X> getRight() {
        return right;
    }

    public void setRight(TreeNode<X> right) {
        this.right = right;
    }

    public TreeNode<X> getParent() {
        return parent;
    }

    public void setParent(TreeNode<X> parent) {
        this.parent = parent;
    }

    public X getItem() {
        return item;
    }

    public void setItem(X item) {
        this.item = item;
    }
}
